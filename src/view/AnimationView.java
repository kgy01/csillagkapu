package view;

import controller.ViewInterfacesAndEnums.IAnimationView;
import utils.Coordinates;
import utils.MyColor;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class AnimationView implements IAnimationView {

    private MainView mainView;

    AnimationView(MainView _mainView){
        mainView = _mainView;
    }
    @Override
    public void shoot(Coordinates src, Coordinates dst, MyColor color) {

    }

    @Override
    public void openPortal(Coordinates positsion, Coordinates direction, MyColor color) {

    }
}
