package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class ZPM extends ItemObject {
	
	Publi ZPM(){ }
	
	boolean hit(Bullet bul){
		beginFunction();
		return ret(false);
	}
	
	@Override
	boolean place(ItemObject object){
		beginFunction();
		return ret(false);
	}
	
	@Override
	boolean pick(Colonel col){
		beginFunction();
		return ret(true);
	}
	
	@Override
	boolean stepIn(Colonel col){
		beginFunction();
		return ret(false);
	}
}
