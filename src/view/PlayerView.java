package view;

import controller.ViewInterfacesAndEnums.IPlayerView;
import javafx.scene.canvas.Canvas;
import utils.Coordinates;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class PlayerView extends Canvas implements IPlayerView {
    private MainView mainView;

    PlayerView(MainView _mainView){
        mainView = _mainView;
    }
    @Override
    public void drawJ(Coordinates positsion, Coordinates direction, boolean isBox) {

    }

    @Override
    public void drawC(Coordinates positsion, Coordinates direction, boolean isBox) {

    }

    @Override
    public void drawR(Coordinates positsion, Coordinates direction) {

    }
}