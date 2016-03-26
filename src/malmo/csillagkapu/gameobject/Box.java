package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

public class Box extends ItemObject {
	
	public Box(){ };
	
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
		if(col.backpack.isEmpty()){
			return ret(true);
		}
		else{
			return ret(false);
		}
	}
	
	@Override
	public boolean stepIn(Colonel col){
		beginFunction();
		return ret(false);
	}
}