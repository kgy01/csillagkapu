package malmo.csillagkapu.gameobject;

import malmo.csillagkapu.Engine;
import malmo.csillagkapu.util.Coordinates;
import malmo.csillagkapu.util.Direction;
import malmo.csillagkapu.util.Logger;
import malmo.csillagkapu.util.PortalColor;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public class Portal extends ItemObject {
    static Engine engine;
    static Portal bluePortal;
    static Portal yellowPortal;

    private Coordinates position;
    private PortalColor color;
    private Direction facingDirection;

    public Coordinates getPosition() {
        return position;
    }

    public PortalColor getColor() {
        return color;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public Portal(Coordinates position, PortalColor color, Direction facingDirection, Engine engine) {
        if (Portal.engine == null) {
            Portal.engine = engine;
        }
        this.position = position;
        this.color = color;
        this.facingDirection = Direction.opposite(facingDirection);
    }

    static void register(Portal portal) {
        Logger.beginFunction();
        Logger.endFunction("");
    }

    private static Portal getPortalInColor(PortalColor color) {
        if (color == PortalColor.YELLOW) {
            return yellowPortal;
        } else {
            return bluePortal;
        }
    }

    private static void registerPortal(Portal portal) {
        if (portal.getColor() == PortalColor.YELLOW) {
            yellowPortal = portal;
        } else {
            bluePortal = portal;
        }
    }

    private Field getOtherField() {
        Logger.beginFunction();
        Field other = null;
        Logger.log("Létezik a másik színű Csillagkapu?(Igen/Nem)");
        if (Logger.getDecision("Igen","Nem")) {
            other = new Field();
        }
        return Logger.ret(other);
    }

    private Portal getOtherPortal() {
        return Logger.ret(getPortalInColor(color == PortalColor.YELLOW ? PortalColor.BLUE : PortalColor.YELLOW));
    }

    @Override
    public boolean stepIn(Colonel col){
        Logger.beginFunction();
        if (Direction.opposite(col.getDirection()) == facingDirection) {
            Field target = getOtherField();
            if (target != null) {
                return Logger.ret(target.stepIn(col));
            }
        }
        return Logger.ret(false);
    }

    private Field getFacingField() {
        return engine.getField(position.nextFieldCoords(facingDirection));
    }
}
