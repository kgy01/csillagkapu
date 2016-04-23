package main;

import gameobjects.Portal;
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
				try {
					engine.init(command[1]);
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					System.out.println("loadgame [*.txt]");
				}
			}
			else if (command[0].equals("display")) {
				engine.displayGame();
			}
			else if (command[0].equals("exit")) {
				ciklus = false;
			}
			else if (command[0].equals("step")) {
				// Léptetési irány elõállítása a parancsból
				try {
					Coordinates direction;
					if (command[2].equals("up")) direction = new Coordinates(0,-1);
					else if (command[2].equals("right")) direction = new Coordinates(1,0);
					else if (command[2].equals("down")) direction = new Coordinates(0,1);
					else if (command[2].equals("left")) direction = new Coordinates(-1,0);
					else throw new Exception("Fatal error!");
					// Játékos kiválasztása
					if (command[1].equals("colonel")) {
						engine.colonel.step(direction);
					}
					else if (command[1].equals("jaffa")) {
						engine.jaffa.step(direction);
					}
					else if (command[1].equals("replicator")) {
						engine.replicator.step(direction);
					}
					else throw new Exception("Fatal error!");
				}
				catch (Exception ex) {
					System.out.println("step [colonel|jaffa|replicator] [up|right|down|left]");
				}
			}
			// Játékos állapotának megjelenítése
			else if (command[0].equals("inventory")) {
				try {
					// Játékos kiválasztása
					if (command[1].equals("colonel")) {
						engine.colonel.showInventory();
					}
					else if (command[1].equals("jaffa")) {
						engine.jaffa.showInventory();
					}
					else throw new Exception("Fatal error!");
				}
				catch (Exception ex) {
					System.out.println("inventory [colonel|jaffa]");
				}
			}
			// Tárgy felvétele az elõttünk levõ mezõrõl
			else if (command[0].equals("pick")) {
				try {
					// Játékos kiválasztása
					if (command[1].equals("colonel")) {
						engine.colonel.pick();
					}
					else if (command[1].equals("jaffa")) {
						engine.jaffa.pick();
					}
					else throw new Exception("Fatal error!");
				}
				catch (Exception ex) {
					System.out.println("pick [colonel|jaffa]");
				}
			}
			// Tárgy letétele az elõttünk levõ mezõre
			else if (command[0].equals("placebox")) {
				try {
					// Játékos kiválasztása
					if (command[1].equals("colonel")) {
						engine.colonel.place();
					}
					else if (command[1].equals("jaffa")) {
						engine.jaffa.place();
					}
					else throw new Exception("Fatal error!");
				}
				catch (Exception ex) {
					System.out.println("placebox [colonel|jaffa]");
				}
					
			}
			// Tárgy letétele az elõttünk levõ mezõre
			else if (command[0].equals("shoot")) {
				try {
					// Játékos kiválasztása
					if (command[1].equals("colonel")) {
						if (command[2].equals("blue"))
							engine.colonel.shoot(Portal.BLUE);
						else if (command[2].equals("yellow"))
							engine.colonel.shoot(Portal.YELLOW);
						else throw new Exception("Fatal error!");
					}
					else if (command[1].equals("jaffa")) {
						if (command[2].equals("red"))
							engine.jaffa.shoot(Portal.RED);
						else if (command[2].equals("green"))
							engine.jaffa.shoot(Portal.GREEN);
						else throw new Exception("Fatal error!");
					}
					else throw new Exception("Fatal error!");
				}
				catch (Exception ex) {
					System.out.println("shoot [colonel|jaffa] [colonel:[blue|yellow]|jaffa:[red|green]]");
				}
			}
			else
				System.out.println("Command '"+command[0]+"' not found!");
		}
	}
}
