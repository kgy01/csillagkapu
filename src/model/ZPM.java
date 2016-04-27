package model;


public class ZPM extends ItemObject {
	
	//Meg felveheto ZPM modulok szama
	private static int zpmCount = 0;
	
	// Constructor, letrehozasnal noveljuk a szamlalot 1-el
	public ZPM(Field _field){
		super(_field);
		zpmCount++;
	}
	
	// False-al jelezzuk, hogy at lehet loni rajta
	@Override
	public boolean hit(Bullet bul){
		//Logger.inFunction("-->[ZPM:]hit(Bullet)");
		//Logger.outFunction("<--[ZPM:]false");
		return false;
	}
	
	// False-al jelezzuk, hogy nem lehet masik targyat lerakni
	@Override
	public boolean place(Player _player, ItemObject object){
		//Logger.inFunction("-->[ZPM:]place(ItemObject)");
		//Logger.outFunction("<--[ZPM:]false");
		return false;
	}
	
	// ZPM felvetele (szamlalot csokkentjuk 1-el)
	@Override
	public boolean pick(Player _player){
		_player.addZPM();
		System.out.println("OK typ:ZPM");
		zpmCount--;
		return true;
	}
	
	// ZPM-et tartalmazo mezore lepve felvesszuk a ZPM-et (szamlalot csokkentjuk 1-el)
	@Override
	public boolean stepIn(Player _player){
		if (_player.addZPM()) {
			zpmCount--;
			System.out.println("ZPM added to " + _player.toStringVerbose());
		}
		else {
			field.skipItemObject();
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "$";
	}
	
	// ZPM-ek szamanak visszaadasa
	public static int getZPMCount() {
		return zpmCount;
	}
}
