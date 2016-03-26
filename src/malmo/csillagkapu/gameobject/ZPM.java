package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class ZPM extends ItemObject {
	
	public static int zpmCount = 0;
	
	public ZPM(){
		zpmCount++;
	}
	
	@Override
	public boolean hit(Bullet bul){
		beginFunction();
		return ret(false);
	}
	
	@Override
	public boolean place(ItemObject object){
		beginFunction();
		return ret(false);
	}
	
	@Override
	public boolean pick(Colonel col){
		beginFunction();
		return ret(true);
	}
	
	@Override
	public boolean stepIn(Colonel col){
		beginFunction();
		zpmCount++;
		
		return ret(false);
	}
}
