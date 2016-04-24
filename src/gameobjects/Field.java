package gameobjects;


public class Field {
	// Tereptárgy
	private LandObject landobject;
	// Mozgatható tárgy
	private ItemObject itemobject;
	private Player player;
	private Replicator replicator;
	// Figyelmeztetjük a mezõt, hogy ne törölje az ItemObjectjét
	private boolean removeItemObject = true;
	
	/*public Field(LandObject _landobject) {
		landobject = _landobject;
	}*/
	
	// Játékos a mezõre lép
	public boolean stepIn(Player _player){
		// Van-e másik játékos a mezõn?
		if (player == null) {
			// Ha van mozgatható objektum a mezõn, az engedi-e hogy rálépjen a játékos?
			if (itemobject != null) {
				boolean res = itemobject.stepIn(_player);
				if (res && removeItemObject)
					itemobject = null;
				removeItemObject = true;
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
	
	public boolean place(Player _player, ItemObject _item) {
		//Logger.inFunction("-->[Field:]place(ItemObject)");
		// Van-e másik játékos a mezõn?
		if (player == null) {
			// Ha van mozgatható objektum a mezõn, az engedi-e hogy rárakjon valamit a játékos?
			if (itemobject != null) {
				if (itemobject.place(_player, _item)) {
					// Ha sikerül a letétel, akkor értesíteni kell a landobjectet.
					if (landobject != null)
						if (landobject.place(_player, itemobject))
							_item.setField(this);
					return true;
				}
				return false;
			}
			else {
				// Ha nincs mozgatható objektum, de van tereptárgy, az engedi-e hogy rárakjon valamit a játékos?
				if (landobject != null) {
					if (landobject.place(_player, _item)) {
						if (removeItemObject)
							itemobject = _item;
						removeItemObject = true;
						return true;
					}
					return false;
				}
				else {
					itemobject = _item;
					_item.setField(this);
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
					if (removeItemObject)
						itemobject = null;
					removeItemObject = true;
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
		if (replicator != null)
			return "?";
		else {
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
	}
	
	// Versenyzõ beállítása a mezõre
	public void setPlayer(Player _player) {
		player = _player;
	}
	
	// Üres-e a mezõ (elhelyezhetõ-e rá új ZPM
	public boolean isEmpty() {
		return (player == null && itemobject == null && landobject == null);
	}
	
	// Meglõjük lövedékkel a mezõt
	public boolean hit(Bullet bul) {
		if (replicator != null)
			return replicator.hit(bul);
		else {
			if (player != null) {
				return player.hit(bul);
			}
			else {
				if (itemobject != null) {
					return itemobject.hit(bul);
				}
				else {
					if (landobject != null) {
						return landobject.hit(bul);
					}
					else {
						return false;
					}
				}
			}
		}
	}
	
	// Replicator beregisztrálása az adott mezõre
	public void setReplicator(Replicator _replicator) {
		replicator = _replicator;
	}
	// Replicator kiregisztrálása az adott mezõrõl
	public void unsetReplicator() {
		replicator = null;
	}
	// ItemObject-et ne törölje
	public void skipItemObject() {
		removeItemObject = false; 
	}
	
	// ItemObject eltávolítása
	public void setItemObject(ItemObject _item) {
		itemobject = _item;
	}
	
	// ItemObject eltávolítása
	public void setLandObject(LandObject _land) {
		landobject = _land;
	}
}
