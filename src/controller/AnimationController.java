package controller;

import controller.ViewInterfaces.IAnimationView;
import model.Colonel;
import utils.MyColor;

import java.awt.event.KeyEvent;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public class AnimationController {
    private IAnimationView animationView;

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
}
