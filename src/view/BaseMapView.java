package view;

import controller.ViewInterfacesAndEnums.IBaseMapView;
import controller.ViewInterfacesAndEnums.IFieldView;
import controller.ViewInterfacesAndEnums.ItemObjectType;
import controller.ViewInterfacesAndEnums.LandObjectType;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;

import javafx.scene.layout.GridPane;
import utils.Coordinates;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class BaseMapView extends GridPane implements IBaseMapView {
    private MainView mainView;
    private Canvas matrix[][];

    public BaseMapView(MainView _mainView){
        mainView = _mainView;
        setHgap(0);
        setVgap(0);
        setStyle("-fx-background-color: #FFFFFF");

    }
    @Override
    public void createCanvasMatrix(int width, int height) {
        matrix = new Canvas[width][height];
        double maxCanvasW = (mainView.getStage().getWidth())/((double)width);
        double maxCanvasH = (mainView.getStage().getHeight())/((double)height);
        double canvasSize = Math.min(maxCanvasH,maxCanvasW);
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                matrix[x][y] = new Canvas(canvasSize,canvasSize);
                add(matrix[x][y],x,y);
            }
        }
    }

    @Override
    public IFieldView createFieldView(Coordinates positsion, LandObjectType type, ItemObjectType itemType) {
        return new FieldView(matrix[positsion.getX()][positsion.getY()],type,itemType);
    }

    public double getCanvasSize(){
        if(matrix != null){
            return  matrix[0][0].getWidth();
        }
        return 0;
    }
}
