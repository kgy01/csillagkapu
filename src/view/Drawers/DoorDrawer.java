package view.Drawers;

import controller.ViewInterfacesAndEnums.ItemObjectType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class DoorDrawer {
    public static void Draw(GraphicsContext gc, double width, double height, ItemObjectType itemType, boolean isClosed) {
        gc.clearRect(0,0,width,height);
        gc.setFill(Color.BROWN);
        gc.fillRect(0,0,width,height);
        if(isClosed){
            gc.setStroke(Color.RED);
            gc.setLineWidth(5);
            gc.strokeLine(0,0,width,height);
            gc.strokeLine(width,0,0,height);
        }
       switch (itemType){
           case ZPM:
               ZPMDrawer.draw(gc,width,height);
               break;
           case BOX:
               BoxDrawer.draw(gc,width,height);
       }
    }
}
