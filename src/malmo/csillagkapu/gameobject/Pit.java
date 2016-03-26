package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class Pit extends LandObject {
	
	public Pit(){ }
	
	@Override
	public boolean hit(Bullet bul){
		beginFunction();
		return ret(false);
	}
	
	@Override
	public boolean place(ItemObject object){
		beginFunction();
		return ret(true);
	}
	
	@Override
	public boolean stepIn(Colonel col){
		beginFunction();
		col.die();
		return ret(true);
	}
}
