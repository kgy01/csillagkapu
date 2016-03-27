package main;

import utils.*;
import gameobjects.*;

public class Engine {
	public Colonel colonel;
	private Field[][] fields;
	
	public Engine() {
		//init();
	}
	
	public void init() {
		Logger.inFunction("-->[Engine:]init()");
		Loader loader = new Loader();
		fields = loader.loadGame("palya.txt");
		colonel = loader.getColonel();
		colonel.setEngine(this);
		Logger.outFunction("<--[Engine:]");
	}
	
	public Field getField(Coordinates co) {
		Logger.inFunction("-->[Engine:]getField(Coordinates)");
		Logger.outFunction("<--[Engine:]field");
		return fields[co.getX()][co.getY()];
	}
	
	/*public void gameOver() {
        Logger.inFunction();
        Logger.outFunction();
	}
	
	public void shoot(PortalColor c) {
        Logger.beginFunction();
        Logger.endFunction("");
	}*/
}
