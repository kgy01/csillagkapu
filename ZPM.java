package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class ZPM extends ItemObject {
	
	Publi ZPM(){ }
	
	boolean hit(Bullet bul){
		beginFunction();
		endFunction("false");
		return false;
	}
	
	@Override
	boolean place(ItemObject object){
		beginFunction();
		endFunction("false");
		return false;
	}
	
	@Override
	boolean pick(Colonel col){
		beginFunction();
		endFunction("true");
		return true;
	}
	
	@Override
	boolean stepIn(Colonel col){
		beginFunction();
		endFunction("false");
		return false;
	}
}
