package gameobjects;


public class Pit extends LandObject {
	
	// Constructor
	public Pit(Field _field){
		super(_field);
	}
	
	// False-al jelezzuk, hogy at lehet loni rajta
	@Override
	public boolean hit(Bullet bul){
		return false;
	}
	
	// Jelezzuk az ezredesnek, hogy le lehet helyezni a targyat
	@Override
	public boolean place(Player _player, ItemObject object){
		System.out.println("FELT typ:" + object.toStringVerbose());
		field.skipItemObject();
		return true;
	}
	
	// Jelezzuk, hogy ra lehet lepni es megoljuk az ezredest
	@Override
	public boolean stepIn(Player _player) {
		//Logger.inFunction("-->[Pit:]stepIn(Colonel)");
		_player.die();
		//Logger.outFunction("<--[Pit:]true");
		return true;
	}
	
	@Override
	public String toString() {
		return "!";
	}
}
