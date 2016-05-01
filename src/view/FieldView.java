package view;

import controller.ViewInterfacesAndEnums.IFieldView;
import controller.ViewInterfacesAndEnums.ItemObjectType;
import controller.ViewInterfacesAndEnums.LandObjectType;
import javafx.scene.canvas.Canvas;



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
    @Override
    public void draw(ItemObjectType itemType) {
        switch (myType){
            case PIT:
                //PIT Rajzolas
                break;
            case CLOSEDDOOR:
                //CLOSEDDOOR Rajzolas
                break;
            case OPENEDDOOR:
                //stb
                break;
            case SCALE:
                //stb
                break;
            case WALL:
                //stb
                break;
            case SPECIALWALL:
                //stb
                break;
            case FLOOR:
                //stb
                break;
            default:
                System.out.println("Gond van a kirajzolasnal");
                break;
        }
    }
    @Override
    public LandObjectType getType(){
        return myType;
    }
}
