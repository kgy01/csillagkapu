package controller.ViewInterfacesAndEnums;

/**
 * Created by MR.ESSIG on 4/27/2016.
 */
public interface IMainView {
    public IPlayerView getPlayerView();
    public IAnimationView getAnimationView();
    public IBaseMapView getBaseMapView();
    public void gameOver(String winner);
    public void inventoryChange(int colonelZPMs, int jaffaZPMs);
}
