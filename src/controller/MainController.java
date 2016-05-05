package controller;
import controller.ViewInterfacesAndEnums.IMainView;
import javafx.scene.input.KeyEvent;
import model.Colonel;
import model.Replicator;
import utils.Coordinates;


import java.io.File;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class MainController {
    private static MainController instance = null;
    public IMainView mainView;
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
        if (playerController != null){playerController.replicatorStepEventHandler();}
    }

    public void setMainView(IMainView _mainView, File map){
        mainView = _mainView;

        engine = new Engine();
        engine.init(map);

        playerController = new PlayerController(mainView.getPlayerView());
        animationController = new AnimationController(mainView.getAnimationView());
        baseMapController = new BaseMapController(mainView.getBaseMapView());
    }

    public void drawAll(){
        Colonel jaffa = engine.jaffa;
        Colonel colonel = engine.colonel;
        Replicator replicator = MainController.getInstance().engine.replicator;
        if(replicator.isAlive())
            mainView.getPlayerView().drawR(replicator.getPosition(), replicator.getDirection());
        else{
            mainView.getPlayerView().drawR(new Coordinates(-1,-1), replicator.getDirection());
        }
        mainView.getPlayerView().drawJ(jaffa.getPosition(), jaffa.getDirection(), !jaffa.isBackpackEmpty());
        mainView.getPlayerView().drawC(colonel.getPosition(), colonel.getDirection(), !colonel.isBackpackEmpty());

    }

}
