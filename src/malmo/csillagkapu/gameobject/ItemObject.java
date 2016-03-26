package malmo.csillagkapu.gameobject;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public abstract class ItemObject {
    public abstract boolean hit(Bullet bul);

    public boolean place(ItemObject object){
        return false;
    }

    public boolean pick(Colonel col){
        return true;
    }

    public boolean stepIn(Colonel col){
        return true;
    }
}
