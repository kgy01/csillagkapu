package main;

import gameobjects.*;
import utils.*;

public class Loader {
	private Colonel colonel;
	
	public Loader() {
	}
	
	public Field[][] loadGame(String filename) {
		Logger.inFunction("-->[Loader:]loadGame(String)");
		Field[][] tests = new Field[10][10];
		// Üres mező
		tests[0][1] = new Field(null, null);
		// Doboz van a mezőn
		tests[0][2] = new Field(null, new Box());
		// Fal van a mezőn
		tests[0][3] = new Field(new Wall(), null);
		// ZPM van a mezőn
		tests[0][4] = new Field(null, new ZPM());
		// Szakadék van a mezőn
		tests[0][5] = new Field(new Pit(), null);
		// Ajtó van a mezőn
		tests[0][6] = new Field(new Door(), null);
		// Portál van a mezőn
		tests[0][7] = new Field(null, new Portal(new Coordinates(1,0), new Coordinates(1,0)));
		// Mérleg van a mezőn
		tests[0][8] = new Field(new Scale(), null);
		
		colonel = new Colonel(new Coordinates(0,0));
		
		Logger.outFunction("<--[Loader:]fields");
		return tests;
	}
	
	public Colonel getColonel() {
		Logger.inFunction("-->[Loader:]getColonel()");
		Logger.outFunction("<--[Loader:]colonel");
		return colonel;
	}
}