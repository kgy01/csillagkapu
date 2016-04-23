package gameobjects;

import utils.Logger;

public class Wall extends LandObject{
	//A Pick(), OpenPortal(), Place() függvények nem változtak, ezért ezek nem kerültek be az osztályba
		
		public Wall(Field _field) {
			super(_field);
		}
	
		//False-al térünk vissza, ugyanis a kapitány nem léphet bele a falba
		@Override
		public boolean stepIn(Player _player){
			//Logger.inFunction("-->[Wall:]stepIn(Colonel)");
			//Logger.outFunction("<--[Wall:]false");
			return false;
		}

		//False-al térünk vissza, ugyanis akapitány nem léphet ki a falból(már belépni sem léphetett be)
		@Override
		public boolean stepOut(Player _player){
			//Logger.inFunction("-->[Wall:]stepOut(Colonel)");
			//Logger.outFunction("<--[Wall:]true");
			return true;
		}
		
		// True-val t�r�nk vissza, becsap�sott a l�ved�k
		@Override
		public boolean hit(Bullet bul){
			//Logger.inFunction("-->[Wall:]hit(Bullet)");
			//Logger.outFunction("<--[Wall:]true");
			return true;
		}
		
		@Override
		public boolean place(Player _player, ItemObject object){
			//Logger.inFunction("-->[Wall:]place(ItemObject)");
			//Logger.outFunction("<--[Wall:]false");
			return false;
		}
		
		@Override
		public String toString() {
			return "#";
		}
		
		public String toStringVerbose() {
			return "Wall";
		}
	}
