package view;

import controller.ViewInterfacesAndEnums.IPlayerView;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import utils.Coordinates;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class PlayerView extends Canvas implements IPlayerView {
    private MainView mainView;

    Coordinates colonelCd = Coordinates.UP;
    Coordinates jaffaCd = Coordinates.UP;
    Coordinates replicatorCd = Coordinates.UP;

    private ImageView colonelImageView;
    private ImageView jaffaImageView;
    private ImageView replicatorImageView;

    private int fieldCanvasSize;

    boolean isInited = false;

    PlayerView(MainView _mainView){
        mainView = _mainView;
        setWidth(mainView.getStage().getWidth());
        setHeight(mainView.getStage().getHeight());
    }

    public void init(){
        fieldCanvasSize = (int)((BaseMapView)(mainView.getBaseMapView())).getCanvasSize();

        colonelImageView = new ImageView(mainView.imageLoader.getImage("players/colonel",fieldCanvasSize,fieldCanvasSize));
        jaffaImageView = new ImageView(mainView.imageLoader.getImage("players/jaffa",fieldCanvasSize,fieldCanvasSize));
        replicatorImageView = new ImageView(mainView.imageLoader.getImage("players/replicator",fieldCanvasSize,fieldCanvasSize));

        isInited = true;
    }
    @Override
    public void drawJ(Coordinates positsion, Coordinates direction, boolean isBox) {
        if(isInited == false){
            init();
        }
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(jaffaCd.getX()*fieldCanvasSize,jaffaCd.getY()*fieldCanvasSize,fieldCanvasSize,fieldCanvasSize);
        jaffaCd = positsion;

        if(direction.getX() == Coordinates.DOWN.getX() && direction.getY() == Coordinates.DOWN.getY()){
            jaffaImageView.setRotate(0);
        }else if(direction.getX() == Coordinates.LEFT.getX() && direction.getY() == Coordinates.LEFT.getY()){
            jaffaImageView.setRotate(90);
        }else if(direction.getX() == Coordinates.UP.getX() && direction.getY() == Coordinates.UP.getY()){
            jaffaImageView.setRotate(180);
        }else if(direction.getX() == Coordinates.RIGHT.getX() && direction.getY() == Coordinates.RIGHT.getY()){
            jaffaImageView.setRotate(270);
        }

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        Image rotatedImage = jaffaImageView.snapshot(params,null);
        if(isBox) {
            gc.drawImage(mainView.imageLoader.getImage("box",fieldCanvasSize / 2.0, fieldCanvasSize / 2.0),
                    jaffaCd.getX()*fieldCanvasSize + fieldCanvasSize / 4.0 + direction.getX()*fieldCanvasSize/4.0,
                    jaffaCd.getY()*fieldCanvasSize + fieldCanvasSize / 4.0 + direction.getY()*fieldCanvasSize/4.0);
        }
        gc.drawImage(rotatedImage, jaffaCd.getX()*fieldCanvasSize, jaffaCd.getY()*fieldCanvasSize);
        /*gc.setLineWidth(1);
        gc.setStroke(Color.GREEN);
        gc.strokeRect(jaffaCd.getX()*fieldCanvasSize, jaffaCd.getY()*fieldCanvasSize, fieldCanvasSize,fieldCanvasSize);*/
    }

    @Override
    public void drawC(Coordinates positsion, Coordinates direction, boolean isBox) {
        if(isInited == false){
            init();
        }
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(colonelCd.getX()*fieldCanvasSize ,colonelCd.getY()*fieldCanvasSize ,fieldCanvasSize,fieldCanvasSize);
        colonelCd = positsion;

        if(direction.getX() == Coordinates.DOWN.getX() && direction.getY() == Coordinates.DOWN.getY()){
            colonelImageView.setRotate(0);
        }else if(direction.getX() == Coordinates.LEFT.getX() && direction.getY() == Coordinates.LEFT.getY()){
            colonelImageView.setRotate(90);
        }else if(direction.getX() == Coordinates.UP.getX() && direction.getY() == Coordinates.UP.getY()){
            colonelImageView.setRotate(180);
        }else if(direction.getX() == Coordinates.RIGHT.getX() && direction.getY() == Coordinates.RIGHT.getY()){
            colonelImageView.setRotate(270);
        }

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        Image rotatedImage = colonelImageView.snapshot(params,null);

        if(isBox) {
            gc.drawImage(mainView.imageLoader.getImage("box",fieldCanvasSize / 2.0, fieldCanvasSize / 2.0),
                    colonelCd.getX()*fieldCanvasSize + fieldCanvasSize / 4.0 + direction.getX()*fieldCanvasSize/4.0,
                    colonelCd.getY()*fieldCanvasSize + fieldCanvasSize / 4.0 + direction.getY()*fieldCanvasSize/4.0);
        }

        gc.drawImage(rotatedImage, colonelCd.getX()*fieldCanvasSize, colonelCd.getY()*fieldCanvasSize);
        /*
        gc.setLineWidth(1);
        gc.setStroke(Color.BLUE);
        gc.strokeRect(colonelCd.getX()*fieldCanvasSize, colonelCd.getY()*fieldCanvasSize, fieldCanvasSize,fieldCanvasSize);*/

    }

    @Override
    public void drawR(Coordinates positsion, Coordinates direction) {
        if(isInited == false){
            init();
        }

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(replicatorCd.getX()*fieldCanvasSize,replicatorCd.getY()*fieldCanvasSize,fieldCanvasSize,fieldCanvasSize);

        if(positsion == null || direction == null){
            gc.clearRect(replicatorCd.getX()*fieldCanvasSize,replicatorCd.getY()*fieldCanvasSize,fieldCanvasSize,fieldCanvasSize);
            return;
        }
        replicatorCd = positsion;

        if(direction.getX() == Coordinates.DOWN.getX() && direction.getY() == Coordinates.DOWN.getY()){
            replicatorImageView.setRotate(0);
        }else if(direction.getX() == Coordinates.LEFT.getX() && direction.getY() == Coordinates.LEFT.getY()){
            replicatorImageView.setRotate(90);
        }else if(direction.getX() == Coordinates.UP.getX() && direction.getY() == Coordinates.UP.getY()){
            replicatorImageView.setRotate(180);
        }else if(direction.getX() == Coordinates.RIGHT.getX() && direction.getY() == Coordinates.RIGHT.getY()){
            replicatorImageView.setRotate(270);
        }

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        Image rotatedImage = replicatorImageView.snapshot(params,null);

        gc.drawImage(rotatedImage, replicatorCd.getX()*fieldCanvasSize, replicatorCd.getY()*fieldCanvasSize);
        /*
        gc.setStroke(Color.RED);
        gc.strokeRect(replicatorCd.getX()*fieldCanvasSize, replicatorCd.getY()*fieldCanvasSize , fieldCanvasSize,fieldCanvasSize);*/
    }
}
