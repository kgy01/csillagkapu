package gameobjects;

import utils.Logger;

public class Wall extends LandObject{
	//A Pick(), OpenPortal(), Place() függvények nem változtak, ezért ezek nem kerültek be az osztályba
		
		//False-al térünk vissza, ugyanis a kapitány nem léphet bele a falba
		@Override
		public boolean stepIn(Colonel col){
			Logger.inFunction("-->[Wall:]stepIn(Colonel)");
			Logger.outFunction("<--[Wall:]false");
			return false;
		}

		//False-al térünk vissza, ugyanis akapitány nem léphet ki a falból(már belépni sem léphetett be)
		@Override
		public boolean stepOut(Colonel col){
			Logger.inFunction("-->[Wall:]stepOut(Colonel)");
			Logger.outFunction("<--[Wall:]true");
			return true;
		}
		
		//False-al térünk vissza, ugyanis a nem lehet rajta keresztül lőni
		@Override
		public boolean hit(Bullet bul){
			Logger.inFunction("-->[Wall:]hit(Bullet)");
			Logger.outFunction("<--[Wall:]true");
			return true;
		}
		
		@Override
		public boolean place(ItemObject object){
			Logger.inFunction("-->[Wall:]place(ItemObject)");
			Logger.outFunction("<--[Wall:]false");
			return false;
		}
	}
