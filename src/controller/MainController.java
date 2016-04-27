package controller;
import utils.Coordinates;
import utils.MyColor;

import java.awt.event.KeyEvent;
/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class MainController {
    private static MainController instance = null;
    private MainController(){}

    public Engine engine;
    public PlayerController playerController;
    public AnimationController animationController;
    public BaseMapController baseMapController;

    public static MainController getInstance(){
        if(instance == null){
            instance = new MainController();
        }
        return instance;
    }

    public void keyBoardEventHandler(KeyEvent key){
        if(animationController.animationEventHandler(key) || playerController.playerEventHandler(key)){
            return;
        }
    }

    public void replicatorStepEventHandler(){

    }

}
