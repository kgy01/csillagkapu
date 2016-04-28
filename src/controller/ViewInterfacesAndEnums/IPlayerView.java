package controller.ViewInterfacesAndEnums;

import utils.Coordinates;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public interface IPlayerView {
    public void drawJ(Coordinates positsion,Coordinates direction,boolean isBox);
    public void drawC(Coordinates positsion,Coordinates direction,boolean isBox);
    public void drawR(Coordinates positsion,Coordinates direction);
}
