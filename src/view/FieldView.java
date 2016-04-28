package view;

import controller.ViewInterfacesAndEnums.IFieldView;
import controller.ViewInterfacesAndEnums.LandObjectType;
import javafx.scene.canvas.Canvas;


/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class FieldView implements IFieldView {
    Canvas myCanvas;
    LandObjectType myType;

    public FieldView(Canvas canvas, LandObjectType type){
        myCanvas = canvas;
        myType = type;
        draw();
    }
    @Override
    public void draw() {

    }
}
