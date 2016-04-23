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
	// Referencia a j�t�kmotorra
	private Engine engine;
	// Referenci�k a j�t�kosokra
	private Colonel colonel;
	private Colonel jaffa;
	private Replicator replicator;
	private Field[][] fields;
	private Coordinates fieldSize;
	
	public Loader(Engine _engine, String _filename) {
		engine = _engine;
		// Sorok t�rol�s�ra ArrayList
		List<String> rows = new ArrayList<String>();
		//Sorok beolvas�sa
		try {
			BufferedReader bfreader = new BufferedReader(new InputStreamReader(new FileInputStream(_filename)));
			String row;
			while ((row = bfreader.readLine()) != null) {
				rows.add(row);
				//System.out.println(row);
			}
			bfreader.close();
					
			// K�tdimenzi�s t�mb l�trehoz�sa a mez�knek. Sz�less�g: sor sz�less�ge; Magass�g: sorok sz�ma
			fieldSize = new Coordinates(rows.get(0).length(), rows.size());
			fields = new Field[rows.get(0).length()][rows.size()];
			
			// T�mb felt�lt�se
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
						// Ha a �s z k�z�tti karakter van, akkor az m�rleg
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
			System.out.println("Nem tal�lhat� a bemeneti f�jl!");
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
	
	// P�lya ki�r�sa
	public void display() {
		System.out.print("X");
		for (int i=0; i<fieldSize.getX(); ++i) {
			System.out.print(i%10);
		}
		System.out.println();
		for (int i=0; i<fieldSize.getY(); ++i) {
			System.out.print(i%10);
			for (int j=0; j<fieldSize.getX(); ++j) {
				System.out.print(fields[j][i].toString());
			}
			System.out.println();
		}
	}
	
	// �j ZPM elhelyez�se
	public void genZPM() {
		boolean place = true;
		Random rand = new Random();
		// Am�g nem siker�l elhelyezni, addig pr�b�lkozunk
		while (place) {
			Field field = fields[rand.nextInt(fieldSize.getX()-1)][rand.nextInt(fieldSize.getY()-1)];
			// Megn�zz�k, hogy a v�letlenszer�en gener�lt mez�re letehet�nk-e ZPM-et
			if (field.isEmpty()) {
				field.setItemObject(new ZPM(field));
				place = false;
				System.out.println("New ZPM placed");
			}
		}
	}
}