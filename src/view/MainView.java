package view;

import controller.MainController;
import controller.ViewInterfacesAndEnums.IAnimationView;
import controller.ViewInterfacesAndEnums.IBaseMapView;
import controller.ViewInterfacesAndEnums.IMainView;
import controller.ViewInterfacesAndEnums.IPlayerView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainView extends Application implements IMainView{

    private Integer defaultWidth = 1014;
    private Integer defaultHeight = 1024;
    private BorderPane root = new BorderPane();
    private MainController mainController;
    private Group mapGroup = new Group();
    private Scene scene;
    private Stage myStage;
    private Menu menu = new Menu(this);
    private AnimationTimer animationTimer;

    private BaseMapView baseMapView;
    private AnimationView animationView;
    private PlayerView playerView;

    public ImageLoader imageLoader;

    private int mapStyle = 1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        myStage = primaryStage;
        primaryStage.setTitle("O'Neill ezredes kalandjai");

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(defaultWidth);
        primaryStage.setHeight(defaultHeight);
        primaryStage.setResizable(false);

        imageLoader= new ImageLoader(mapStyle);

        baseMapView = new BaseMapView(this);
        animationView = new AnimationView(this);
        playerView = new PlayerView(this);

        mapGroup.getChildren().add(baseMapView);
        mapGroup.getChildren().add(animationView);
        mapGroup.getChildren().add(playerView);
        root.setCenter(mapGroup);

        menu.createMenu();

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                animationView.animate();
            }
        };

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                MainController.getInstance().keyBoardEventHandler(event);
            }
        });

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
        int test = 0;
    }

    public Stage getStage(){
        return myStage;
    }

}
