package view.Drawers;

import controller.ViewInterfacesAndEnums.ItemObjectType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class FloorDrawer{
    public static void Draw(GraphicsContext gc, double width, double height, ItemObjectType itemType) {
        gc.clearRect(0,0,width,height);
        gc.setFill(Color.DARKGREEN);
        gc.fillRect(0,0,width,height);

        switch (itemType){
            case ZPM:
                ZPMDrawer.draw(gc,width,height);
                break;
            case BOX:
                BoxDrawer.draw(gc,width,height);
        }
    }
}
