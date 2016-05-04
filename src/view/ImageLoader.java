package view;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.HashMap;

/**
 * Created by MR.ESSIG on 5/4/2016.
 */
public class ImageLoader {

    public double fieldCanvasSize;
    public int style;

    public HashMap<String,Image> imageHashMap;
    public ImageLoader(int _style){
        style = _style;
        imageHashMap  = new HashMap<>();
    }

    public Image create(String name, double width, double height){
        ImageView current = null;
        try {
            current = new ImageView(new Image("/resources/mapStyle_" + style + "/" + name + ".png", width, height, true, true));
        }catch(Exception e){
            System.out.println(name + " file nincs megadva vagy nem megfelelo a formatum :" + name + ".png");
        }
        current.setFitHeight(height);
        current.setFitWidth(width);

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        Image currentImage = current.snapshot(params,null);
        if(imageHashMap.containsKey(name)){
            imageHashMap.remove(name);
        }
        imageHashMap.put(name, currentImage);
        return currentImage;
    }

    public Image getImage(String name,double width, double height){
        if(!imageHashMap.containsKey(name) || imageHashMap.get(name).getWidth() != width || imageHashMap.get(name).getHeight() != height){
            create(name,width,height);
        }
        return imageHashMap.get(name);
    }
}
