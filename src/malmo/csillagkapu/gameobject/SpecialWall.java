package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

class Wall extends Wall{
	
	@Override
	boolean stepIn (Colonel col){		
		return false;		
	}
	
	@Override
	boolean stepOut (Colonel col){		
		return false;		
	}
	
	@Override
	boolean place (ItemObject obj){		
		return false;		
	}
	
	@Override
	boolean openPortal (Portal portal){		
		return false;		
	}
	
	@Override
	boolean pick (Colonel col){		
		return false;		
	}
	
	@Override
	boolean hit (Bullet bul){		
		return true;		
	}
}
