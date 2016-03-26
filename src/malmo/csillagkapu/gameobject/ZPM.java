package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

/**
 * ZPM modult megvalosito osztaly
 */

public class ZPM extends ItemObject {
	
	//Meg felveheto ZPM modulok szama
	public static int zpmCount = 0;
	
	// Constructor, letrehozasnal noveljuk a szamlalot 1-el
	public ZPM(){
		zpmCount++;
	}
	
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
	
	// ZPM felvetele (szamlalot csokkentjuk 1-el)
	@Override
	public boolean pick(Colonel col){
		beginFunction();
		zpmCount++;
		return ret(true);
	}
	
	// ZPM-et tartalmazo mezore lepve felvesszuk a ZPM-et (szamlalot csokkentjuk 1-el)
	@Override
	public boolean stepIn(Colonel col){
		beginFunction();
		zpmCount++;
		return ret(false);
	}
}
