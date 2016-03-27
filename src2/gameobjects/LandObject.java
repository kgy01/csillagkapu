package gameobjects;


public abstract class LandObject {
    public boolean stepIn(Colonel col) {
        return true;
    }

    public boolean stepOut(Colonel col){
        return true;
    }

    public boolean place(ItemObject obj){
        return false;
    }

    public boolean openPortal(Portal port){
        return false;
    }

    public boolean pick(Colonel col){
        return false;
    }

    public boolean hit(Bullet bul){
        return false;
    }
}
