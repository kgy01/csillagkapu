package model;

//import java.util.List;

import utils.*;
import controller.Engine;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public class Colonel extends Player {
    private String mychar;
    
    public Colonel(Coordinates _position, Engine _engine, String _mychar) {
    	super(_position, _engine);
    	mychar = _mychar;
    }

    public Coordinates shoot(MyColor color) {
        if (isBackpackEmpty()) {
            Bullet bullet = new Bullet(position, direction, color, engine);
            return bullet.start();
        }
		return null;
    }
    

    // P�lyakarakter ki�r�sa:
 	@Override
 	public String toString() {
 		return mychar;
 	}
 	
 	// K�t ZPM felv�tele ut�n �j keletkezik
 	@Override
 	public boolean addZPM() {
    	if((++noZPM % 2) == 0 && mychar.equals("+"))
    		engine.genZPM();
    	return true;
    }
 	
 	@Override
 	public String toStringVerbose() {
 		if (mychar.equals("+"))
 			return "Colonel";
 		else
 			return "Jaffa";
 	}
}
