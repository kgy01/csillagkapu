package utils;

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
}