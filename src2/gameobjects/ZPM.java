package gameobjects;

import utils.Logger;

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
		Logger.inFunction("-->[ZPM:]hit(Bullet)");
		Logger.outFunction("<--[ZPM:]false");
		return false;
	}
	
	// False-al jelezzuk, hogy nem lehet masik targyat lerakni
	@Override
	public boolean place(ItemObject object){
		Logger.inFunction("-->[ZPM:]place(ItemObject)");
		Logger.outFunction("<--[ZPM:]false");
		return false;
	}
	
	// ZPM felvetele (szamlalot csokkentjuk 1-el)
	@Override
	public boolean pick(Colonel col){
		Logger.inFunction("-->[ZPM:]pick(Colonel)");
		Logger.log("[i/n*] Utolsó felvehető ZMP?");
		if (Logger.readKey() == 'i')
			col.die();
		Logger.outFunction("<--[ZPM:]true");
		return true;
	}
	
	// ZPM-et tartalmazo mezore lepve felvesszuk a ZPM-et (szamlalot csokkentjuk 1-el)
	@Override
	public boolean stepIn(Colonel col){
		Logger.inFunction("-->[ZPM:]stepIn(Colonel)");
		Logger.log("[i/n*] Utolsó felvehető ZMP?");
		if (Logger.readKey() == 'i')
			col.die();
		Logger.outFunction("<--[ZPM:]true");
		return true;
	}
}
