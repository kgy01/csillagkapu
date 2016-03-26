package malmo.csillagkapu.gameobject;

import malmo.csillagkapu.util.ColonelIsDeadException;

import static malmo.csillagkapu.util.Logger.*;

/**
 * Szakadekot megvalosito osztaly
 */

public class Pit extends LandObject {
	
	// Constructor
	public Pit(){ }
	
	// False-al jelezzuk, hogy at lehet loni rajta
	@Override
	public boolean hit(Bullet bul){
		beginFunction();
		return ret(false);
	}
	
	// Jelezzuk az ezredesnek, hogy le lehet helyezni a targyat
	@Override
	public boolean place(ItemObject object){
		beginFunction();
		return ret(true);
	}
	
	// Jelezzuk, hogy ra lehet lepni es megoljuk az ezredest
	@Override
	public boolean stepIn(Colonel col) throws ColonelIsDeadException{
		beginFunction();
		col.die();
		return ret(true);
	}
}
