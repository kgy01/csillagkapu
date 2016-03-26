package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class Wall extends LandObject{
//A Pick(), OpenPortal(), Place() függvények nem változtak, ezért ezek nem kerültek be az osztályba
	
	//False-al térünk vissza, ugyanis a kapitány nem léphet bele a falba
	@Override
	public boolean stepIn (Colonel col){
		beginFunction();
		return ret(false);
	}

	//False-al térünk vissza, ugyanis akapitány nem léphet ki a falból(már belépni sem léphetett be)
	@Override
	public boolean stepOut (Colonel col){
		beginFunction();
		return ret(false);
	}
	
	//False-al térünk vissza, ugyanis a nem lehet rajta keresztül lőni
	@Override
	public boolean hit (Bullet bul){
		beginFunction();
		return ret(false);
	}
}
