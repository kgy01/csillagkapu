package gameobjects;

import utils.Logger;

public class Field {
	private LandObject landobject;
	private ItemObject itemobject;
	
	public Field(LandObject _land, ItemObject _item) {
		landobject = _land;
		itemobject = _item;
	}
	
	public boolean stepIn(Colonel col){
		Logger.inFunction("-->[Field:]stepIn(Colonel)");
		if (itemobject != null) {
			boolean ret = itemobject.stepIn(col);
			Logger.outFunction("<--[Field:]" + ret);
			return ret;
		}
		else {
			if (landobject != null) {
				boolean ret = landobject.stepIn(col);
				Logger.outFunction("<--[Field:]" + ret);
				return ret;
			}
			else {
				Logger.outFunction("<--[Field:]true");
				return true;
			}
		}
	}
	
	public boolean stepOut(Colonel col) {
		Logger.inFunction("-->[Field:]stepOut(Colonel)");
		if (landobject != null) {
			boolean ret = landobject.stepOut(col);
			Logger.outFunction("<--[Field:]" + ret);
			return ret;
		}
		else {	
			Logger.outFunction("<--[Field:]true");
			return true;
		}
	}
	
	public boolean place(ItemObject _item) {
		Logger.inFunction("-->[Field:]place(ItemObject)");
		if (itemobject != null) {
			boolean ret = itemobject.place(_item);
			Logger.outFunction("<--[Field:]" + ret);
			return ret;
		}
		else {
			if (landobject != null) {
				boolean ret = landobject.place(_item);
				Logger.outFunction("<--[Field:]" + ret);
				return ret;
			}
			else {	
				Logger.outFunction("<--[Field:]true");
				return true;
			}
		}
	}
	
	public boolean pick(Colonel col) {
		Logger.inFunction("-->[Field:]pick(Colonel)");
		if (itemobject != null) {
			if (itemobject.pick(col)) {
				if (landobject != null) {
					landobject.pick(col);
				}
				Logger.outFunction("<--[Field:]true");
				return true;
			}
			Logger.outFunction("<--[Field:]false");
			return false;
		}
		else {
			Logger.outFunction("<--[Field:]false");
			return false;
		}
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
