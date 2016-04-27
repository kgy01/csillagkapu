package model;

public class Box extends ItemObject {
	// St�colhat�s�g
	private int heap = 1;
	
	//Constructor
	public Box(Field _field){
		super(_field);
	};
	
	
	// False-al jelezzuk, hogy at lehet loni rajta
	/*@Override
	public boolean hit(Bullet bul){
		beginFunction();
		return false;
	}*/
	
	// False-al jelezzuk, hogy nem lehet masik targyat lerakni
	@Override
	public boolean place(Player _player, ItemObject object){
		++heap;
		System.out.println("No Boxes:" + heap);
		return true;
	}
	
	// Ha ures az ezredes hatizsakja, felvesszuk a dobozt
	@Override
	public boolean pick(Player _player){
		//Logger.inFunction("-->[Box:]pick(Colonel)");
		if (heap > 1) {
			if (_player.pushBackpack(new Box(null))) {
				field.skipItemObject();
				--heap;
				return true;
			}
			else {
				return false;
			}
		}
		return _player.pushBackpack(this);
	}
	
	// False-al jelezzuk, hogy nem lehet a dobozt tartalmazo mezore lepni
	@Override
	public boolean stepIn(Player _player){
		return false;
	}
	
	@Override
	public String toString() {
		return "&";
	}
	
	@Override
	public String toStringVerbose() {
		return "Box";
	}
	
	// S�ly lek�rdez�se
	@Override
	public int getWeight() {
		return heap*10;
	}
}