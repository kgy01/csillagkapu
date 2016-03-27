package gameobjects;

//import java.util.List;

import utils.*;
import main.Engine;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public class Colonel {
    private Coordinates position;
    private Coordinates direction;
    private Engine engine;

    private ItemObject handlebox;
    
    public Colonel(Coordinates co) {
    	position = co;
    	direction = new Coordinates(1,0);
    }
    
    public void setEngine(Engine en){
    	engine = en;
    }

    public boolean canShoot() {
        Logger.inFunction("-->[Colonel:]canShoot()");
    	Logger.log("[I/N*] Tud lőni az ezredes?");
        if (Logger.readKey() == 'I') {
        	Logger.outFunction("<--[Colonel:]true");
        	return true;
        }
        Logger.outFunction("<--[Colonel:]true");
        return false;
    }
    
    public boolean isBackpackEmpty() {
        Logger.inFunction("-->[Colonel:]isBackpackEmpty()");
    	Logger.log("[i/n*] Üres legyen az ezredes hátizsákja?");
        if (Logger.readKey() == 'i') {
        	Logger.outFunction("<--[Colonel:]true");
        	return true;
        }
        Logger.outFunction("<--[Colonel:]false");
        return false;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Coordinates getDirection() {
        return direction;
    }

    public void setDirection(Coordinates direction) {
        this.direction = direction;
    }

    public void step() {
        Logger.inFunction("-->[Colonel:]step()");
        Logger.log("---------------------");
        Logger.log("[1] Üres mezőre lép");
        Logger.log("[2] Doboz van a mezőn");
        Logger.log("[3] Fal van a mezőn");
        Logger.log("[4] ZPM van a mezőn");
        Logger.log("[5] Szakadék van a mezőn");
        Logger.log("[6] Ajtó van a mezőn");
        Logger.log("[7] Portál van a mezőn");
        Logger.log("[8] Mérleg van a mezőn");
        Field field = null;
        
        switch (Logger.readKey()) {
        	case '1':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 1));
        		break;
        	case '2':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 2));
        		break;
        	case '3':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 3));
        		break;
        	case '4':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 4));
        		break;
        	case '5':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 5));
        		break;
        	case '6':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 6));
        		break;
        	case '7':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 7));
        		break;
        	case '8':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 8));
        		break;
        }
        field.stepIn(this);
        Logger.outFunction("<--[Colonel:]");
    }
    
    public void putBox(Box box) {
    	handlebox = box;
    }

    /*public void shoot(PortalColor color) {
        Logger.beginFunction();
        if (isBackpackEmpty()) {
            Bullet bullet = new Bullet(position, direction, color, engine);
            bullet.start();
        }
        Logger.endFunction("");
    }*/

    public void place(ItemObject item) {
    	Logger.inFunction("-->[Colonel:]place()");
        Logger.log("-------------------------------");
        Logger.log("[1] Üres mezőre akarjuk letenni");
        Logger.log("[2] Doboz van a mezőn");
        Logger.log("[3] Fal van a mezőn");
        Logger.log("[4] Csillagkapu van a mezőn");
        Logger.log("[5] Szakadék van a mezőn");
        Logger.log("[6] Mérleg van a mezőn");
        
        Field field = null;
        
        switch (Logger.readKey()) {
        	case '1':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 1));
        		break;
        	case '2':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 2));
        		break;
        	case '3':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 3));
        		break;
        	case '4':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 7));
        		break;
        	case '5':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 5));
        		break;
        	case '6':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 8));
        		break;
        }
        
        field.place(item);
        Logger.outFunction("<--[Colonel:]");
    }
    
    public void pick() {
    	Logger.inFunction("-->[Colonel:]pick()");
    	Logger.log("---------------------------");
        Logger.log("[1] Dobozt tudnunk felvenni");
        Logger.log("[2] ZPM-et tudunk felvenni");
        Field field = null;
        
        switch (Logger.readKey()) {
        	case '1':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 2));
        		break;
        	case '2':
        		field = engine.getField(new Coordinates(position.getX() + 0, position.getY() + 4));
        		break;
        }
        
        field.pick(this);
        Logger.outFunction("<--[Colonel:]");
    }

    public void die() {
    	Logger.inFunction("-->[Colonel:]die()");
    	Logger.outFunction("<--[Colonel:]");
        //throw new ColonelIsDeadException();
    }
}
