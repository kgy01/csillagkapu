package gameobjects;

import utils.Logger;

public class Field {
	// Tereptárgy
	private LandObject landobject;
	// Mozgatható tárgy
	private ItemObject itemobject;
	private Player player;
	
	public Field(LandObject _land, ItemObject _item, Player _player) {
		landobject = _land;
		itemobject = _item;
		player = _player;
	}
	
	// Játékos a mezõre lép
	public boolean stepIn(Player _player){
		// Van-e másik játékos a mezõn?
		if (player == null) {
			// Ha van mozgatható objektum a mezõn, az engedi-e hogy rálépjen a játékos?
			if (itemobject != null) {
				boolean res = itemobject.stepIn(_player);
				if (res)
					itemobject = null;
				return res;
			}
			else {
				// Ha nincs mozgatható objektum, de van tereptárgy, az engedi-e hogy rálépjen a játékos?
				if (landobject != null) {
					return landobject.stepIn(_player);
				}
				else {
					return true;
				}
			}
		}
		else {
			// Van másik játékos a mezõn
			return false;
		}
	}
	
	// Játékos lelép a mezõrõl
	public boolean stepOut(Player _player) {
		// Játékos leregisztrálása
		player = null;
		// Ha van tereptárgy, akkor szólunk neki, hogy lelépett róla a játékos
		if (landobject != null) {
			return landobject.stepOut(_player);
		}
		else {	
			return true;
		}
	}
	
	public boolean place(ItemObject _item) {
		//Logger.inFunction("-->[Field:]place(ItemObject)");
		// Van-e másik játékos a mezõn?
		if (player == null) {
			// Ha van mozgatható objektum a mezõn, az engedi-e hogy rárakjon valamit a játékos?
			if (itemobject != null) {
				return itemobject.place(_item);
			}
			else {
				// Ha nincs mozgatható objektum, de van tereptárgy, az engedi-e hogy rárakjon valamit a játékos?
				if (landobject != null) {
					return landobject.place(_item);
				}
				else {
					itemobject = _item;
					return true;
				}
			}
		}
		else {
			// Van játékos a mezõn
			return false;
		}		
	}
	
	public boolean pick(Player _player) {
		//Logger.inFunction("-->[Field:]pick(Colonel)");
		if (player == null) {
			if (itemobject != null) {
				if (itemobject.pick(_player)) {
					// Ha sikerült a felvétel, akkor itemobject nulla lesz és értesítjük a landobject-et, hogy elvettek felöle valamit
					itemobject = null;
					if (landobject != null) {
						landobject.pick(_player);
					}
					//Logger.outFunction("<--[Field:]true");
					return true;
				}
				//Logger.outFunction("<--[Field:]false");
				return false;
			}
			else {
				//Logger.outFunction("<--[Field:]false");
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	// Függvény a mezõ karakteres kiírásához
	@Override
	public String toString() {
		if (player != null) {
			return player.toString();
		}
		else {
			if (itemobject != null) {
				return itemobject.toString();
			}
			else {
				if (landobject != null) {
					return landobject.toString();
				}
				else {
					return " ";
				}
			}
		}
	}
	
	// Versenyzõ beállítása a mezõre
	public void setPlayer(Player _player) {
		player = _player;
	}
	
	// Üres-e a mezõ (elhelyezhetõ-e rá új ZPM
	public boolean isEmpty() {
		return (player == null && itemobject == null && landobject == null);
	}
	
	/*public boolean openPortal(Portal port) {
		beginFunction();
		if (itemobject == null) {
			return ret(landobject.openPortal(port));
		}
		return false;
	}
	
	public boolean hit(Bullet bul) {
		beginFunction();
		return ret(false);
	}*/
}
