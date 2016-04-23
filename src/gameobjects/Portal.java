package gameobjects;

import main.Engine;
import utils.*;

public class Portal extends ItemObject {
    // Portal színek
	public static final int BLUE = 0;
	public static final int YELLOW = 1;
	public static final int RED = 2;
	public static final int GREEN = 3;
    // Portálok
	static Portal bluePortal;
    static Portal yellowPortal;
    static Portal redPortal;
    static Portal greenPortal;
    // Engine
    public static Engine engine;
    private Coordinates position;
    private Coordinates direction;
    private int color;

    public Coordinates getPosition() {
        return position;
    }

    public Coordinates getDirection() {
        return direction;
    }

    public Portal(Field _field, Coordinates _position, Coordinates _direction, int _color) {
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
    
    private static Portal getOtherPortal(int color) {
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
    
    private static Portal getPortal(int color) {
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
    		// Új pozíció beállítása a játékosnak
    		_player.setPosition(other.getPosition());
    		_player.setDirection(other.getDirection());
    		// Ne törölje a mezõ a portált
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
    		// Ne törölje a mezõ a portált
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
    		// Ne törölje a mezõ a portált
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
    		// Lövedék pozíciójának, irányának átállítása
    		_bul.setPosition(other.getPosition());
    		_bul.setDirection(other.getDirection());
    		// Ne törölje a mezõ a portált
    		//field.skipItemObject();
    		return false;
    	}
    	return true;
    }
    
    // Portál nyitása
    public static void open(Bullet bul) {
    	Field newfield = engine.getField(bul.getPosition());
    	System.out.println("PORTAL OPENED col:" + bul.toString());
    	switch (bul.getColor()) {
    	case BLUE:
    		if (bluePortal != null) {
    			bluePortal.remove();
    		}
    		bluePortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), BLUE);
    		newfield.setItemObject(bluePortal);
    		break;
    	case YELLOW:
    		if (yellowPortal != null) {
    			yellowPortal.remove();
    		}
    		yellowPortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), YELLOW);
    		newfield.setItemObject(yellowPortal);
    		break;
    	case RED:
    		if (redPortal != null) {
    			redPortal.remove();
    		}
    		redPortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), RED);
    		newfield.setItemObject(redPortal);
    		break;
		case GREEN:
			if (greenPortal != null) {
				greenPortal.remove();
			}
			greenPortal = new Portal(newfield,bul.getPosition(),bul.getDirection(), GREEN);
			newfield.setItemObject(greenPortal);
			break;
    	}   
    }
    
    // Játékos teleportálása
    public static void teleport(Player _player, Bullet _bul) {
    	Portal other = getPortal(_bul.getColor());
    	if (other == null)
    		return;
    	if (other.getFacingField().stepIn(_player)) {
    		// Játékos ledobása a jelenlegi mezõjérõl
    		engine.getField(_player.getPosition()).setPlayer(null);
    		// Új pozíció beállítása a játékosnak
    		_player.setPosition(other.getPosition());
    		_player.setDirection(other.getDirection());
    		// Ne törölje a mezõ a portált
    		System.out.println("TELEPORT ply:" + _player.toStringVerbose());
    		_player.step(other.getDirection());
    	}
    }
    
    // Kiregisztrálja magát a portál a jelenlegi mezõjérõl:
    public void remove() {
    	field.setItemObject(null);
    }
    
    public String toString() {
		switch (color) {
		case Portal.BLUE:
			return "[";
		case Portal.YELLOW:
			return "]";
		case Portal.RED:
			return "{";
		case Portal.GREEN:
			return "}";
		}
		return "";
	}
    
    public String toStringVerbose() {
		switch (color) {
		case Portal.BLUE:
			return "blue";
		case Portal.YELLOW:
			return "yellow";
		case Portal.RED:
			return "red";
		case Portal.GREEN:
			return "green";
		}
		return "";
	}
}
