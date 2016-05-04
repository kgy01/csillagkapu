package view;

import controller.ViewInterfacesAndEnums.IFieldView;
import controller.ViewInterfacesAndEnums.ItemObjectType;
import controller.ViewInterfacesAndEnums.LandObjectType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class FieldView implements IFieldView {
    private Canvas myCanvas;
    private LandObjectType myType;

    public FieldView(Canvas canvas, LandObjectType type, ItemObjectType itemType){
        myCanvas = canvas;
        myType = type;
        draw(itemType);
    }

    //A file path-okat megkene csinalni univerzalisra mert lehet linuxon nem mukodne
    @Override
    public void draw(ItemObjectType itemType) {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        double width = myCanvas.getWidth() + 1.0;
        double height = myCanvas.getHeight() + 1.0;
        switch (myType){
            case PIT:
                gc.clearRect(0,0,width,height);
                gc.drawImage(new Image(getClass().getResource("/resources/pit2.jpg").toString(),width,height,true,true), 0,0);
                break;
            case CLOSEDDOOR:
                gc.clearRect(0,0,width,height);
                gc.drawImage(new Image(getClass().getResource("/resources/closeddoor1.png").toString(),width,height,true,true), 0,0);
                break;
            case OPENEDDOOR:
                gc.clearRect(0,0,width,height);
                gc.drawImage(new Image(getClass().getResource("/resources/openeddoor1.png").toString(),width,height,true,true), 0,0);
                break;
            case SCALE:
                gc.clearRect(0,0,width,height);
                gc.drawImage(new Image(getClass().getResource("/resources/scale_floor2.jpg").toString(),width,height,true,true), 0,0);
                gc.drawImage(new Image(getClass().getResource("/resources/scale1.png").toString(),width/2.0,height/2.0,true,true),width/4.0,height/4.0);
                break;
            case WALL:
                gc.clearRect(0,0,width,height);
                gc.drawImage(new Image(getClass().getResource("/resources/lava2.png").toString(),width,height,true,true), 0,0);
                break;
            case SPECIALWALL:
                gc.clearRect(0,0,width,height);
                gc.drawImage(new Image(getClass().getResource("/resources/closedStagegate/frame_154_delay-s.gif").toString(),width,height,true,true), 0,0);
                break;
            case FLOOR:
                gc.clearRect(0,0,width,height);
                gc.drawImage(new Image(getClass().getResource("/resources/floor3.jpg").toString(),width,height,true,true), 0,0);
                break;
            default:
                System.out.println("Gond van a kirajzolasnal");
                break;
        }

        switch (itemType){
            case BOX:
                gc.drawImage(new Image(getClass().getResource("/resources/box1.jpg").toString(),width/2.0,height/2.0,true,true),width/4.0,height/4.0);
                break;
            case ZPM:
                gc.drawImage(new Image(getClass().getResource("/resources/zpm1.png").toString(),width,height,true,true),0,0);
                break;
            default:

                break;
        }
    }
    @Override
    public LandObjectType getType(){
        return myType;
    }
}
