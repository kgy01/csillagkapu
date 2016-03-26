package malmo.csillagkapu.gameobject;

import malmo.csillagkapu.util.ColonelIsDeadException;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public abstract class LandObject {
    public boolean stepIn(Colonel col) throws ColonelIsDeadException {
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
