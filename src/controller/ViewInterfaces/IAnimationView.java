package controller.ViewInterfaces;

import utils.Coordinates;
import utils.MyColor;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public interface IAnimationView {
    public void shoot(Coordinates src, Coordinates dst, MyColor color);
    public void openPortal(Coordinates positsion, MyColor color);
}
