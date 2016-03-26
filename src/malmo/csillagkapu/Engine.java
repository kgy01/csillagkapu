package malmo.csillagkapu;

import malmo.csillagkapu.gameobject.Colonel;
import malmo.csillagkapu.gameobject.Field;
import malmo.csillagkapu.util.Coordinates;
import malmo.csillagkapu.util.Logger;
import malmo.csillagkapu.util.PortalColor;

/**
 * Created by Mosonyi Máté on 2016. 03. 26..
 */

public class Engine {
	private Colonel colonel;
	private Field[][] fields;
	
	public Engine() {
	}
	
	public void init() {
		// Belepo loggolas:
		Logger.beginFunction();
		
		Loader loader = new Loader();
		fields = loader.loadGame("palya.txt");
		colonel = loader.getColonel();
		
		// Visszatero loggolas
        Logger.endFunction("");
	}
	
	public Field getField(Coordinates co) {
		Logger.beginFunction();
		return Logger.ret(fields[co.getX()][co.getY()]);
	}
	
	public void gameOver() {
        Logger.beginFunction();
        Logger.endFunction("");
	}
	
	public void shoot(PortalColor c) {
        Logger.beginFunction();
        Logger.endFunction("");
	}
}
