package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class SpecialWall extends Wall{
	
	@Override
	public boolean hit(Bullet bul){
		beginFunction();
		return ret(true);
	}
}
