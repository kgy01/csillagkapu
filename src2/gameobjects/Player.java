package gameobjects;
import main.*;
import utils.*;

public class Player {
	// Referencia a játékmotorra
	protected Engine engine;
	// Hely és irányadatok
	protected Coordinates position;
	protected Coordinates direction;
	// Súly
	private int weight;
	// Hátizsák
	protected ItemObject backPack;
	// A pályán van-e még a játékos
	protected boolean alive = true;
	// Felszedett ZPM-ek száma
	int noZPM = 0;
	
	public Player(Coordinates _position, Engine _engine) {
		position = _position;
		// Minding felfelé néz
		direction = new Coordinates(0,-1);
		engine = _engine;
		//  Súly ~ 80kg
		weight = 80;
	}
	
	// Játékos léptetése
	public void step(Coordinates _direction) {
		if (alive) {
		// Irányba fordítás:
		if (direction.equals(_direction)) {
			// Jelenlegi mezõ elkérése:
			Field currentfield = engine.getField(position);
			// Lépés irányába esõ mezõ referenciájának elkérése
			Field nextfield = engine.getField(position.add(direction));
			// Sikerült a léptetés
			if (nextfield.stepIn(this)) {
				// Új mezõ lekérése mégegyszer:
				nextfield = engine.getField(position.add(direction));
				// Lelépés a jelenlegi mezõrõl
				currentfield.stepOut(this);
				// Új pozíció beállítása
				position = position.add(_direction);
				// Beregisztrálás a mezõnél
				if (alive)
					nextfield.setPlayer(this);
				// Logolás
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
	
	// Üres-e a hátizsák
    public boolean isBackpackEmpty() {
    	return (backPack == null);
    }
    
    // Beleteszünk valamit a hátizsákba
    public boolean pushBackpack(ItemObject _item) {
    	if (backPack == null) {
    		backPack = _item;
    		System.out.println("OK typ:" + _item.toStringVerbose() + " des:backpack");
    		return true;
    	}
    	return false;
    }
    
    // Tárgy felvétele az elõttünk levõ mezõrõl
    public void pick() {
    	Field nextfield = engine.getField(new Coordinates(position.getX() + direction.getX(), position.getY() + direction.getY()));
    	if (!nextfield.pick(this))
    		System.out.println("FAILED");
    }
    
    // Tárgy elhelyezése a játékos elõtt lévõ mezõn
    public void place() {
    	Field nextfield = engine.getField(new Coordinates(position.getX() + direction.getX(), position.getY() + direction.getY()));
    	if (nextfield.place(this, backPack)) {
    		System.out.println("OK typ:" + backPack.toStringVerbose());
    		// A letett doboznak beállítjuk a mezõt
    		//backPack.setField(nextfield);
    		backPack = null;
    		return;
    	}
    	System.out.println("FAILED");
    }
	
	// Pozíció lekérdezése:
	public Coordinates getPosition() {
		return position;
	}
	// Pozíció beállítása:
	public void setPosition(Coordinates _position) {
        position = _position;
    }
	// Irány lekérdezése
    public Coordinates getDirection() {
        return direction;
    }
    // Irány beállítása
    public void setDirection(Coordinates _direction) {
        direction = _direction;
    }
    // Súly lekérdezése
    public int getWeight() {
    	return weight;
    }
    
    public void die() {
    	System.out.println("FELT ply:" + toStringVerbose());
    	alive = false;
        //throw new ColonelIsDeadException();
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
}
