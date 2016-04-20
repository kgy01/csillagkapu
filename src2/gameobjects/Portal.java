package gameobjects;

import utils.*;

public class Portal extends ItemObject {
    //static Engine engine;
    //static Portal bluePortal;
    //static Portal yellowPortal;

    private Coordinates position;
    private Coordinates facingDirection;

    public Coordinates getPosition() {
        return position;
    }

    /*public Direction getFacingDirection() {
        return facingDirection;
    }*/

    public Portal(Coordinates _position, Coordinates _facingDirection) {
        position = _position;
        facingDirection = _facingDirection;
    }

    /*static void register(Portal portal) {
        Logger.beginFunction();
        Logger.endFunction("");
    }*/

    /*private static Portal getPortalInColor(PortalColor color) {
        if (color == PortalColor.YELLOW) {
            return yellowPortal;
        } else {
            return bluePortal;
        }
    }*/

    /*private static void registerPortal(Portal portal) {
        if (portal.getColor() == PortalColor.YELLOW) {
            yellowPortal = portal;
        } else {
            bluePortal = portal;
        }
    }*/

    private Field getOtherField() {
    	Logger.inFunction("-->[Portal:]getOtherField()");
		
        Field other = null;
        Logger.log("[i/n] Létezik a másik színű Csillagkapu?");
        if (Logger.readKey() == 'i') {
            other = new Field(null,null, null);
        }
        Logger.outFunction("<--[Portal:]field");
        return other;
    }

    /*private Portal getOtherPortal() {
        return Logger.ret(getPortalInColor(color == PortalColor.YELLOW ? PortalColor.BLUE : PortalColor.YELLOW));
    }*/

    @Override
    public boolean stepIn(Player _player) {
    	Logger.inFunction("-->[Portal:]stepIn(Colonel)");
        Field target = getOtherField();
        if (target != null) {
        	boolean ret = target.stepIn(_player);
        	Logger.outFunction("<--[Portal:]" + ret);
            return ret;
        }
        Logger.outFunction("<--[Portal:]false");
        return false;
    }
    
    @Override
    public boolean place(ItemObject _item) {
    	Logger.inFunction("-->[Portal:]place(ItemObject)");
        Field target = getOtherField();
        if (target != null) {
            boolean ret = target.place(_item);
        	Logger.outFunction("<--[Portal:]" + ret);
            return ret;
        }
        Logger.outFunction("<--[Portal:]false");
        return false;
    }
    
    
    /*private Field getFacingField() {
        return engine.getField(position.nextFieldCoords(facingDirection));
    }*/
}
