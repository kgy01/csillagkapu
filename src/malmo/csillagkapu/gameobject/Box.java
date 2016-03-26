package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

/**
 * Dobozt megvalosito osztaly
 */

public class Box extends ItemObject {
	
	//Constructor
	public Box(){ };
	
	
	// False-al jelezzuk, hogy at lehet loni rajta
	@Override
	public boolean hit(Bullet bul){
		beginFunction();
		return ret(false);
	}
	
	// False-al jelezzuk, hogy nem lehet masik targyat lerakni
	@Override
	public boolean place(ItemObject object){
		beginFunction();
		return ret(false);
	}
	
	// Ha ures az ezredes hatizsakja, felvesszuk a dobozt
	@Override
	public boolean pick(Colonel col){
		beginFunction();
		if(col.backpack.isEmpty()){
			return ret(true);
		}
		else{
			return ret(false);
		}
	}
	
	// False-al jelezzuk, hogy nem lehet a dobozt tartalmazo mezore lepni
	@Override
	public boolean stepIn(Colonel col){
		beginFunction();
		return ret(false);
	}
}