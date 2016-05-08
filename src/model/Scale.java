package model;


public class Scale extends LandObject {
    private char mychar;
    private int limit;
    private ItemObject weightItem;

    /**
     * Default konstruktor
     */
    public Scale(Field _field, char _char, int _limit){
    	super(_field);
    	mychar = _char;
    	limit = _limit;
    }

    /**
     * Konstruktor
     * @param _door : A door referenciajat valtoztatja meg a sajatjara.
     */

    /**
     * A LandObject stepIn(Colonel col) metodusat irja felul.
     * Leiras:  Ha ezredes rálép, akkor meghívódik az mérleghez tartozó
     *          ajtónyitási függvénye.
     * @param col : Az ezredes
     * @return true
     */
    @Override
    public boolean stepIn(Player _player) {
    	// Ha a j�t�kos s�lya el�ri, vagy meghaladja a limitet, akkor kiny�lik a hozz� tartoz� ajt�
        if (_player.getWeight() >= limit) {
        	Door.getDoor(Character.toUpperCase(mychar)).open();;
        }
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
    	Door.getDoor(Character.toUpperCase(mychar)).close();;
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
    public boolean place(Player _player, ItemObject _item) {
    	_item.setField(this.field);
		weightItem = _item;
    	if (_item.getWeight() >= limit) {
    		Door.getDoor(Character.toUpperCase(mychar)).open();
        }
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
    	if (weightItem.getWeight() < limit) {
    		Door.getDoor(Character.toUpperCase(mychar)).close();
        }
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
    
    public String toString() {
    	return String.valueOf(mychar);
    }
    public String toStringVerbose() {
    	return "Scale:" + mychar;
    }
}
