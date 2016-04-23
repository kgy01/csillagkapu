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
		System.out.println("| St�tusz: Protot�pus                  |");
		System.out.println("+--------------------------------------+");
		System.out.println("| K�sz�tette: MalMo Szoftver Co., Ltd. |");
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
				// L�ptet�si ir�ny el��ll�t�sa a parancsb�l
				Coordinates direction;
				if (command[2].equals("up")) direction = new Coordinates(0,-1);
				else if (command[2].equals("right")) direction = new Coordinates(1,0);
				else if (command[2].equals("down")) direction = new Coordinates(0,1);
				else direction = new Coordinates(-1,0);
				// J�t�kos kiv�laszt�sa
				if (command[1].equals("colonel")) {
					engine.colonel.step(direction);
				}
				else if (command[1].equals("jaffa")) {
					engine.jaffa.step(direction);
				}
				else if (command[1].equals("replicator")) {
					engine.replicator.step(direction);
				}
			}
			// J�t�kos �llapot�nak megjelen�t�se
			else if (command[0].equals("inventory")) {
				// J�t�kos kiv�laszt�sa
				if (command[1].equals("colonel")) {
					engine.colonel.showInventory();
				}
				else if (command[1].equals("jaffa")) {
					engine.jaffa.showInventory();
				}
			}
			// T�rgy felv�tele az el�tt�nk lev� mez�r�l
			else if (command[0].equals("pick")) {
				// J�t�kos kiv�laszt�sa
				if (command[1].equals("colonel")) {
					engine.colonel.pick();
				}
				else if (command[1].equals("jaffa")) {
					engine.jaffa.pick();
				}
			}
			// T�rgy let�tele az el�tt�nk lev� mez�re
			else if (command[0].equals("placebox")) {
				// J�t�kos kiv�laszt�sa
				if (command[1].equals("colonel")) {
					engine.colonel.place();
				}
				else if (command[1].equals("jaffa")) {
					engine.jaffa.place();
				}
			}
			// T�rgy let�tele az el�tt�nk lev� mez�re
			else if (command[0].equals("shoot")) {
				// J�t�kos kiv�laszt�sa
				if (command[1].equals("colonel")) {
					if (command[2].equals("blue"))
						engine.colonel.shoot(Portal.BLUE);
					else if (command[2].equals("yellow"))
						engine.colonel.shoot(Portal.YELLOW);
				}
				else if (command[1].equals("jaffa")) {
					if (command[2].equals("red"))
						engine.jaffa.shoot(Portal.RED);
					else if (command[2].equals("green"))
						engine.jaffa.shoot(Portal.GREEN);
				}
			}
		}
	}
}
