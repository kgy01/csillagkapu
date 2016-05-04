package view;

import controller.MainController;
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
    private MainView mainView;

    public FieldView(Canvas canvas, LandObjectType type, ItemObjectType itemType, MainView _mainView){
        myCanvas = canvas;
        myType = type;
        mainView = _mainView;
        draw(itemType);

    }

    //A file path-okat megkene csinalni univerzalisra mert lehet linuxon nem mukodne
    @Override
    public void draw(ItemObjectType itemType) {
        GraphicsContext gc = myCanvas.getGraphicsContext2D();
        int width = (int)myCanvas.getWidth();
        int height = (int)myCanvas.getHeight();
        switch (myType){
            case PIT:
                gc.clearRect(0,0,width,height);
                gc.drawImage(mainView.imageLoader.getImage("pit", width,height),0,0);
                break;
            case CLOSEDDOOR:
                gc.clearRect(0,0,width,height);
                gc.drawImage(mainView.imageLoader.getImage("closeddoor", width,height),0,0);
                break;
            case OPENEDDOOR:
                gc.clearRect(0,0,width,height);
                gc.drawImage(mainView.imageLoader.getImage("openeddoor", width,height),0,0);
                break;
            case SCALE:
                gc.clearRect(0,0,width,height);
                gc.drawImage(mainView.imageLoader.getImage("scale_floor", width,height),0,0);
                gc.drawImage(mainView.imageLoader.getImage("scale", width/2.0,height/2.0),width/4.0,height/4.0);
                break;
            case WALL:
                gc.clearRect(0,0,width,height);
                gc.drawImage(mainView.imageLoader.getImage("wall", width,height),0,0);
                break;
            case SPECIALWALL:
                gc.clearRect(0,0,width,height);
                gc.drawImage(mainView.imageLoader.getImage("specialwall", width,height),0,0);
                break;
            case FLOOR:
                gc.clearRect(0,0,width,height);
                gc.drawImage(mainView.imageLoader.getImage("floor", width,height),0,0);
                break;
            default:
                System.out.println("Gond van a kirajzolasnal");
                break;
        }

        if(itemType != null) {
            switch (itemType) {
                case BOX:
                    gc.drawImage(mainView.imageLoader.getImage("box", width / 2.0, height / 2.0), width / 4.0, height / 4.0);
                    break;
                case ZPM:
                    gc.drawImage(mainView.imageLoader.getImage("zpm", width, height), 0, 0);
                    break;
                default:

                    break;
            }
        }
    }
    @Override
    public LandObjectType getType(){
        return myType;
    }
}
