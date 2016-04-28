package controller;

import controller.ViewInterfacesAndEnums.IAnimationView;
import model.Colonel;
import utils.Coordinates;
import utils.MyColor;

import java.awt.event.KeyEvent;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class AnimationController {
    private IAnimationView animationView;

    public AnimationController(IAnimationView _animationView){
        animationView = _animationView;
    }

    public boolean animationEventHandler(KeyEvent key){
        Engine engine = MainController.getInstance().engine;
        Colonel jaffa = engine.jaffa;
        Colonel colonel = engine.colonel;
        switch (key.getKeyCode()){
            case KeyEvent.VK_F:
                animationView.shoot(jaffa.getPosition(),jaffa.shoot(MyColor.RED), MyColor.RED);
                break;
            case KeyEvent.VK_R:
                animationView.shoot(jaffa.getPosition(),jaffa.shoot(MyColor.GREEN), MyColor.GREEN);
                break;
            case KeyEvent.VK_END:
                animationView.shoot(colonel.getPosition(),colonel.shoot(MyColor.YELLOW), MyColor.YELLOW);
                break;
            case KeyEvent.VK_HOME:
                animationView.shoot(colonel.getPosition(),colonel.shoot(MyColor.BLUE), MyColor.BLUE);
                break;
            default:
                return false;
        }
        return true;
    }

    public void portalEventHandler(Coordinates positsion, Coordinates direction, MyColor color){
        animationView.openPortal(positsion,direction,color);
    }
}
