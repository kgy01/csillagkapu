package gameobjects;

import utils.Logger;

public class SpecialWall extends Wall {
	
	public SpecialWall(Field _field) {
		super(_field);
	}
	
	@Override
	public boolean hit(Bullet bul){
		Portal.open(bul);
		return true;
	}
	@Override
	public String toString() {
		return "@";
	}
	
	public String toStringVerbose() {
		return "SpecialWall";
	}
}
