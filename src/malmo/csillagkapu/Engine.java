package malmo.csillagkapu;

/**
 * Created by Győző on 2016. 03. 26..
 */
public class Engine {
	private Colonel colonel;
	private Field fields[][];
	
	public Engine() {
	}
	
	public void init() {
		// Belepo loggolas:
		beginFunction();
		
		Loader loader = new Loader();
		fields = loader.loadGame("palya.txt");
		colonel = loader.getColonel();
		
		// Visszatero loggolas
		endFunction("");
	}
	
	public Field getField(Coordinates co) {
		Logger.beginFunction();
		return ret(fields[co.getX()][co.getY()]);
	}
	
	public void gameOver() {
		beginFunction();
		endFunction("");
	}
	
	public void shoot(Color c) {
		beginFunction();
		endFunction("");
	}
}
