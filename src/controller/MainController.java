package controller;
import controller.ViewInterfacesAndEnums.IMainView;

import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class MainController {
    private static MainController instance = null;
    private IMainView mainView;
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
                if(!engine.jaffa.isAlive() && engine.colonel.isAlive()){
                    mainView.gameOver("COLONEL");
                }
                if(engine.jaffa.isAlive() && !engine.colonel.isAlive()) {
                    mainView.gameOver("JAFFA");
                }
                if(!engine.jaffa.isAlive() && !engine.colonel.isAlive()) {
                    mainView.gameOver("NOBODY");
                }
        }
    }

    public void replicatorStepEventHandler(){
        playerController.replicatorStepEventHandler();
    }

    public void setMainView(IMainView _mainView, File map){
        mainView = _mainView;

        engine = new Engine();
        engine.init(map);

        playerController = new PlayerController(mainView.getPlayerView());
        animationController = new AnimationController(mainView.getAnimationView());
        baseMapController = new BaseMapController(mainView.getBaseMapView());
    }

}
