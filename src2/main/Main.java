package main;

import utils.*;

public class Main {
	private static boolean ciklus = true;
	private static Engine engine;
	
	public static void main(String[] args) {
		// Szukseges dolgok betoltese
		engine = new Engine();
		
		// Menu kiirasa
		System.out.println("+--------------------------------------+");
		System.out.println("| O'Neill ezredes kalandjai            |");
		System.out.println("+--------------------------------------+");
		System.out.println("| Státusz: Prototípus                  |");
		System.out.println("+--------------------------------------+");
		System.out.println("| Készítette: MalMo Szoftver Co., Ltd. |");
		System.out.println("+--------------------------------------+");
		System.out.println();
		
		// Beolvasunk egy parancsot
		while(ciklus) {
			System.out.print("> ");
			String[] command = System.console().readLine().split(" ");
			if (command[0].equals("loadgame")) {
				engine.init(command[1]);
			}
			else if (command[0].equals("display")) {
				engine.displayGame();
			}
			else if (command[0].equals("exit")) {
				ciklus = false;
			}
			else if (command[0].equals("step")) {
				// Léptetési irány elõállítása a parancsból
				Coordinates direction;
				if (command[2].equals("up")) direction = new Coordinates(0,-1);
				else if (command[2].equals("right")) direction = new Coordinates(1,0);
				else if (command[2].equals("down")) direction = new Coordinates(0,1);
				else direction = new Coordinates(-1,0);
				// Játékos kiválasztása
				if (command[1].equals("colonel")) {
					engine.colonel.step(direction);
				}
				else if (command[1].equals("jaffa")) {
					engine.jaffa.step(direction);
				}
			}
			// Játékos állapotának megjelenítése
			else if (command[0].equals("inventory")) {
				// Játékos kiválasztása
				if (command[1].equals("colonel")) {
					engine.colonel.showInventory();
				}
				else if (command[1].equals("jaffa")) {
					engine.jaffa.showInventory();
				}
			}
			// Tárgy felvétele az elõttünk levõ mezõrõl
			else if (command[0].equals("pick")) {
				// Játékos kiválasztása
				if (command[1].equals("colonel")) {
					engine.colonel.pick();
				}
				else if (command[1].equals("jaffa")) {
					engine.jaffa.pick();
				}
			}
			// Tárgy letétele az elõttünk levõ mezõre
						else if (command[0].equals("place")) {
							// Játékos kiválasztása
							if (command[1].equals("colonel")) {
								engine.colonel.place();
							}
							else if (command[1].equals("jaffa")) {
								engine.jaffa.place();
							}
						}
		}
	}
}
