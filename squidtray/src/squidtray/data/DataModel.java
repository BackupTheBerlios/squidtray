/*
 * Created on 15 juil. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataModel implements Iterable {
	private final List dataContainer = new ArrayList(1);

	public DataModel() {
		super();
	}
	
	public void addObject (DataObject object) {
		dataContainer.add(object);
	}
	
	public DataObject getObject (int i) {
		if ( i > 0 && i < dataContainer.size()) {
			return (DataObject) dataContainer.get(i);
		}
		return null;
	}
	
	public int getSize () {
		return dataContainer.size();
	}
	
	public void printObject (int i) {
		DataObject object = (DataObject) dataContainer.get(i);
		System.out.println();
		System.out.println("--- Object : " + i + " ---");
		System.out.println(" key_word  : " + object.getKeyWord());
		System.out.println(" arg_word  : " + object.getArgWord());
		System.out.println(" comm_word : " + object.getCommWord());
		System.out.println("--------------------------");
	}
	public void removeObjet (int index) {
		// TODO routine de suppression d'un objet
	}

	public Iterator iterator() {
		return dataContainer.iterator();
	}
}
