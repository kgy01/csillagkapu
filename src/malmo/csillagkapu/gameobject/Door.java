package malmo.csillagkapu.gameobject;

/**
 * Created by Győző on 2016. 03. 26..
 */
import static malmo.csillagkapu.util.Logger.*; //ezt minden osztalyba tegyetek bele

public class Door extends LandObject {
    private Scale scale;
    private boolean isClosed;

    public Door() {}

    public Door(Scale _scale){
        scale = _scale;
    }
 
    @Override
    public boolean stepIn(Colonel col) {
        beginFunction();
        return ret(false);
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

    public void open(){
        beginFunction();
        isClosed = false;
        endFunction("");
    }

    public void close(){
        beginFunction();
        isClosed = true;
        endFunction("");
    }

    public Scale createScale(){
        beginFunction();
        scale =  new Scale(this);
        return ret(scale);
    }
}
