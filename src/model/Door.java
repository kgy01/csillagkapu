package model;

import java.util.HashMap;
import java.util.Map;

public class Door extends LandObject {
    private boolean isOpen = false;
    private char mychar;
    private static Map<String,Door> doors = new HashMap<String,Door>();

    /**
     * Default kostruktor
     */
    public Door(Field _field, char _mychar) {
    	super(_field);
    	mychar = _mychar;
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
    public boolean stepIn(Player _player) {
		return isOpen;
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
     **/
    @Override
    public boolean hit(Bullet bul) {
        return !isOpen;
    }

    /**
     * Ajtó kinyitása
     */

    public void open(){
    	System.out.println("Door:" + mychar + " opened");
        isOpen = true;
    }

    /**
     * Ajtó bezárása
     */
    
    public void close(){
        System.out.println("Door:" + mychar + " closed");
        isOpen = false;
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
    
    // Ki�r�sok
    public String toString() {
    	return String.valueOf(mychar);
    }
    public String toStringVerbose() {
    	return "Door:" + mychar;
    }
    
    // Ajt� lek�rdez�se
    public static Door getDoor(char _door) {
    	return doors.getOrDefault(String.valueOf(_door), null);
    }
    // Ajt� felv�tele
    public static void addDoor(Door _door) {
    	doors.put(_door.toString(), _door);
    }
}
