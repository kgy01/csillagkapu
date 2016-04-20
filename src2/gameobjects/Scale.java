package gameobjects;

import utils.Logger;

public class Scale extends LandObject {
    private Door door = new Door();

    /**
     * Default konstruktor
     */
    public Scale(){
    }

    /**
     * Konstruktor
     * @param _door : A door referenciajat valtoztatja meg a sajatjara.
     */
    public Scale(Door _door){
        door = _door;
    }

    /**
     * A LandObject stepIn(Colonel col) metodusat irja felul.
     * Leiras:  Ha ezredes rálép, akkor meghívódik az mérleghez tartozó
     *          ajtónyitási függvénye.
     * @param col : Az ezredes
     * @return true
     */
    @Override
    public boolean stepIn(Player _player) {
    	Logger.inFunction("-->[Scale:]stepIn(Colonel)");
        door.open();
        Logger.outFunction("<--[Scale:]true");
        return true;
    }

    /**
     * A LandObject stepOut(Colonel col) metodusat irja felul.
     * Leiras:  True­val tér vissza, és meghívódik az ajtó
     *          becsukásáért felelős függvény.
     * @param col : Az ezredes
     * @return true
     */
    @Override
    public boolean stepOut(Player _player) {
    	Logger.inFunction("-->[Wall:]stepIn()");
    	door.close();
    	Logger.outFunction("<--[Wall:]true");
		return true;
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
    	Logger.inFunction("-->[Scale:]place(ItemObject)");
        door.open();
        Logger.outFunction("<--[Scale:]true");
        return true;
    }

    /**
     * A LandObject pick(Colonel col) metodusat irja felul.
     * Leiras:  True-val tér vissza és bezárja az ajtot.
     * @param col : Az ezredes
     * @return : true
     */
    @Override
    public boolean pick(Player _player) {
    	Logger.inFunction("-->[Wall:]pick(Colonel)");
    	door.close();
    	Logger.outFunction("<--[Wall:]true");
		return true;
    }

    /**
     * Létrehozza a mérleghez tartozo ajtót
     * @return a mérleghez tartozo ajtó
     *
    public Door createDoor(){
        beginFunction();
        return ret(door = new Door(this));
    }

    /**
     * Lekérdezi az mérleghez tartozo ajtót. Ha még nincs létrehozza.
     * @return mérleghez tartozo ajtó
     *
    public Door getDoor(){
        beginFunction();
        if(door == null) {
            return ret(createDoor());
        }
        return ret(door);
    }*/
}
