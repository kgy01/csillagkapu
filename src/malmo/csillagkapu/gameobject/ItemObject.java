package malmo.csillagkapu.gameobject;

import malmo.csillagkapu.util.ColonelIsDeadException;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public abstract class ItemObject {
    public boolean hit(Bullet bul) { return false; }

    public boolean place(ItemObject object){
        return false;
    }

    public boolean pick(Colonel col){
        return false;
    }

    public boolean stepIn(Colonel col) throws ColonelIsDeadException {
        return false;
    }
}
