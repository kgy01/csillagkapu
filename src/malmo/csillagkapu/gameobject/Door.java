package malmo.csillagkapu.gameobject;

/**
 * Created by Győző on 2016. 03. 26..
 */
import static malmo.csillagkapu.util.Logger.*; //ezt minden osztalyba tegyetek bele
import java.util.Scanner;

/**
 * Az Ajtó Osztály implementálása
 */
public class Door extends LandObject {
    private Scale scale;
    private boolean isClosed;

    /**
     * Default kostruktor
     */
    public Door() {
        beginFunction();
        endFunction("");
    }

    /**
     * Konstruktor
     * @param _scale : A scale referenciajat valtoztatja meg a sajatjara.
     */
    public Door(Scale _scale){
        beginFunction();
        scale = _scale;
        endFunction("");
    }

    /**
     * A LandObject stepIn(Colonel col) metodusat irja felul.
     * Leiras:  True és áthelyezi az ezredest az ajtó mezőjére, ha
     *          az ajtó nyitva van, false, ha nincs nyitva.
     * @param col : Az ezredes
     * @return ha az ajtó nyitva van true, false, ha nincs nyitva.
     */
    @Override
    public boolean stepIn(Colonel col) {
        beginFunction();
        return ret(!isClosed());
    }

    /**
     * A LandObject stepOut(Colonel col) metodusat irja felul.
     * Leiras: True, nem módosítja az ezredest
     * @param col : Az ezredes
     * @return True, nem módosítja az ezredest
     */
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
     */
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
     */
    @Override
    public boolean hit(Bullet bul) {
        beginFunction();
        return ret(isClosed());
    }

    /**
     * Ajtó kinyitása
     */

    public void open(){
        beginFunction();
        isClosed = false;
        endFunction("");
    }

    /**
     * Ajtó bezárása
     */
    public void close(){
        beginFunction();
        isClosed = true;
        endFunction("");
    }

    /**
     * Létrehozza az ajtohoz tartozo mérleget.
     * @return A létrehozott mérleg
     */
    public Scale createScale(){
        beginFunction();
        scale =  new Scale(this);
        return ret(scale);
    }

    /**
     * Lekérdeyi az ajtohoz tartozo mérleget. Ha még nincs létrehozza.
     * @return ajtohoz tartozo mérleget
     */
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
    public boolean isClosed(){
        beginFunction();
        log("[N/Z] Nyitott az ajtó, vagy zárt?");
        return ret(!getDecision("N","Z"));
    }

}
