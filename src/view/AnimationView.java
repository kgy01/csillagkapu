package view;

import controller.MainController;
import controller.ViewInterfacesAndEnums.IAnimationView;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import model.Portal;
import utils.Coordinates;
import utils.MyColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MR.ESSIG on 4/28/2016.
 */
public class AnimationView extends Canvas implements IAnimationView {

    private MainView mainView;
    private ArrayList<ShootAnimation> shoots = new ArrayList<>();

    long animationCounter = 0;

    AnimationView(MainView _mainView){
        mainView = _mainView;
        setWidth(mainView.getStage().getWidth());
        setHeight(mainView.getStage().getHeight());

    }
    @Override
    public void shoot(Coordinates src, Coordinates dst, MyColor color) {
        if(src != null && dst != null) {
            shoots.add(new ShootAnimation(src, dst, color));
        }
    }

    @Override
    public void openPortal(Coordinates positsion, Coordinates direction, MyColor color) {

    }

    @Override
    public void animate(){
        GraphicsContext gc = getGraphicsContext2D();
        animationCounter++;
        double fieldCanvasSize = ((BaseMapView)(mainView.getBaseMapView())).getCanvasSize();
        if(animationCounter%60 == 0){
            MainController.getInstance().replicatorStepEventHandler();
        }

        if(animationCounter%3 == 0) {
            gc.clearRect(0,0,getWidth(),getHeight());

            for (int i = 0; i < shoots.size(); i++) {
                ShootAnimation current = shoots.get(i);
                gc.setGlobalAlpha(1.0 - 1.0/10.0*((double)current.animation_number)); // 0.5s-ig animal kb
                current.animation_number++;
                gc.drawImage(current.leaser,
                        current.drawStartCoordinates.getX()*fieldCanvasSize + current.dir.getX()*fieldCanvasSize/2.0,
                        current.drawStartCoordinates.getY()*fieldCanvasSize + current.dir.getY()*fieldCanvasSize/2.0);
                if(current.animation_number >= 10){
                    shoots.remove(current);
                    i--;
                }
            }

        }
    }

 
    private class ShootAnimation{

        public Coordinates src;
        public Coordinates dst;
        public Coordinates dir;
        public Coordinates drawStartCoordinates;
        public int animation_number = 0;
        public Image leaser;public ShootAnimation(Coordinates _src, Coordinates _dst, MyColor _color){
            src = _src;
            dst = _dst;
            double fieldCanvasSize = ((BaseMapView)(mainView.getBaseMapView())).getCanvasSize();
            double lenght = Math.sqrt((src.getX()-dst.getX())*(src.getX()-dst.getX()) + (src.getY()-dst.getY())*(src.getY()-dst.getY()));
            ImageView leaserView = null;


            switch(_color){
                case BLUE:
                    leaserView = new ImageView(mainView.imageLoader.getImage("leasers/blue_leaser",422,90));
                    break;
                case RED:
                    leaserView = new ImageView(mainView.imageLoader.getImage("leasers/red_leaser",422,90));
                    break;
                case GREEN:
                    leaserView = new ImageView(mainView.imageLoader.getImage("leasers/green_leaser",422,90));
                    break;
                case YELLOW:
                    leaserView = new ImageView(mainView.imageLoader.getImage("leasers/yellow_leaser",422,90));
                    break;
            }

            leaserView.setFitWidth(fieldCanvasSize*lenght);
            leaserView.setFitHeight(fieldCanvasSize);

            drawStartCoordinates = src;
            dir = new Coordinates(1,0);
            if((src.getX() - dst.getX()) == 0){
                if((dst.getY() - src.getY()) > 0){
                    leaserView.setRotate(90);
                    dir = new Coordinates(0,1);
                }else{
                    leaserView.setRotate(270);
                    drawStartCoordinates = dst;
                    dir = new Coordinates(0,1);
                }
            }
            else if((dst.getX() - src.getX()) < 0){
                leaserView.setRotate(180);
                drawStartCoordinates = dst;
                dir = new Coordinates(1,0);
            }

            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);

            leaser = leaserView.snapshot(params,null);
        }



    }

    private class PortalAnimation{

    }
}
