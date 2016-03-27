package gameobjects;

import utils.Logger;

public class Door extends LandObject {
    private boolean isOpen = false;

    /**
     * Default kostruktor
     */
    public Door() {
    }

    /**
     * Konstruktor
     * @param _scale : A scale referenciajat valtoztatja meg a sajatjara.
     */
    //public Door(Scale _scale){
    //    scale = _scale;
    //}

    /**
     * A LandObject stepIn(Colonel col) metodusat irja felul.
     * Leiras:  True és áthelyezi az ezredest az ajtó mezőjére, ha
     *          az ajtó nyitva van, false, ha nincs nyitva.
     * @param col : Az ezredes
     * @return ha az ajtó nyitva van true, false, ha nincs nyitva.
     */
    @Override
    public boolean stepIn(Colonel col) {
    	Logger.inFunction("-->[Door:]stepIn(Colonel)");
		boolean ret = isOpen();
		Logger.outFunction("<--[Door:]" + ret);
		return ret;
    }

    /**
     * A LandObject stepOut(Colonel col) metodusat irja felul.
     * Leiras: True, nem módosítja az ezredest
     * @param col : Az ezredes
     * @return True, nem módosítja az ezredest
     *
    @Override
    public boolean stepOut(Colonel col) {
        beginFunction();
        return ret(true);
    }

    /**
     * A LandObject place(ItemObject obj) metodusat irja felul.
     * Leiras:  Amikor tárgyat kísérel meg lerakni rá az ezredes,
     *          false­al tér vissza, mivel ajtóban nem lehet tárgyat tenni.
     * @param obj : Egy ItemObject
     * @return  false
     *
    @Override
    public boolean place(ItemObject obj) {
        beginFunction();
        return ret(false);
    }

    /**
     * A LandObject hit(Bullet bul) metodusat irja felul.
     * Leiras:  Ha zárva van az ajtó, true­val tér vissza, jelezve, hogy
     *          lövedék csapódott bele. Egyébként false.
     * @param bul : A lovedek
     * @return  Az ajto nyitotsagatol fugg.
     *
    @Override
    public boolean hit(Bullet bul) {
        beginFunction();
        return ret(isClosed());
    }

    /**
     * Ajtó kinyitása
     */

    public void open(){
    	Logger.inFunction("-->[Door:]open()");
        isOpen = true;
        Logger.outFunction("<--[Door:]");
    }

    /**
     * Ajtó bezárása
     */
    
    public void close(){
    	Logger.inFunction("-->[Door:]close()");
        isOpen = true;
        Logger.outFunction("<--[Door:]");
    }

    /**
     * Létrehozza az ajtohoz tartozo mérleget.
     * @return A létrehozott mérleg
     *
    public Scale createScale(){
        beginFunction();
        scale =  new Scale(this);
        return ret(scale);
    }

    /**
     * Lekérdeyi az ajtohoz tartozo mérleget. Ha még nincs létrehozza.
     * @return ajtohoz tartozo mérleget
     *
    public Scale getScale(){
        beginFunction();
        if(scale == null) {
            return ret(createScale());
        }
        return ret(scale);
    }

    /**
     * Az ajtó nyitotságának lekérdezése
     * @return az ajtó nyitotsága
     */
    
    public boolean isOpen(){
    	Logger.inFunction("-->[Door:]isOpen()");
    	Logger.log("[i/n] Nyitva legyen az ajtó?");
    	if (Logger.readKey() == 'i') {
			Logger.outFunction("<--[Door:]true");
			return true;
		}
		else {
			Logger.outFunction("<--[Door:]false");
			return false;
		}
    }

}
