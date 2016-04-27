package controller;

import controller.ViewInterfaces.IPlayerView;
import model.Colonel;
import model.Replicator;
import utils.Coordinates;

import java.awt.event.KeyEvent;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class PlayerController {
    private IPlayerView playerView;

    public boolean playerEventHandler(KeyEvent key){
        Engine engine = MainController.getInstance().engine;
        Colonel jaffa = engine.jaffa;
        Colonel colonel = engine.colonel;
        switch (key.getKeyCode()){
            case KeyEvent.VK_W:
                jaffa.step(Coordinates.UP);
                break;
            case KeyEvent.VK_A:
                jaffa.step(Coordinates.LEFT);
                break;
            case KeyEvent.VK_S:
                jaffa.step(Coordinates.DOWN);
                break;
            case KeyEvent.VK_D:
                jaffa.step(Coordinates.RIGHT);
                break;
            case KeyEvent.VK_G:
                jaffa.place();
                break;
            case KeyEvent.VK_T:
                jaffa.pick();
                break;


            case KeyEvent.VK_UP:
                colonel.step(Coordinates.UP);
                break;
            case KeyEvent.VK_LEFT:
                colonel.step(Coordinates.LEFT);
                break;
            case KeyEvent.VK_DOWN:
                colonel.step(Coordinates.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                colonel.step(Coordinates.RIGHT);
                break;
            case KeyEvent.VK_PAGE_DOWN:
                colonel.place();
                break;
            case KeyEvent.VK_PAGE_UP:
                colonel.pick();
                break;
            default:
                return false;
        }
        playerView.drawJ(jaffa.getPosition(),jaffa.getDirection(), !jaffa.isBackpackEmpty());
        playerView.drawC(colonel.getPosition(),colonel.getDirection(), !colonel.isBackpackEmpty());
        return true;
    }

    public void replicatorEventHandler(){
        Replicator replicator = MainController.getInstance().engine.replicator;
        if(replicator.isAlive()) {
            replicator.step();
            playerView.drawR(replicator.getPosition(), replicator.getDirection());
            if(!replicator.isAlive()){
                MainController.getInstance().baseMapController.fieldChange(replicator.getPosition());
            }
        }
    }
}
