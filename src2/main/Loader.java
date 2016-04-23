package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gameobjects.*;
import utils.*;

public class Loader {
	// Referencia a játékmotorra
	private Engine engine;
	// Referenciák a játékosokra
	private Colonel colonel;
	private Colonel jaffa;
	private Replicator replicator;
	private Field[][] fields;
	private Coordinates fieldSize;
	
	public Loader(Engine _engine, String _filename) {
		engine = _engine;
		// Sorok tárolására ArrayList
		List<String> rows = new ArrayList<String>();
		//Sorok beolvasása
		try {
			BufferedReader bfreader = new BufferedReader(new InputStreamReader(new FileInputStream(_filename)));
			String row;
			while ((row = bfreader.readLine()) != null) {
				rows.add(row);
				//System.out.println(row);
			}
			bfreader.close();
					
			// Kétdimenziós tömb létrehozása a mezõknek. Szélesség: sor szélessége; Magasság: sorok száma
			fieldSize = new Coordinates(rows.get(0).length(), rows.size());
			fields = new Field[rows.get(0).length()][rows.size()];
			
			// Tömb feltöltése
			for (int i=0; i<rows.size(); ++i) {
				String line = rows.get(i);
				for (int j=0; j<line.length(); ++j) {
					switch (line.charAt(j)) {
					case '#':
						fields[j][i] = new Field();
						Wall newwall = new Wall(fields[j][i]);
						fields[j][i].setLandObject(newwall);
						break;
					case '@':
						fields[j][i] = new Field();
						SpecialWall newspwall = new SpecialWall(fields[j][i]);
						fields[j][i].setLandObject(newspwall);
						break;
					case '+':
						colonel = new Colonel(new Coordinates(j,i), engine, "+");
						fields[j][i] = new Field();
						fields[j][i].setPlayer(colonel);
						break;
					case '%':
						jaffa = new Colonel(new Coordinates(j,i), engine, "%");
						fields[j][i] = new Field();
						fields[j][i].setPlayer(jaffa);
						break;
					case '&':
						fields[j][i] = new Field();
						Box box = new Box(fields[j][i]);
						fields[j][i].setItemObject(box);
						break;
					case '!':
						fields[j][i] = new Field();
						Pit newpit = new Pit(fields[j][i]);
						fields[j][i].setLandObject(newpit);
						break;
					case '$':
						fields[j][i] = new Field();
						ZPM newzpm = new ZPM(fields[j][i]);
						fields[j][i].setItemObject(newzpm);
						break;
					case '?':
						replicator = new Replicator(new Coordinates(j,i), engine);
						fields[j][i] = new Field();
						fields[j][i].setReplicator(replicator);
						break;
					default:
						// Ha a és z közötti karakter van, akkor az mérleg
						if (line.charAt(j) >= 'a' && line.charAt(j) <= 'z') {
							fields[j][i] = new Field();
							Scale newscale = new Scale(fields[j][i], line.charAt(j), 20);
							fields[j][i].setLandObject(newscale);
						}
						else if (line.charAt(j) >= 'A' && line.charAt(j) <= 'Z') {
							fields[j][i] = new Field();
							Door newdoor = new Door(fields[j][i], line.charAt(j));
							fields[j][i].setLandObject(newdoor);
							Door.addDoor(newdoor);
						}
						else {
							fields[j][i] = new Field();
						}
					}
				}
			}
			System.out.println("OK");
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("Nem található a bemeneti fájl!");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public Field[][] getFields() {
		return fields;
	}
	public Coordinates getFiledSize() {
		return fieldSize;
	}
	public Colonel getColonel() {
		//Logger.inFunction("-->[Loader:]getColonel()");
		//Logger.outFunction("<--[Loader:]colonel");
		return colonel;
	}
	public Colonel getJaffa() {
		//Logger.inFunction("-->[Loader:]getColonel()");
		//Logger.outFunction("<--[Loader:]colonel");
		return jaffa;
	}
	public Replicator getReplicator() {
		//Logger.inFunction("-->[Loader:]getColonel()");
		//Logger.outFunction("<--[Loader:]colonel");
		return replicator;
	}
	
	// Pálya kiírása
	public void display() {
		for (int i=0; i<fieldSize.getY(); ++i) {
			for (int j=0; j<fieldSize.getX(); ++j) {
				System.out.print(fields[j][i].toString());
			}
			System.out.println();
		}
	}
	
	// Új ZPM elhelyezése
	public void genZPM() {
		boolean place = true;
		Random rand = new Random();
		// Amíg nem sikerül elhelyezni, addig próbálkozunk
		while (place) {
			Field field = fields[rand.nextInt(fieldSize.getX()-1)][rand.nextInt(fieldSize.getY()-1)];
			// Megnézzük, hogy a véletlenszerûen generált mezõre letehetünk-e ZPM-et
			if (field.isEmpty()) {
				field.setItemObject(new ZPM(field));
				place = false;
				System.out.println("New ZPM placed");
			}
		}
	}
}