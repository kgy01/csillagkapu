package malmo.csillagkapu.gameobject;

/**
 * Created by Győző on 2016. 03. 26..
 */
import static malmo.csillagkapu.util.Logger.*; //ezt minden osztalyba tegyetek bele

public class Scale extends LandObject {
    private Door door;

    public Scale(Door _door){
        beginFunction();
        door = _door;
        endFunction("");
    }
    @Override
    public boolean stepIn(Colonel col) {
        return false;
    }

    @Override
    public boolean stepOut(Colonel col) {
        return false;
    }

    @Override
    public boolean place(ItemObject obj) {
        return false;
    }

    @Override
    public boolean openPortal(Portal port) {
        return false;
    }

    @Override
    public boolean pick(Colonel col) {
        return false;
    }

    @Override
    public boolean hit(Bullet bul) {
        return false;
    }

    public Door createDoor(){
        return door = new Door(this);
    }
}
