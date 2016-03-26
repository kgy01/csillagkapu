package malmo.csillagkapu.gameobject;
import malmo.csillagkapu.gameobject.*;

import static malmo.csillagkapu.util.Logger.*;

/**
 * Created by Mosonyi Máté on 2016. 03. 26..
 */
public class Field {
	private LandObject landobject;
	private ItemObject itemobject;
	
	public Field(LandObject _land, ItemObject _item) {
		landobject = _land;
		itemobject = _item;
	}
	
	public boolean stepIn(Colonel col) {
		beginFunction();
		if (itemobject != null) {
			return ret(itemobject.stepIn(col));
		}
		else {
			if (landobject != null) {
				return ret(landobject.stepIn(col));
			}
			else {	
				return ret(true);
			}
		}
	}
	
	public boolean stepOut() {
		if (landobject != null) {
				return ret(landobject.stepOut(col));
			}
			else {	
				return ret(true);
			}
	}
	
	public boolean place(ItemObject _item) {
		beginFunction();
		if (itemobject != null) {
			return ret(itemobject.place(_item));
		}
		else {
			if (landobject != null) {
				return ret(landobject.place(_item));
			}
			else {	
				itemobject = _item;
				return ret(true);
			}
		}
	}
	
	public boolean pick(Colonel col) {
		beginFunction();
		if (itemobject != null) {
			if (itemobject.pick(col)) {
				landobject.pick(col);
				return ret(true);
			}
			return ret(false);
		}
		else {
			return ret(false);
		}
	}
	
	public boolean openPortal(Portal port) {
		beginFunction();
		if (itemobject == null) {
			return ret(landobject.openPortal(port));
		}
	}
	
	public boolean hit(Bullet bul) {
		beginFunction();
		return ret(false);
	}
}
