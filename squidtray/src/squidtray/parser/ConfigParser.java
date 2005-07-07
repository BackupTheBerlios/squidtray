/*
 * Created on 6 juil. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConfigParser {
	static private File configFile;
	
	public ConfigParser(String src) {
		super();
		configFile = new File(src);
		
		// TODO Auto-generated constructor stub
	}
	
	static void copy(File src, File dst) throws IOException {
		/* copy()
		 * Copie le fichier source (src) vers le fichier destination (dst)
		 * Si le fichier n'existe pas il est créé.
		 */
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);
		//Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	} //Fin copy()
	
	public static ArrayList getParam(String arg) {
		/* getParam()
		 * Retourne un tableau d'objet. Chaque ligne represente une occurance.
		 */
		ArrayList returnArray = new ArrayList(1);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(configFile));
			String str;
			while ((str = in.readLine()) != null) {
				if ((str.indexOf(arg)) == 0) {
					str = str.replaceFirst(arg + " ","");
					if ( findCom(str) != null ) {
						str = str.replaceAll(findCom(str),"");
					}
					returnArray.add(str);
				}
			}
			in.close();
			return returnArray;
			
		}  catch (IOException e) {}
		return null;
	} //Fin getParam()
	
	private static String findCom(String arg) {
		String str = null;
		int sizeOfString;
		str = right(arg,arg.indexOf("#"));
		return str;
	}
	
	private static String right(String arg, int index) {
		char[] inArray;
		String str = "";
		int i;
		int sizeOfStr = arg.length();
		inArray = arg.toCharArray();
		if ( index <=0 || index >= sizeOfStr) {
			return null;
		}
		for (i=index;i<sizeOfStr;i++){
			str = str + inArray[i];
		}
		return str;
	}
	
	private static String left(String arg , int index) {
		char[] inArray;
		String str = "";
		int i;
		int sizeOfStr = arg.length();
		inArray = arg.toCharArray();
		if ( index <= 0 || index >= sizeOfStr) {
			return null;
		}
		for (i=0;i<index;i++){
			str = str + inArray[i];
		}
		return str;
	}
}
