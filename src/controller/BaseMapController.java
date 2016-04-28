package controller;

import controller.ViewInterfacesAndEnums.IBaseMapView;
import controller.ViewInterfacesAndEnums.IFieldView;
import controller.ViewInterfacesAndEnums.LandObjectType;
import model.*;
import utils.Coordinates;

import static controller.ViewInterfacesAndEnums.LandObjectType.*;


/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class BaseMapController {
    private IBaseMapView baseMapView;
    private Coordinates fieldsSize;
    private IFieldView fieldViews[][];
    public BaseMapController(IBaseMapView _baseMapView){
        baseMapView = _baseMapView;
        fieldsSize = MainController.getInstance().engine.getFieldsSize();

        baseMapView.createCanvasMatrix(fieldsSize.getX(),fieldsSize.getY());
        fieldViews = new IFieldView[fieldsSize.getX()][fieldsSize.getY()];

        //Bányászás
        //try {
            for (int y = 0; y < fieldsSize.getY(); y++) {
                for (int x = 0; x < fieldsSize.getX(); x++) {
                    LandObject current = MainController.getInstance().engine.getField(new Coordinates(x, y)).getLandObject();
                    fieldViews[x][y] = baseMapView.createFieldView(new Coordinates(x, y), getLandObjectType(current));
                }
            }
        /*} catch(Exception e){
            System.out.println(e.getMessage() + " : Banyaszasbeli vagy invalid map formatum problema");
        }*/
    }

    public void fieldChange(Coordinates positsion){
        LandObject current = MainController.getInstance().engine.getField(positsion).getLandObject();
        fieldViews[positsion.getX()][positsion.getY()] = baseMapView.createFieldView(positsion, getLandObjectType(current));
    }

    //Bányászás
    public LandObjectType getLandObjectType(LandObject obj){
        if(obj == null){
            return FLOOR;
        }
        if(obj.getClass().equals(Pit.class)){
            return PIT;
        }
        if(obj.getClass().equals(Scale.class)){
            return SCALE;
        }
        if(obj.getClass().equals(Wall.class)){
            return WALL;
        }
        if(obj.getClass().equals(SpecialWall.class)){
            return SPECIALWALL;
        }
        if(obj.getClass().equals(Door.class)){
            return DOOR;
        }
        return null;
    }
}
