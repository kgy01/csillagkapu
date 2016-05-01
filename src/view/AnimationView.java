package view;

import controller.ViewInterfacesAndEnums.IAnimationView;
import javafx.scene.canvas.Canvas;
import utils.Coordinates;
import utils.MyColor;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class AnimationView extends Canvas implements IAnimationView {

    private MainView mainView;

    AnimationView(MainView _mainView){
        mainView = _mainView;
        setWidth(mainView.getStage().getWidth());
        setHeight(mainView.getStage().getHeight());
    }
    @Override
    public void shoot(Coordinates src, Coordinates dst, MyColor color) {

    }

    @Override
    public void openPortal(Coordinates positsion, Coordinates direction, MyColor color) {

    }

    @Override
    public void animate(){
        System.out.println("fire");
    }
}
