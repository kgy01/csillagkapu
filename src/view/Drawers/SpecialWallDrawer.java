package view.Drawers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class SpecialWallDrawer{

    public static void Draw(GraphicsContext gc, double width, double height) {
        gc.clearRect(0,0,width,height);
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,width,height);
        gc.setFill(Color.BLUE);
        gc.fillOval(0,0,width,height);
    }
}
