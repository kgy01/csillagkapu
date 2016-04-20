package gameobjects;


public abstract class LandObject {
    public boolean stepIn(Player _player) {
        return true;
    }

    public boolean stepOut(Player _player){
        return true;
    }

    public boolean place(ItemObject obj){
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
