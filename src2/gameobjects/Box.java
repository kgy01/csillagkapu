package gameobjects;

import utils.*;

public class Box extends ItemObject {
	
	//Constructor
	public Box(){ };
	
	
	// False-al jelezzuk, hogy at lehet loni rajta
	/*@Override
	public boolean hit(Bullet bul){
		beginFunction();
		return false;
	}*/
	
	// False-al jelezzuk, hogy nem lehet masik targyat lerakni
	@Override
	public boolean place(ItemObject object){
		Logger.inFunction("-->[Box:]place(ItemObject)");
		Logger.outFunction("<--[Box:]false");
		return false;
	}
	
	// Ha ures az ezredes hatizsakja, felvesszuk a dobozt
	@Override
	public boolean pick(Colonel col){
		Logger.inFunction("-->[Box:]pick(Colonel)");
		boolean ret = col.isBackpackEmpty();
		Logger.outFunction("<--[Box:]" + ret);
		return ret;
	}
	
	// False-al jelezzuk, hogy nem lehet a dobozt tartalmazo mezore lepni
	@Override
	public boolean stepIn(Colonel col){
		Logger.inFunction("-->[Box:]stepIn(Colonel)");
		Logger.outFunction("<--[Box:]false");
		return false;
	}
}