package controller.ViewInterfaces;

import utils.Coordinates;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public interface IBaseMapView {
    public void createCanvasMatrix(int width, int height);
    public IFieldView createFieldView(Coordinates positsion, LandObjectType type);
}
