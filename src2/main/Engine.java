package main;

import utils.*;
import gameobjects.*;

public class Engine {
	// Referncia a j�t�kosokra
	public Colonel colonel;
	public Colonel jaffa;
	public Replicator replicator;
	private Loader loader;
	
	public Engine() {
	}
	
	public void init(String _palya) {
		// �j bet�lt� l�trehoz�sa
		loader = new Loader(this, _palya);
		// J�t�kosok lek�rdez�se
		colonel = loader.getColonel();
		jaffa = loader.getJaffa();
		replicator = loader.getReplicator();
	}
	
	public Field getField(Coordinates co) {
		//Logger.inFunction("-->[Engine:]getField(Coordinates)");
		//Logger.outFunction("<--[Engine:]field");
		return (loader.getFields())[co.getX()][co.getY()];
	}
	
	/*public void gameOver() {
        Logger.inFunction();
        Logger.outFunction();
	}
	
	public void shoot(PortalColor c) {
        Logger.beginFunction();
        Logger.endFunction("");
	}*/
	public void displayGame() {
		loader.display();
	}
	
	public void genZPM() {
		loader.genZPM();
	}
	
}
