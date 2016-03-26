package malmo.csillagkapu.util;

/**
 * Created by Komporály Győző on 2016. 03. 26..
 *
 * Egy egyszerű enum az ezredes és lövedekek irányának megadásához.
 */
public enum Direction {
    NORTH, EAST, WEST, SOUTH;

    public static Direction opposite(Direction facingDirection) {
        switch(facingDirection) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                return NORTH;
        }
    }
}
