package controller;

import controller.ViewInterfacesAndEnums.IPlayerView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Colonel;
import model.Replicator;
import utils.Coordinates;



/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class PlayerController {
    private IPlayerView playerView;

    public PlayerController(IPlayerView _playerView){
        playerView = _playerView;
    }

    public boolean playerEventHandler(KeyEvent key){
        Engine engine = MainController.getInstance().engine;
        Colonel jaffa = engine.jaffa;
        Colonel colonel = engine.colonel;
        if(jaffa != null && colonel != null) {
            if(key.getCode().equals(KeyCode.W)) {
                jaffa.step(Coordinates.UP);
            }
             else if(key.getCode().equals(KeyCode.A)) {
                jaffa.step(Coordinates.LEFT);
            }
            else if(key.getCode().equals(KeyCode.S)) {
                jaffa.step(Coordinates.DOWN);
            }
            else if(key.getCode().equals(KeyCode.D)) {
                jaffa.step(Coordinates.RIGHT);
            }
            else if(key.getCode().equals(KeyCode.G)) {
                jaffa.place();
            }
            else if(key.getCode().equals(KeyCode.T)){
                jaffa.pick();
            }
            else if(key.getCode().equals(KeyCode.UP)) {
                colonel.step(Coordinates.UP);
            }
            else if(key.getCode().equals(KeyCode.LEFT)){
                colonel.step(Coordinates.LEFT);
            }
            else if(key.getCode().equals(KeyCode.DOWN)){
                colonel.step(Coordinates.DOWN);
            }
            else if(key.getCode().equals(KeyCode.RIGHT)) {
                colonel.step(Coordinates.RIGHT);
            }
            else if(key.getCode().equals(KeyCode.PAGE_DOWN)) {
                colonel.place();
            }
            else if(key.getCode().equals(KeyCode.PAGE_UP)) {
                colonel.pick();
            }
            else{
                    return false;
            }
            playerView.drawJ(jaffa.getPosition(), jaffa.getDirection(), !jaffa.isBackpackEmpty());
            playerView.drawC(colonel.getPosition(), colonel.getDirection(), !colonel.isBackpackEmpty());
            return true;
        }
        if( jaffa != null){
            engine.colonel = new Colonel(Coordinates.DOWN,engine,"+");
            engine.colonel.die();
        }
        else if( colonel != null) {
            engine.jaffa = new Colonel(Coordinates.DOWN,engine,"%");
            engine.jaffa.die();
        }
        else{
            engine.colonel = new Colonel(Coordinates.DOWN,engine,"+");
            engine.colonel.die();
            engine.jaffa = new Colonel(Coordinates.DOWN,engine,"%");
            engine.jaffa.die();
        }
        return true;
    }

    public void replicatorStepEventHandler(){
        Replicator replicator = MainController.getInstance().engine.replicator;
        if(replicator.isAlive()) {
            replicator.step();
            playerView.drawR(replicator.getPosition(), replicator.getDirection());
            if(!replicator.isAlive()){
                MainController.getInstance().baseMapController.fieldChange(replicator.getPosition());
                playerView.drawR(null,null);
            }
        }
    }
}
