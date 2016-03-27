package main;

import gameobjects.Box;
import utils.Logger;

public class Main {
	private static boolean ciklus = true;
	private static Engine engine;
	
	public static void main(String[] args) {
		// Szukseges dolgok betoltese
		engine = new Engine();
		engine.init();
		
		// Menu kiirasa
			Logger.log("O'Neill ezredes kalandjai");
			Logger.log("----------------------------------------");
			Logger.log("[1] Játékos léptetése a következő mezőre");
			Logger.log("[2] Doboz lerakása mezőre");
			Logger.log("[3] Tárgy felvétele");
			Logger.log("[4] Lövés");
		
			// Beolvasunk egy karaktert
			switch (Logger.readKey()) {
				case '1':
					engine.colonel.step();
					break;
				case '2':
					engine.colonel.place(new Box());
					break;
				case '3':
					engine.colonel.pick();
					break;
				default:
					Logger.log("Nincs ilyen pont!");
			}
		Logger.log("Vége");
	}
}
