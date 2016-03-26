package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

class Wall extends LandObject{
//A Pick(), OpenPortal(), Place() függvények nem változtak, ezért ezek nem kerültek be az osztályba
	
	//False-al térünk vissza, ugyanis a kapitány nem léphet bele a falba
	@Override
	boolean stepIn (Colonel col){		
		beginFunction();
		return Logger.ret(false);		
	}

	//False-al térünk vissza, ugyanis a kapitány nem léphet ki a falból(már belépni sem léphetett be)	
	@Override
	boolean stepOut (Colonel col){		
		beginFunction();
		return Logger.ret(false);		
	}
	
	//False-al térünk vissza, ugyanis a nem lehet rajta keresztül lõni
	@Override
	boolean hit (Bullet bul){		
		beginFunction();
		return Logger.ret(false);		
	}
}
