package model;


import controller.MainController;

public class Field {
	// Terept�rgy
	private LandObject landobject;
	// Mozgathat� t�rgy
	private ItemObject itemobject;
	private Player player;
	private Replicator replicator;
	// Figyelmeztetj�k a mez�t, hogy ne t�r�lje az ItemObjectj�t
	private boolean removeItemObject = true;
	
	/*public Field(LandObject _landobject) {
		landobject = _landobject;
	}*/
	
	// J�t�kos a mez�re l�p
	public boolean stepIn(Player _player){
		// Van-e m�sik j�t�kos a mez�n?
		if (player == null || _player.toString().equals("?")) {
			// Ha van mozgathat� objektum a mez�n, az engedi-e hogy r�l�pjen a j�t�kos?
			if (itemobject != null) {
				boolean res = itemobject.stepIn(_player);
				if (res && removeItemObject)
					setItemObject(null);
				removeItemObject = true;
				return res;
			}
			else {
				// Ha nincs mozgathat� objektum, de van terept�rgy, az engedi-e hogy r�l�pjen a j�t�kos?
				if (landobject != null) {
					return landobject.stepIn(_player);
				}
				else {
					return true;
				}
			}
		}
		else {
			// Van m�sik j�t�kos a mez�n
			return false;
		}
	}
	
	// J�t�kos lel�p a mez�r�l
	public boolean stepOut(Player _player) {
		// J�t�kos leregisztr�l�sa
		player = null;
		// Ha van terept�rgy, akkor sz�lunk neki, hogy lel�pett r�la a j�t�kos
		if (landobject != null) {
			return landobject.stepOut(_player);
		}
		else {	
			return true;
		}
	}
	
	public boolean place(Player _player, ItemObject _item) {
		//Logger.inFunction("-->[Field:]place(ItemObject)");
		// Van-e m�sik j�t�kos a mez�n?
		if (player == null) {
			// Ha van mozgathat� objektum a mez�n, az engedi-e hogy r�rakjon valamit a j�t�kos?
			if (itemobject != null) {
				if (itemobject.place(_player, _item)) {
					// Ha siker�l a let�tel, akkor �rtes�teni kell a landobjectet.
					if (landobject != null)
						if (landobject.place(_player, itemobject))
							_item.setField(this);
					return true;
				}
				return false;
			}
			else {
				// Ha nincs mozgathat� objektum, de van terept�rgy, az engedi-e hogy r�rakjon valamit a j�t�kos?
				if (landobject != null) {
					if (landobject.place(_player, _item)) {
						if (removeItemObject)
							setItemObject(_item);
						removeItemObject = true;
						return true;
					}
					return false;
				}
				else {
					setItemObject(_item);
					_item.setField(this);
					return true;
				}
			}
		}
		else {
			// Van j�t�kos a mez�n
			return false;
		}		
	}
	
	public boolean pick(Player _player) {
		//Logger.inFunction("-->[Field:]pick(Colonel)");
		if (player == null) {
			if (itemobject != null) {
				if (itemobject.pick(_player)) {
					// Ha siker�lt a felv�tel, akkor itemobject nulla lesz �s �rtes�tj�k a landobject-et, hogy elvettek fel�le valamit
					if (removeItemObject)
						setItemObject(null);
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
	
	// F�ggv�ny a mez� karakteres ki�r�s�hoz
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
	
	// Versenyz� be�ll�t�sa a mez�re
	public void setPlayer(Player _player) {
		player = _player;
	}
	
	// �res-e a mez� (elhelyezhet�-e r� �j ZPM
	public boolean isEmpty() {
		return (player == null && itemobject == null && landobject == null);
	}
	
	// Megl�j�k l�ved�kkel a mez�t
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
	
	// Replicator beregisztr�l�sa az adott mez�re
	public void setReplicator(Replicator _replicator) {
		replicator = _replicator;
	}
	// Replicator kiregisztr�l�sa az adott mez�r�l
	public void unsetReplicator() {
		replicator = null;
	}
	// ItemObject-et ne t�r�lje
	public void skipItemObject() {
		removeItemObject = false; 
	}
	
	// ItemObject elt�vol�t�sa
	public void setItemObject(ItemObject _item) {
		itemobject = _item;
	}
	
	// ItemObject elt�vol�t�sa
	public void setLandObject(LandObject _land) {
		landobject = _land;
	}

	public LandObject getLandObject() {
		return landobject;
	}
	public ItemObject getItemObject() {
		return itemobject;
	}
}
