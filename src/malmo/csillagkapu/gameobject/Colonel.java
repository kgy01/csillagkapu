package malmo.csillagkapu.gameobject;

import malmo.csillagkapu.Engine;
import malmo.csillagkapu.util.Coordinates;
import malmo.csillagkapu.util.Direction;
import malmo.csillagkapu.util.Logger;
import malmo.csillagkapu.util.PortalColor;

import java.util.List;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 */
public class Colonel {
    private Coordinates position;
    private Direction direction;
    private Engine engine;

    private List<ItemObject> backpack;

    public boolean canShoot() {
        Logger.log("Tud lőni az ezredes?");
        return Logger.getDecision("Igen","Nem");
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void step() {
        Logger.beginFunction();
        Field field = engine.getField(position.nextFieldCoords(direction));
        field.stepIn(this);
        Logger.endFunction("");
    }
    public void shoot(PortalColor color) {
        Logger.beginFunction();
        if (canShoot()) {
            Bullet bullet = new Bullet(position, direction, color, engine);
            bullet.start();
        }
        Logger.endFunction("");
    }

    public void place(ItemObject item) {
        Logger.beginFunction();
        Field field = engine.getField(position.nextFieldCoords(direction));
        field.place(item);
        Logger.endFunction("");
    }

    public void pick() {
        Logger.beginFunction();
        Field field = engine.getField(position.nextFieldCoords(direction));
        field.pick(this);
        Logger.endFunction("");
    }
}
