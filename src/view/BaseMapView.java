package view;

import controller.ViewInterfacesAndEnums.IBaseMapView;
import controller.ViewInterfacesAndEnums.IFieldView;
import controller.ViewInterfacesAndEnums.LandObjectType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
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
        mainView.getRoot().setCenter(this);
        setHgap(-1);
        setVgap(-1);
    }
    @Override
    public void createCanvasMatrix(int width, int height) {
        matrix = new Canvas[width][height];
        double maxCanvasW = mainView.getStage().getWidth()/((double)width);
        double maxCanvasH = mainView.getStage().getHeight()/((double)height);
        double canvasSize = Math.min(maxCanvasH,maxCanvasW);
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                matrix[x][y] = new Canvas(canvasSize,canvasSize);
                add(matrix[x][y],x,y);
                GraphicsContext gc = matrix[x][y].getGraphicsContext2D();
                gc.clearRect(0,0,canvasSize, canvasSize);
                gc.fillOval(0, 0, 800.0/11.0, 800.0/11.0);
            }
        }
    }

    @Override
    public IFieldView createFieldView(Coordinates positsion, LandObjectType type) {
        return new FieldView(matrix[positsion.getX()][positsion.getY()],type);
    }
}
