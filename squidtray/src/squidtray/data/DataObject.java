/*
 * Created on 15 juil. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.data;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DataObject {
	private String keyWord;
	private List argWord = new ArrayList(1);
	private String commWord;
	/**
	 * 
	 */
	public DataObject(String keyWord, String argWord, String commWord) {
		this.keyWord = keyWord;
		this.argWord = makeArgWord(argWord);
		this.commWord = commWord;
	}
	
	public DataObject(String keyWord, String argWord) {
		this.keyWord = keyWord;
		this.argWord = makeArgWord(argWord);
		this.commWord = null;
	}
	
	public DataObject(String keyWord) {
		this.keyWord = keyWord;
		this.argWord = null;
		this.commWord = null;
	}
	
	public DataObject(String commWord, int flag) {
		this.keyWord = null;
		this.argWord = null;
		this.commWord = commWord;
	}
	
	public DataObject() {
		super();
		keyWord = null;
		argWord = null;
		commWord = null;
	}
	
	public String getKeyWord () {
		return keyWord;
	}
	
	public List getArgWord () {
		
		return argWord;
	}
	
	public String getCommWord () {
		
		return commWord;
	}
	
	public List makeArgWord ( String arg ) {
		List argWord = new ArrayList(1);
		try {
			Pattern motif;
			motif = Pattern.compile("\\s");
			if (motif.matcher(arg).find()) {
				String[] items = motif.split(arg);
				for (int i=0;i<items.length;i++) {
					argWord.add(new String(items[i]));
				}
				return argWord;
			} else if (arg != "") {
				argWord.add(new String(arg));
				return argWord;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			return null;
			
	}
}
