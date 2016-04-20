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
						fields[j][i] = new Field(new Wall(), null, null);
						break;
					case '+':
						colonel = new Colonel(new Coordinates(j,i), engine, "+");
						fields[j][i] = new Field(null, null, colonel);
						break;
					case '%':
						jaffa = new Colonel(new Coordinates(j,i), engine, "%");
						fields[j][i] = new Field(null, null, jaffa);
						break;
					case '&':
						fields[j][i] = new Field(null, new Box(), null);
						break;
					case '!':
						fields[j][i] = new Field(new Pit(), null, null);
						break;
					case '$':
						fields[j][i] = new Field(null, new ZPM(), null);
						break;
					default:
						fields[j][i] = new Field(null, null, null);
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
				field.place(new ZPM());
				place = false;
				System.out.println("New ZPM placed");
			}
		}
	}
}