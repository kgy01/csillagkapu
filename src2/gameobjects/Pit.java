package gameobjects;

import utils.Logger;

public class Pit extends LandObject {
	
	// Constructor
	public Pit(){
		super();
	}
	
	// False-al jelezzuk, hogy at lehet loni rajta
	@Override
	public boolean hit(Bullet bul){
		Logger.inFunction("-->[Pit:]hit(Bullet)");
		Logger.outFunction("<--[Pit:]false");
		return false;
	}
	
	// Jelezzuk az ezredesnek, hogy le lehet helyezni a targyat
	@Override
	public boolean place(ItemObject object){
		Logger.inFunction("-->[Pit:]place(ItemObject)");
		Logger.outFunction("<--[Pit:]true");
		return true;
	}
	
	// Jelezzuk, hogy ra lehet lepni es megoljuk az ezredest
	@Override
	public boolean stepIn(Colonel col) {
		Logger.inFunction("-->[Pit:]stepIn(Colonel)");
		col.die();
		Logger.outFunction("<--[Pit:]true");
		return true;
	}
}
