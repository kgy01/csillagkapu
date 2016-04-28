package view;

import controller.MainController;
import controller.ViewInterfacesAndEnums.IAnimationView;
import controller.ViewInterfacesAndEnums.IBaseMapView;
import controller.ViewInterfacesAndEnums.IMainView;
import controller.ViewInterfacesAndEnums.IPlayerView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainView extends Application implements IMainView{

    private Integer defaultWidth = 800;
    private Integer defaultHeight = 800;
    private BorderPane root = new BorderPane();
    private MainController mainController;
    private Scene scene;
    private Stage myStage;
    private Menu menu = new Menu(this);

    private PlayerView playerView = new PlayerView(this);
    private AnimationView animationView = new AnimationView(this);
    private BaseMapView baseMapView = new BaseMapView(this);

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

        menu.createMenu();
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

    public BorderPane getRoot(){
        return root;
    }
}
