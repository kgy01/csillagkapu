package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class SpecialWall extends Wall{

	
	@Override
	boolean hit (Bullet bul){		
		beginFunction();
		return Logger.ret(true);		
	}
}
