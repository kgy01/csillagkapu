package malmo.csillagkapu.gameobject;

import static malmo.csillagkapu.util.Logger.*;

class Wall extends LandObject{
//A Pick(), OpenPortal(), Place() f�ggv�nyek nem v�ltoztak, ez�rt ezek nem ker�ltek be az oszt�lyba
	
	//False-al t�r�nk vissza, ugyanis a kapit�ny nem l�phet bele a falba
	@Override
	boolean stepIn (Colonel col){		
		beginFunction();
		return Logger.ret(false);		
	}

	//False-al t�r�nk vissza, ugyanis a kapit�ny nem l�phet ki a falb�l(m�r bel�pni sem l�phetett be)	
	@Override
	boolean stepOut (Colonel col){		
		beginFunction();
		return Logger.ret(false);		
	}
	
	//False-al t�r�nk vissza, ugyanis a nem lehet rajta kereszt�l l�ni
	@Override
	boolean hit (Bullet bul){		
		beginFunction();
		return Logger.ret(false);		
	}
}
