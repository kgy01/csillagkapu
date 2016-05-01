package view;

import controller.MainController;
import controller.ViewInterfacesAndEnums.IAnimationView;
import controller.ViewInterfacesAndEnums.IBaseMapView;
import controller.ViewInterfacesAndEnums.IMainView;
import controller.ViewInterfacesAndEnums.IPlayerView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainView extends Application implements IMainView{

    private Integer defaultWidth = 800;
    private Integer defaultHeight = 800;
    private BorderPane root = new BorderPane();
    private MainController mainController;
    private Group mapGroup = new Group();
    private Scene scene;
    private Stage myStage;
    private Menu menu = new Menu(this);

    private BaseMapView baseMapView;
    private AnimationView animationView;
    private PlayerView playerView;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        myStage = primaryStage;
        primaryStage.setTitle("O'Neill ezredes kalandjai");

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(defaultWidth);
        primaryStage.setHeight(defaultHeight);
        primaryStage.setResizable(false);


        baseMapView = new BaseMapView(this);
        animationView = new AnimationView(this);
        playerView = new PlayerView(this);

        mapGroup.getChildren().addAll(baseMapView,animationView,playerView);
        root.setCenter(mapGroup);

        menu.createMenu();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                animationView.animate();
            }
        };

        animationTimer.start();
    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public IPlayerView getPlayerView() {
        return playerView;
    }

    @Override
    public IAnimationView getAnimationView() {
        return animationView;
    }

    @Override
    public IBaseMapView getBaseMapView() {
        return baseMapView;
    }

    @Override
    public void gameOver(String winner) {

    }

    public Stage getStage(){
        return myStage;
    }

}
