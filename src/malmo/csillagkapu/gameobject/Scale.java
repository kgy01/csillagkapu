package malmo.csillagkapu.gameobject;

/**
 * Created by Győző on 2016. 03. 26..
 */
import static malmo.csillagkapu.util.Logger.*; //ezt minden osztalyba tegyetek bele

/**
 * A Mérleg Osztály implementálása
 */
public class Scale extends LandObject {
    private Door door;

    /**
     * Default konstruktor
     */
    public Scale(){
        beginFunction();
        endFunction("");
    }

    /**
     * Konstruktor
     * @param _door : A door referenciajat valtoztatja meg a sajatjara.
     */
    public Scale(Door _door){
        beginFunction();
        door = _door;
        endFunction("");
    }

    /**
     * A LandObject stepIn(Colonel col) metodusat irja felul.
     * Leiras:  Ha ezredes rálép, akkor meghívódik az mérleghez tartozó
     *          ajtónyitási függvénye.
     * @param col : Az ezredes
     * @return true
     */
    @Override
    public boolean stepIn(Colonel col) {
        beginFunction("Colonel col");
        door.open();
        return ret(true);
    }

    /**
     * A LandObject stepOut(Colonel col) metodusat irja felul.
     * Leiras:  True­val tér vissza, és meghívódik az ajtó
     *          becsukásáért felelős függvény.
     * @param col : Az ezredes
     * @return true
     */
    @Override
    public boolean stepOut(Colonel col) {
        beginFunction("Colonel col");
        door.close();
        return ret(true);
    }

    /**
     * A LandObject place(ItemObject obj) metodusat irja felul.
     * Leiras:  True­val tér vissza, ugyanis az ezredes képes
     *          rárakni elemet. Kinyitja a mérleghez tartozó ajtót.
     * @param obj : A rárakot elem
     * @return true
     */
    @Override
    public boolean place(ItemObject obj) {
        beginFunction("ItemObject obj");
        door.open();
        return ret(true);
    }

    /**
     * A LandObject pick(Colonel col) metodusat irja felul.
     * Leiras:  True-val tér vissza és bezárja az ajtot.
     * @param col : Az ezredes
     * @return : true
     */
    @Override
    public boolean pick(Colonel col) {
        beginFunction("ItemObject obj");
        door.close();
        return ret(true);
    }

    /**
     * Létrehozza a mérleghez tartozo ajtót
     * @return a mérleghez tartozo ajtó
     */
    public Door createDoor(){
        beginFunction();
        return ret(door = new Door(this));
    }

    /**
     * Lekérdezi az mérleghez tartozo ajtót. Ha még nincs létrehozza.
     * @return mérleghez tartozo ajtó
     */
    public Door getDoor(){
        beginFunction();
        if(door == null) {
            return ret(createDoor());
        }
        return ret(door);
    }
}
