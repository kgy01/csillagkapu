package model;
import controller.*;
import utils.*;

public class Player {
	// Referencia a j�t�kmotorra
	protected Engine engine;
	// Hely �s ir�nyadatok
	protected Coordinates position;
	protected Coordinates direction;
	// S�ly
	private int weight;
	// H�tizs�k
	protected ItemObject backPack;
	// A p�ly�n van-e m�g a j�t�kos
	protected boolean alive = true;
	// Felszedett ZPM-ek sz�ma
	int noZPM = 0;
	
	public Player(Coordinates _position, Engine _engine) {
		position = _position;
		// Minding felfel� n�z
		direction = new Coordinates(0,-1);
		engine = _engine;
		//  S�ly ~ 80kg
		weight = 80;
	}
	
	// J�t�kos l�ptet�se
	public void step(Coordinates _direction) {
		if (alive) {
		// Ir�nyba ford�t�s:
		if (direction.equals(_direction)) {
			// Jelenlegi mez� elk�r�se:
			Field currentfield = engine.getField(position);
			// L�p�s ir�ny�ba es� mez� referenci�j�nak elk�r�se
			Field nextfield = engine.getField(position.add(direction));
			// Siker�lt a l�ptet�s
			if (nextfield.stepIn(this)) {
				// �j mez� lek�r�se m�gegyszer:
				nextfield = engine.getField(position.add(direction));
				// Lel�p�s a jelenlegi mez�r�l
				currentfield.stepOut(this);
				// �j poz�ci� be�ll�t�sa
				position = position.add(direction);
				// Beregisztr�l�s a mez�n�l
				if (alive)
					nextfield.setPlayer(this);
				// Logol�s
				System.out.println("OK pos:" + position.toString() + " dir:" + direction.toStringVerbose());
			}
			else {
				System.out.println("FAILED");
			}
		}
		else {
			direction = _direction;
			System.out.println("OK pos:" + position.toString() + " dir:" + direction.toStringVerbose());
		}
		}
		else {
			System.out.println("DIED");
		}
	}
	
	// �res-e a h�tizs�k
    public boolean isBackpackEmpty() {
    	return (backPack == null);
    }
    
    // Beletesz�nk valamit a h�tizs�kba
    public boolean pushBackpack(ItemObject _item) {
    	if (backPack == null) {
    		backPack = _item;
    		System.out.println("OK typ:" + _item.toStringVerbose() + " des:backpack");
    		return true;
    	}
    	return false;
    }
    
    // T�rgy felv�tele az el�tt�nk lev� mez�r�l
    public void pick() {
		Coordinates  nextPos =new Coordinates(position.getX() + direction.getX(), position.getY() + direction.getY());
    	Field nextfield = engine.getField(nextPos);
    	if (!nextfield.pick(this)) {
			System.out.println("FAILED");
		}else{
			MainController.getInstance().baseMapController.fieldItemChange(nextPos);
		}
    }
    
    // T�rgy elhelyez�se a j�t�kos el�tt l�v� mez�n
    public void place() {
		Coordinates  nextPos =new Coordinates(position.getX() + direction.getX(), position.getY() + direction.getY());
    	Field nextfield = engine.getField(nextPos);
    	if (!nextfield.place(this, backPack)) {
			System.out.println("FAILED");
    	} else {
			System.out.println("OK typ:" + backPack.toStringVerbose());
			// A letett doboznak be�ll�tjuk a mez�t
			//backPack.setField(nextfield);
			backPack = null;
			MainController.getInstance().baseMapController.fieldItemChange(nextPos);
		}

    }
	
	// Poz�ci� lek�rdez�se:
	public Coordinates getPosition() {
		return position;
	}
	// Poz�ci� be�ll�t�sa:
	public void setPosition(Coordinates _position) {
        position = _position;
    }
	// Ir�ny lek�rdez�se
    public Coordinates getDirection() {
        return direction;
    }
    // Ir�ny be�ll�t�sa
    public void setDirection(Coordinates _direction) {
        direction = _direction;
    }
    // S�ly lek�rdez�se
    public int getWeight() {
    	return weight;
    }
    
    public void die() {
    	System.out.println("FELT ply:" + toStringVerbose());
    	alive = false;
        //throw new ColonelIsDeadException();
    }
    
    // Aktiv-e a jatekos
    public boolean isAlive() {
    	return alive;
    }
    
    public boolean addZPM() {
    	return false;
    }
    
    public void showInventory() {
    	System.out.println("Direction: " + direction.toStringVerbose());
    	System.out.println("ZPMs: " + noZPM);
    	if (isBackpackEmpty())
    		System.out.println("BPack: empty");
    	else
    		System.out.println("BPack: " + backPack.toStringVerbose());
    }
    
    public String toStringVerbose() {
    	return "Player";
    }
    
    public boolean hit(Bullet _bul) {
    	Portal.teleport(this, _bul);
    	return true;
    }
    
    // Begyujtott ZPMek sz�ma
    public int getNOZPMs() {
    	return noZPM;
    }
}
