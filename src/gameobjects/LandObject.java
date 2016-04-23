package gameobjects;


public abstract class LandObject {
	protected Field field;
	
	public LandObject(Field _field) {
		field = _field;
	}
	
    public boolean stepIn(Player _player) {
        return true;
    }

    public boolean stepOut(Player _player){
        return true;
    }

    public boolean place(Player _player, ItemObject obj){
        return false;
    }

    public boolean openPortal(Portal port){
        return false;
    }

    public boolean pick(Player _player){
        return false;
    }

    public boolean hit(Bullet bul){
        return false;
    }
}
