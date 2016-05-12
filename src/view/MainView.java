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
import javafx.scene.canvas.Canvas;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class MainView extends Application implements IMainView{

    public Integer defaultWidth = 1024;
    public Integer defaultHeight = 1024;
    public Integer inventoryPaneHeight = 50;
    private BorderPane gamePane = new BorderPane();
    private Canvas background = new Canvas(defaultWidth,defaultHeight);
    private MainController mainController;
    private Group mapGroup = new Group();
    private Group root = new Group();
    private Scene scene;
    private Stage myStage;
    private Menu menu = new Menu(this);
    private AnimationTimer animationTimer;

    private BorderPane inventoryPane;
    private HBox jaffaInventory;
    private HBox colonelInventory;

    private BaseMapView baseMapView;
    private AnimationView animationView;
    private PlayerView playerView;

    public ImageLoader imageLoader;

    private int mapStyle = 1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        myStage = primaryStage;
        primaryStage.setTitle("O'Neill ezredes kalandjai");

        root.getChildren().add(background);
        root.getChildren().add(gamePane);

        background.getGraphicsContext2D().fillRect(0,0,defaultWidth,defaultHeight);

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
        gamePane.setCenter(mapGroup);

        menu.createMenu();

        inventoryInit();

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
        GaussianBlur gb= new GaussianBlur(50);

        gamePane.setEffect(gb);
        BorderPane textpane = new BorderPane();
        textpane.setMinWidth(defaultWidth);
        textpane.setMinHeight(defaultWidth);

        Text winnerText = new Text("The Winner is " + winner);
        winnerText.setFont(Font.font("Showcard Gothic",70));

        winnerText.setFill(Color.GREEN);

        textpane.setCenter(winnerText);

        root.getChildren().add(textpane);

    }

    public void inventoryInit(){
        inventoryPane = new BorderPane();
        inventoryPane.setMaxWidth(defaultWidth-5);
        inventoryPane.setMaxHeight(inventoryPaneHeight);
        inventoryPane.setMinHeight(inventoryPaneHeight);

        colonelInventory = new HBox();
        jaffaInventory = new HBox();

        gamePane.setTop(inventoryPane);

        inventoryPane.setLeft(colonelInventory);
        inventoryPane.setRight(jaffaInventory);

        Text colonelText = new Text("Colonel:   0X");
        colonelText.setFont(Font.font("Showcard Gothic",inventoryPaneHeight));
        colonelText.setFill(Color.BLUE);

        colonelInventory.getChildren().add(colonelText);

        Text jaffaText = new Text("Jaffa:   0X");
        jaffaText.setFont(Font.font("Showcard Gothic",inventoryPaneHeight));
        jaffaText.setFill(Color.RED);
        jaffaInventory.getChildren().add(jaffaText);

        Image zpm = new Image("/resources/mapStyle_1/zpm.png", inventoryPaneHeight, inventoryPaneHeight, true, true);

        Canvas zpmCanvas1 = new Canvas(inventoryPaneHeight,inventoryPaneHeight);
        zpmCanvas1.getGraphicsContext2D().drawImage(zpm,0,0);
        Canvas zpmCanvas2 = new Canvas(inventoryPaneHeight,inventoryPaneHeight);
        zpmCanvas2.getGraphicsContext2D().drawImage(zpm,0,0);
        colonelInventory.getChildren().add(zpmCanvas1);
        jaffaInventory.getChildren().add(zpmCanvas2);
    }

    @Override
    public void inventoryChange(int colonelZPMs, int jaffaZPMs){
        ((Text)(colonelInventory.getChildren().get(0))).setText("Colonel:   "+colonelZPMs+"X");
        ((Text)(jaffaInventory.getChildren().get(0))).setText("Jaffa:   "+jaffaZPMs+"X");
    }

    public Stage getStage(){
        return myStage;
    }

}
