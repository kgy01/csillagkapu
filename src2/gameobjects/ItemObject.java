package gameobjects;

public abstract class ItemObject {
    public boolean hit(Bullet bul) { return false; }

    public boolean place(ItemObject object){
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
}
