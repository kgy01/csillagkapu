package gameobjects;

import main.Engine;

public abstract class ItemObject {
	protected Field field;
	//public static Engine engine;
	
	public ItemObject(Field _field) {
		field = _field;
	}
	
    public boolean hit(Bullet bul) { return false; }

    public boolean place(Player _player, ItemObject object){
        return false;
    }

    public boolean pick(Player _player){
        return false;
    }

    public boolean stepIn(Player _player) {
        return false;
    }
    
    public String toStringVerbose() {
    	return "ItemObject";
    }
    
    // S�ly lek�rdez�se
    public int getWeight() {
    	return 0;
    }
    
    // Mez� be�ll�t�sa
    public void setField(Field _field) {
    	field = _field;
    }
    
    public Field getField() {
    	return field;
    }
}
