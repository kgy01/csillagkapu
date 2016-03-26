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

    public Bullet(Coordinates position, Direction direction, PortalColor color, Engine engine) {
        this.position = position;
        this.direction = direction;
        this.color = color;
        this.engine = engine;
    }

    public PortalColor getColor() {
        return color;
    }

    public boolean step() {
        Logger.beginFunction();
        position = position.nextFieldCoords(direction);
        Field next = engine.getField(position);
        if (next.hit(this)) {
            Portal portal = new Portal(position, color, direction, engine);
            if (next.openPortal(portal)) {
                Portal.register(portal);
            }
            return Logger.ret(true);
        } else {
            return Logger.ret(false);
        }
    }

    public void start() {
        Logger.beginFunction();
        run();
        Logger.endFunction("");
    }

    @Override
    public void run() {
        boolean lastStep = false;
        while(!lastStep) {
            lastStep = step();
        }
    }
}
