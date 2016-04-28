package view;

import controller.ViewInterfacesAndEnums.IFieldView;
import controller.ViewInterfacesAndEnums.ItemObjectType;
import controller.ViewInterfacesAndEnums.LandObjectType;
import javafx.scene.canvas.Canvas;
import model.Scale;
import model.SpecialWall;
import view.Drawers.*;


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
                PitDrawer.Draw(myCanvas.getGraphicsContext2D(),myCanvas.getWidth(),myCanvas.getHeight());
                break;
            case CLOSEDDOOR:
                DoorDrawer.Draw(myCanvas.getGraphicsContext2D(),myCanvas.getWidth(),myCanvas.getHeight(),itemType, true);
                break;
            case OPENEDDOOR:
                DoorDrawer.Draw(myCanvas.getGraphicsContext2D(),myCanvas.getWidth(),myCanvas.getHeight(),itemType, false);
                break;
            case SCALE:
                ScaleDrawer.Draw(myCanvas.getGraphicsContext2D(),myCanvas.getWidth(),myCanvas.getHeight(),itemType);
                break;
            case WALL:
                WallDrawer.Draw(myCanvas.getGraphicsContext2D(),myCanvas.getWidth(),myCanvas.getHeight());
                break;
            case SPECIALWALL:
                SpecialWallDrawer.Draw(myCanvas.getGraphicsContext2D(),myCanvas.getWidth(),myCanvas.getHeight());
                break;
            case FLOOR:
                FloorDrawer.Draw(myCanvas.getGraphicsContext2D(),myCanvas.getWidth(),myCanvas.getHeight(),itemType);
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
