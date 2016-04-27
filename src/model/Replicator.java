package model;

import java.util.Random;

import controller.Engine;
import utils.Coordinates;

public class Replicator extends Player {
	public Replicator(Coordinates _position, Engine _engine) {
		super(_position, _engine);
	}
	
	// Replicator l�ptet�se
		public void step(Coordinates _direction) {
			if (alive) {
				direction = _direction;
				// L�p�s ir�ny�ba es� mez� referenci�j�nak elk�r�se
				Field nextfield = engine.getField(position.add(direction));
				// Siker�lt a l�ptet�s
				Field currentfield = engine.getField(position);
				if (nextfield.stepIn(this)) {
					nextfield = engine.getField(position.add(direction));
					// Lel�p�s a jelenlegi mez�r�l
					currentfield.unsetReplicator();
					// �j poz�ci� be�ll�t�sa
					position = position.add(direction);
					if (alive)
						nextfield.setReplicator(this);
					// Logol�s
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
	
		// Replicator v�letlenszer� l�ptet�se
				public void step() {
					if (alive) {
						// V�letlen ir�ny megad�sa:
						Random rand = new Random();
						direction = new Coordinates(rand.nextInt(3)-1,rand.nextInt(3)-1);
						//System.out.println(_direction.toString());
						// L�p�s ir�ny�ba es� mez� referenci�j�nak elk�r�se
						// L�p�s ir�ny�ba es� mez� referenci�j�nak elk�r�se
						Field nextfield = engine.getField(position.add(direction));
						// Siker�lt a l�ptet�s
						Field currentfield = engine.getField(position);
						if (nextfield.stepIn(this)) {
							nextfield = engine.getField(position.add(direction));
							// Lel�p�s a jelenlegi mez�r�l
							currentfield.unsetReplicator();
							// �j poz�ci� be�ll�t�sa
							position = position.add(direction);
							if (alive)
								nextfield.setReplicator(this);
							// Logol�s
							System.out.println("OK pos:" + position.toString());
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
		position = position.add(direction);
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
