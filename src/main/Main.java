package main;

import gameobjects.Portal;
import gameobjects.ZPM;
import utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static utils.MyColor.*;

public class Main {
	private static boolean ciklus = true;
	private static Engine engine;
	
	public static void main(String[] args) {
		// Szukseges dolgok betoltese
		engine = new Engine();
		boolean stepReplicator = false;

        BufferedReader bufferedReader = null;
        if (System.console() == null) {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        } else {
            // Menu kiirasa
            System.out.println("+--------------------------------------+");
            System.out.println("| O'Neill ezredes kalandjai            |");
            System.out.println("+--------------------------------------+");
            System.out.println("| Statusz: Prototipus                  |");
            System.out.println("+--------------------------------------+");
            System.out.println("| Keszitette: MalMo Szoftver Co., Ltd. |");
            System.out.println("+--------------------------------------+");
            System.out.println();
            System.out.println("Hasznald a \"help\" utasitast az elerheto parancsok listazasahozhoz!");
        }

		// Beolvasunk egy parancsot
		while(ciklus) {
            String[] command = new String[0];
            if (System.console() == null && bufferedReader != null) {
                try {
                    command = bufferedReader.readLine().split(" ");
                } catch (IOException e) {
                    System.out.println("Nem olvasható a bemenet");
                }
            } else {
                System.out.print("> ");
                command = System.console().readLine().split(" ");
            }
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
				// L�ptet�si ir�ny el��ll�t�sa a parancsb�l
				try {
					// J�t�kos kiv�laszt�sa
					if (command[1].equals("colonel")) {
						Coordinates direction;
						if (command[2].equals("up")) direction = new Coordinates(0,-1);
						else if (command[2].equals("right")) direction = new Coordinates(1,0);
						else if (command[2].equals("down")) direction = new Coordinates(0,1);
						else if (command[2].equals("left")) direction = new Coordinates(-1,0);
						else throw new Exception("Fatal error!");
						engine.colonel.step(direction);
					}
					else if (command[1].equals("jaffa")) {
						Coordinates direction;
						if (command[2].equals("up")) direction = new Coordinates(0,-1);
						else if (command[2].equals("right")) direction = new Coordinates(1,0);
						else if (command[2].equals("down")) direction = new Coordinates(0,1);
						else if (command[2].equals("left")) direction = new Coordinates(-1,0);
						else throw new Exception("Fatal error!");
						engine.jaffa.step(direction);
					}
					else if (command[1].equals("replicator")) {
						if (command[2].equals("up")) engine.replicator.step(new Coordinates(0,-1));
						else if (command[2].equals("right")) engine.replicator.step(new Coordinates(1,0));
						else if (command[2].equals("down")) engine.replicator.step(new Coordinates(0,1));
						else if (command[2].equals("left")) engine.replicator.step(new Coordinates(-1,0));
						else if (command[2].equals("auto")) {
							if (command[3].equals("enable"))
								stepReplicator = true;
							else if (command[3].equals("disable"))
								stepReplicator = false;
							else
								throw new Exception("Fatal error!");
						}
						else throw new Exception("Fatal error!");
					}
					else throw new Exception("Fatal error!");
				}
				catch (Exception ex) {
					System.out.println("step [colonel|jaffa|replicator] [up|right|down|left|replicator:auto] [replicator:[enable|disable]]");
				}
			}
			// J�t�kos �llapot�nak megjelen�t�se
			else if (command[0].equals("inventory")) {
				try {
					// J�t�kos kiv�laszt�sa
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
			// T�rgy felv�tele az el�tt�nk lev� mez�r�l
			else if (command[0].equals("pick")) {
				try {
					// J�t�kos kiv�laszt�sa
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
			// T�rgy let�tele az el�tt�nk lev� mez�re
			else if (command[0].equals("placebox")) {
				try {
					// J�t�kos kiv�laszt�sa
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
			// T�rgy let�tele az el�tt�nk lev� mez�re
			else if (command[0].equals("shoot")) {
				try {
					// J�t�kos kiv�laszt�sa
					if (command[1].equals("colonel")) {
						if (command[2].equals("blue"))
							engine.colonel.shoot(BLUE);
						else if (command[2].equals("yellow"))
							engine.colonel.shoot(YELLOW);
						else throw new Exception("Fatal error!");
					}
					else if (command[1].equals("jaffa")) {
						if (command[2].equals("red"))
							engine.jaffa.shoot(RED);
						else if (command[2].equals("green"))
							engine.jaffa.shoot(GREEN);
						else throw new Exception("Fatal error!");
					}
					else throw new Exception("Fatal error!");
				}
				catch (Exception ex) {
					System.out.println("shoot [colonel|jaffa] [colonel:[blue|yellow]|jaffa:[red|green]]");
				}
			}
			else if (command[0].equals("help")) {
				System.out.println("Elerheto utasitasok:");
				System.out.println("loadgame [fajlnev]");
				System.out.println("display");
				System.out.println("exit");
				System.out.println("step [colonel|jaffa|replicator] [up|right|down|left]");
				System.out.println("inventory [colonel|jaffa]");
				System.out.println("pick [colonel|jaffa]");
				System.out.println("placebox [colonel|jaffa]");
				System.out.println("shoot [colonel|jaffa] [colonel:[blue|yellow]|jaffa:[red|green]");
			}
			else {
                System.out.println("Command '" + command[0] + "' not found!");
            }
			// Jatekosok allapotanak ellenorzese
			try {
			if (engine.colonel != null && engine.jaffa != null) {
				if (engine.colonel.isAlive() && !engine.jaffa.isAlive())
					throw new GameOverException("Colonel won!");
				else if (!engine.colonel.isAlive() && engine.jaffa.isAlive())
					throw new GameOverException("Jaffa won!");
				else if (ZPM.getZPMCount() == 0) {
					if (engine.colonel.getNOZPMs() > engine.jaffa.getNOZPMs())
						throw new GameOverException("Colonel won!");
					else if (engine.colonel.getNOZPMs() < engine.jaffa.getNOZPMs())
						throw new GameOverException("Jaffa won!");
					else
						throw new GameOverException("Deuce!");
				}
			}
			}
			catch (GameOverException goe) {
				System.out.println(goe.getMessage());
				ciklus = false;
			}
			// Replicator veletlenszeru leptetese
			if (stepReplicator)
				engine.replicator.step();
		}
	}
}
