package utils;

public class Coordinates {
    public static final Coordinates UP = new Coordinates(0,1);
    public static final Coordinates LEFT = new Coordinates(-1,0);
    public static final Coordinates DOWN = new Coordinates(0,-1);
    public static final Coordinates RIGHT = new Coordinates(1,0);

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
    
    // Egyenl�s�gvizsg�lat
    public boolean equals(Coordinates _ref) {
    	boolean igaz = true;
    	if (x != _ref.getX()) igaz = false;
    	if (y != _ref.getY()) igaz = false;
    	return igaz;
    }
    
    @Override
    public String toString() {
    	return "(" + x + "," + y + ")";
    }
    
    // K�t koordin�ta �sszead�s
    public Coordinates add(Coordinates _operand) {
    	return new Coordinates(this.x + _operand.getX(), this.y + _operand.getY());
    }
    
    // Koordin�ta ellentetj�re ford�t�sa
    public Coordinates negate() {
    	return new Coordinates(x * -1, y * -1);
    }
    
    public String toStringVerbose() {
    	if (x==0 && y==-1)
    		return "up";
    	else if (x==1 && y==0)
    		return "right";
    	else if (x==0 && y==1)
    		return "down";
    	else
    		return "left";
    }
}