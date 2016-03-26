package malmo.csillagkapu.util;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 *
 * Egyszerű osztály x és y koordinátákkal a mező helyzetének leírására.
 * Használják: Bullet, Colonel, Portal, Engine, stb. osztályok
 */
public class Coordinates {
    // Vízszintes helyzet (WEST-EAST irányban)
    int x;

    // Fuggoleges helyzet (NORTH-SOUTH iranyban)
    int y;

    // Default constructor
    public Coordinates() {
    }

    // Constructor mindket koordinataval
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // a jelenlegi Y koordinatat adja vissza
    public int getY() {
        return y;
    }

    // beallitja a jelenlegi Y koordinatat
    public void setY(int y) {
        this.y = y;
    }

    // a jelenlegi X koordinatat adja vissza
    public int getX() {
        return x;
    }

    // beallitja a jelenlegi X koordinatat
    public void setX(int x) {
        this.x = x;
    }

    // A pozíciótól adott irányba lévő pozíció lekérdezése.
    public Coordinates nextFieldCoords(Direction dir) {
        switch(dir) {
            case NORTH:
                return new Coordinates(position.getX(),position.getY()-1);
            case SOUTH:
                return new Coordinates(position.getX(),position.getY()+1);
            case EAST:
                return new Coordinates(position.getX()+1,position.getY());
            default:
                return new Coordinates(position.getX()-1,position.getY());
        }
    }
}
