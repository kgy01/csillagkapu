package malmo.csillagkapu.gameobject;

import malmo.csillagkapu.Engine;
import malmo.csillagkapu.util.Coordinates;
import malmo.csillagkapu.util.Direction;
import malmo.csillagkapu.util.Logger;
import malmo.csillagkapu.util.PortalColor;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public class Bullet implements Runnable{
    Coordinates position;
    Direction direction;
    PortalColor color;
    Engine engine;

    public Bullet(Coordinates position, Direction direction, PortalColor color) {
        this.position = position;
        this.direction = direction;
        this.color = color;
    }

    public PortalColor getColor() {
        return color;
    }

    public boolean step() {
        Logger.beginFunction();
        position = position.nextFieldCoords(direction);
        Field next = engine.getField(position);
        if (next.hit(this)) {
            Portal portal = new Portal(position, color, direction);
            if (next.openPortal(portal)) {
                Portal.register(portal);
            }
        }
        Logger.endFunction("");
    }

    public void start() {
        Logger.beginFunction();
        run();
        Logger.endFunction();
    }

    @Override
    public void run() {
        boolean lastStep = false;
        while(lastStep == false) {
            lastStep = step();
        }
    }
}
