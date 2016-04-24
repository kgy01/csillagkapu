package gameobjects;

import java.util.Random;

import main.Engine;
import utils.Coordinates;

public class Replicator extends Player {
	public Replicator(Coordinates _position, Engine _engine) {
		super(_position, _engine);
	}
	
	// Replicator léptetése
		public void step(Coordinates _direction) {
			if (alive) {
				// Véletlen irány megadása:
				if (_direction.equals(new Coordinates(0,0))) {
					Random rand = new Random();
					_direction = new Coordinates(rand.nextInt(3)-1,rand.nextInt(3)-1);
					System.out.println(_direction.toString());
				}
				// Lépés irányába esõ mezõ referenciájának elkérése
				Field nextfield = engine.getField(position.add(_direction));
				// Sikerült a léptetés
				Field currentfield = engine.getField(position);
				if (nextfield.stepIn(this)) {
					nextfield = engine.getField(position.add(_direction));
					// Lelépés a jelenlegi mezõrõl
					currentfield.unsetReplicator();
					// Új pozíció beállítása
					position = position.add(_direction);
					direction = _direction;
					if (alive)
						nextfield.setReplicator(this);
					// Logolás
					System.out.println("OK pos:" + position.toString());
				}
				else {
					System.out.println("FAILED");
				}
			}
			else {
				System.out.println("DIED");
			}
		}
	
		// Replicator véletlenszerû léptetése
				public void step() {
					if (alive) {
						// Véletlen irány megadása:
						Random rand = new Random();
						Coordinates _direction = new Coordinates(rand.nextInt(3)-1,rand.nextInt(3)-1);
						//System.out.println(_direction.toString());
						// Lépés irányába esõ mezõ referenciájának elkérése
						Field nextfield = engine.getField(position.add(_direction));
						// Sikerült a léptetés
						if (nextfield.stepIn(this)) {
							// Lelépés a jelenlegi mezõrõl
							engine.getField(position).unsetReplicator();
							// Új pozíció beállítása
							position = position.add(_direction);
							direction = _direction;
							if (alive)
								nextfield.setReplicator(this);
							// Logolás
							//System.out.println("OK pos:" + position.toString());
						}
						else {
							//System.out.println("FAILED");
						}
					}
					else {
						//System.out.println("DIED");
					}
				}
	
	@Override	
	public String toString() {
		return "?";
	}
	
	@Override
	public void die() {
    	//Logger.inFunction("-->[Colonel:]die()");
    	//Logger.outFunction("<--[Colonel:]");
    	alive = false;
    	System.out.println("FELT ply:replicator pos:"+ position.toString());
    	engine.getField(position.add(direction)).setLandObject(null);
        //throw new ColonelIsDeadException();
    }
	
	@Override
	public boolean hit(Bullet _bul) {
		alive = false;
		engine.getField(position).unsetReplicator();
		System.out.println("DIED ply:replicator");
    	return true;
    }
}
