package view;

import controller.MainController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class Menu extends Stage {
    private MainView mainView;

    public Menu(MainView mainView){
        this.mainView = mainView;
    }
    public void createMenu(){
        setWidth(250);
        setHeight(500);
        setTitle("Menu");
        BorderPane root = new BorderPane();
        root.setPrefSize(250, 500);

        Scene scene = new Scene(root);
        setScene(scene);

        VBox menuBox = new VBox(10);
        menuBox.setAlignment(Pos.CENTER);



        Button load = new Button("Load Map");
        Button exit = new Button("Exit");


        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                while(!loadMap());
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exit();
            }
        });
        menuBox.getChildren().addAll(load, exit);

        root.setCenter(menuBox);

        show();
    }
    public boolean loadMap(){
        File file = null;
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Map files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        file = fileChooser.showOpenDialog(mainView.getStage());

        if(file == null){
            return false;
        }
        MainController.getInstance().setMainView(mainView,file);
        MainController.getInstance().drawAll();
        hide();
        mainView.getStage().show();

        return true;
    }
    public void exit(){
        try {
            Platform.exit();
        } catch(Exception e){
            System.err.println("Error in Menu");
        }
    }

}
