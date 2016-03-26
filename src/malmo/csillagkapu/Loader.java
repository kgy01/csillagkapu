package malmo.csillagkapu;
import static malmo.csillagkapu.util.Logger.*;
import malmo.csillagkapu.gameobject.*;
import malmo.csillagkapu.util.Coordinates;
import malmo.csillagkapu.util.Direction;
import malmo.csillagkapu.util.PortalColor;

/**
 * Created by Mosonyi Máté on 2016. 03. 26..
 */
public class Loader {
	private Colonel colonel;
	
	public Loader() {
	}
	
	public Field[][] loadGame(String filename) {
		beginFunction();
		Field[][] tests = new Field[1][10];
		// Üres mező
		tests[0][1] = new Field(null, null);
		// Doboz van a mezőn
		tests[0][2] = new Field(null, new Box());
		// Fal van a mezőn
		tests[0][3] = new Field(new Wall(), null);
		// ZPM van a mezőn
		tests[0][4] = new Field(null, new ZPM());
		// Szakadék van a mezőn
		tests[0][5] = new Field(new Pit(), null);
		// Ajtó van a mezőn
		tests[0][6] = new Field(new Door(), null);
		// Portál van a mezőn
		tests[0][7] = new Field(null, new Portal(new Coordinates(0,7), PortalColor.YELLOW, Direction.NORTH, null));
		// Mérleg van a mezőn
		tests[0][8] = new Field(new Scale(), null);
		
		colonel = new Colonel();
		
		return ret(tests);
	}
	
	public Colonel getColonel() {
		beginFunction();
		return ret(colonel);
	}
}