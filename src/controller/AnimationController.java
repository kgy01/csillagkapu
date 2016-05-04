package controller;

import controller.ViewInterfacesAndEnums.IAnimationView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import model.Colonel;
import utils.Coordinates;
import utils.MyColor;


/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class AnimationController {
    private IAnimationView animationView;

    public AnimationController(IAnimationView _animationView){
        animationView = _animationView;
    }

    public boolean animationEventHandler(KeyEvent key) {
        Engine engine = MainController.getInstance().engine;
        Colonel jaffa = engine.jaffa;
        Colonel colonel = engine.colonel;
        if (key.getCode().equals(KeyCode.F)) {
            animationView.shoot(jaffa.getPosition(), jaffa.shoot(MyColor.RED), MyColor.RED);
        } else if (key.getCode().equals(KeyCode.R)) {
            animationView.shoot(jaffa.getPosition(), jaffa.shoot(MyColor.GREEN), MyColor.GREEN);
        } else if (key.getCode().equals(KeyCode.END)) {
            animationView.shoot(colonel.getPosition(), colonel.shoot(MyColor.YELLOW), MyColor.YELLOW);
        } else if (key.getCode().equals(KeyCode.HOME)) {
            animationView.shoot(colonel.getPosition(), colonel.shoot(MyColor.BLUE), MyColor.BLUE);
        } else {
            return false;
        }
        MainController.getInstance().drawAll();
        return true;
    }

    public void portalEventHandler(Coordinates positsion, Coordinates direction, MyColor color){
        animationView.openPortal(positsion,direction,color);
    }
}
