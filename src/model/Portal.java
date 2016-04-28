package model;

import controller.AnimationController;
import controller.Engine;
import controller.Main;
import controller.MainController;
import utils.*;

import static utils.MyColor.*;

public class Portal extends ItemObject {
    // Portal sz�nek

    // Port�lok
	static Portal bluePortal;
    static Portal yellowPortal;
    static Portal redPortal;
    static Portal greenPortal;
    // Engine
    public static Engine engine;
    private Coordinates position;
    private Coordinates direction;
    private MyColor color;

    public Coordinates getPosition() {
        return position;
    }

    public Coordinates getDirection() {
        return direction;
    }

    public Portal(Field _field, Coordinates _position, Coordinates _direction, MyColor _color) {
        super(_field);
    	position = _position;
        direction = _direction.negate();
        color = _color;
    }

    private Field getFacingField() {
    	return engine.getField(position.add(direction));
    }

    private Portal getOtherPortal() {
        switch (color) {
        case BLUE:
        	return yellowPortal;
        case YELLOW:
        	return bluePortal;
        case RED:
        	return greenPortal;
        default:
        	return redPortal;
        }
    }
    
    private static Portal getOtherPortal(MyColor color) {
    	switch (color) {
        case BLUE:
        	return yellowPortal;
        case YELLOW:
        	return bluePortal;
        case RED:
        	return greenPortal;
        default:
        	return redPortal;
        }
    }
    
    private static Portal getPortal(MyColor color) {
    	switch (color) {
        case BLUE:
        	return bluePortal;
        case YELLOW:
        	return yellowPortal;
        case RED:
        	return redPortal;
        default:
        	return greenPortal;
        }
    }

    @Override
    public boolean stepIn(Player _player) {
    	Portal other = getOtherPortal();
    	if (other == null)
    		return false;
    	if (direction.negate().equals(_player.getDirection()) && other.getFacingField().stepIn(_player)) {
    		// �j poz�ci� be�ll�t�sa a j�t�kosnak
    		_player.setPosition(other.getPosition());
    		_player.setDirection(other.getDirection());
    		//_player.step(other.getDirection());
    		// Ne t�r�lje a mez� a port�lt
    		field.skipItemObject();
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean place(Player _player, ItemObject _item) {
    	Portal other = getOtherPortal();
    	if (other == null)
    		return false;
    	if (direction.negate().equals(_player.getDirection()) && other.getFacingField().place(_player, _item)) {
    		// Ne t�r�lje a mez� a port�lt
    		_item.setField(other.getFacingField());
    		//field.skipItemObject();
    		return true;
    	}
    	return false;
    }
    
    @Override
    public boolean pick(Player _player) {
    	Portal other = getOtherPortal();
    	if (other == null)
    		return false;
    	if (direction.negate().equals(_player.getDirection()) && other.getFacingField().pick(_player)) {
    		// Ne t�r�lje a mez� a port�lt
    		field.skipItemObject();
    		return true;
    	}
    	return false;
    }
    
    // 
    @Override
    public boolean hit(Bullet _bul) {
    	Portal other = getOtherPortal();
    	if (other == null)
    		return true;
    	if (direction.negate().equals(_bul.getDirection()) && !other.getFacingField().hit(_bul)) {
    		// L�ved�k poz�ci�j�nak, ir�ny�nak �t�ll�t�sa
    		_bul.setPosition(other.getPosition());
    		_bul.setDirection(other.getDirection());
    		// Ne t�r�lje a mez� a port�lt
    		//field.skipItemObject();
    		return false;
    	}
    	return true;
    }
    
    // Port�l nyit�sa
    public static void open(Bullet bul) {
		AnimationController animationController = MainController.getInstance().animationController;
    	Field newfield = engine.getField(bul.getPosition());
    	System.out.println("PORTAL OPENED col:" + bul.toString());
    	switch (bul.getColor()) {
    	case BLUE:
    		if (bluePortal != null) {
    			bluePortal.remove();
    		}
    		bluePortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), BLUE);
			animationController.portalEventHandler(bul.getPosition(),bul.getDirection(),BLUE);
    		newfield.setItemObject(bluePortal);
    		break;
    	case YELLOW:
    		if (yellowPortal != null) {
    			yellowPortal.remove();
    		}
    		yellowPortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), YELLOW);
			animationController.portalEventHandler(bul.getPosition(),bul.getDirection(),YELLOW);
    		newfield.setItemObject(yellowPortal);
    		break;
    	case RED:
    		if (redPortal != null) {
    			redPortal.remove();
    		}
    		redPortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), RED);
			animationController.portalEventHandler(bul.getPosition(),bul.getDirection(),RED);
    		newfield.setItemObject(redPortal);
    		break;
		case GREEN:
			if (greenPortal != null) {
				greenPortal.remove();
			}
			greenPortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), GREEN);
			animationController.portalEventHandler(bul.getPosition(),bul.getDirection(),GREEN);
			newfield.setItemObject(greenPortal);
			break;
    	}   
    }
    
    // J�t�kos teleport�l�sa
    public static void teleport(Player _player, Bullet _bul) {
    	Portal other = getPortal(_bul.getColor());
    	if (other == null)
    		return;
    	if (other.getFacingField().stepIn(_player)) {
    		// J�t�kos ledob�sa a jelenlegi mez�j�r�l
    		engine.getField(_player.getPosition()).setPlayer(null);
    		// �j poz�ci� be�ll�t�sa a j�t�kosnak
    		_player.setPosition(other.getPosition());
    		_player.setDirection(other.getDirection());
    		// Ne t�r�lje a mez� a port�lt
    		System.out.println("TELEPORT ply:" + _player.toStringVerbose());
    		_player.step(other.getDirection());
    	}
    }
    
    // Kiregisztr�lja mag�t a port�l a jelenlegi mez�j�r�l:
    public void remove() {
    	field.setItemObject(null);
    }
    
    public String toString() {
		switch (color) {
		case BLUE:
			return "[";
		case YELLOW:
			return "]";
		case RED:
			return "{";
		case GREEN:
			return "}";
		}
		return "";
	}
    
    public String toStringVerbose() {
		switch (color) {
		case BLUE:
			return "blue";
		case YELLOW:
			return "yellow";
		case RED:
			return "red";
		case GREEN:
			return "green";
		}
		return "";
	}
}
