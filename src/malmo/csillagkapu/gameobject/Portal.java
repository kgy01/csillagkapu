package malmo.csillagkapu.gameobject;

import malmo.csillagkapu.util.Coordinates;
import malmo.csillagkapu.util.Direction;
import malmo.csillagkapu.util.Logger;
import malmo.csillagkapu.util.PortalColor;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public class Portal {
    static Portal yellowPortal;
    static Portal bluePortal;

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

    public Portal(Coordinates position, PortalColor color, Direction facingDirection) {
        this.position = position;
        this.color = color;
        this.facingDirection = facingDirection;
    }

    static void register(Portal portal) {
        Logger.beginFunction();
        Portal current = getPortalInColor(portal.getColor());
        if (null != current) {
            current = null;
        }
        registerPortal(portal);
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

    public Portal getOtherPortal() {
        return getPortalInColor(color == PortalColor.YELLOW ? PortalColor.BLUE : PortalColor.YELLOW);
    }

}
