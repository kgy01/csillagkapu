package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

class Wall extends Wall{
	
	@Override
	boolean stepIn (Colonel col){		
		beginFunction();
		return false;		
	}
	
	@Override
	boolean stepOut (Colonel col){		
		beginFunction();
		return false;		
	}
	
	@Override
	boolean place (ItemObject obj){		
		beginFunction();
		return false;		
	}
	
	@Override
	boolean openPortal (Portal portal){		
		beginFunction();
		return false;		
	}
	
	@Override
	boolean pick (Colonel col){		
		beginFunction();
		return false;		
	}
	
	@Override
	boolean hit (Bullet bul){		
		beginFunction();
		return true;		
	}
}
