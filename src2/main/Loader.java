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
		for (int i=0; i<fieldSize.getY(); ++i) {
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
				field.place(new ZPM());
				place = false;
				System.out.println("New ZPM placed");
			}
		}
	}
}