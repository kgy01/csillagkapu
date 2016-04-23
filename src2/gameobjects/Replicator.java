package gameobjects;

import main.Engine;
import utils.Coordinates;
import utils.Logger;

public class Replicator extends Player {
	public Replicator(Coordinates _position, Engine _engine) {
		super(_position, _engine);
	}
	
	// Replicator léptetése
		public void step(Coordinates _direction) {
			if (alive) {
				// Lépés irányába esõ mezõ referenciájának elkérése
				Field nextfield = engine.getField(new Coordinates(position.getX() + _direction.getX(), position.getY() + _direction.getY()));
				// Sikerült a léptetés
				if (nextfield.stepIn(this)) {
					// Lelépés a jelenlegi mezõrõl
					engine.getField(position).unsetReplicator();
					// Új pozíció beállítása
					position.setX(position.getX() + _direction.getX());
					position.setY(position.getY() + _direction.getY());
					if (alive)
						nextfield.setReplicator(this);
					// Logolás
					System.out.println("OK pos:" + position.toString() + " dir:" + direction.toStringVerbose());
				}
				else {
					System.out.println("FAILED");
				}
			}
			else {
				System.out.println("DIED");
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
    	System.out.println("FELT ply:replicator");
    	engine.getField(position).setLandObject(null);
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
