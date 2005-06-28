/*
 * Created on 27 juin 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Parser {
	public static final String CONFIG_FILE = "c:\\squid\\etc\\squid.conf";
	public static final String SAVE_FILE = "c:\\squid\\etc\\squid.bak";
	/**
	 * Ouvre un fichier et met le pointeur au debut du fichier.
	 */
	public Parser() {
		super();
		// TODO Auto-generated constructor stub
		File confFile = new File(CONFIG_FILE);
		File savFile = new File(SAVE_FILE);
		try {
			savFile.createNewFile();
		} catch(IOException e) {}
		
		//On copie le fichier
		try {
			copy(confFile, savFile);
		} catch (IOException e) {}
	}

	
	// Copies src file to dst file.
	// If the dst file does not exist, it is created
	static void copy(File src, File dst) throws IOException {
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
	}
	
	
	public static String getParam(String arg) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(CONFIG_FILE));
			String str;
			while ((str = in.readLine()) != null) {
				if ((str.indexOf(arg)) == 0) {
					str = str.replaceFirst(arg + " ","");
					return str;
				}
			}
			in.close();
		}  catch (IOException e) {}
		return null;
	}

	public static int setParam(String arg, String value) {
		//On créer un fichier temporaire
		int flagOk = 0;
		try {
			File temp = File.createTempFile("tempconf",".conf");
			temp.deleteOnExit();
			BufferedWriter out = new BufferedWriter(new FileWriter(temp));
			BufferedReader in = new BufferedReader(new FileReader(CONFIG_FILE));
			String str;
			while ((str = in.readLine()) != null) {
				if ((str.indexOf(arg)) == 0) {
					str = arg + " " + value;
					flagOk = 1;
				}
				str = str + "\n";
				out.write(str);
			}
			out.close();
			
			//On copie maintenant l'ensemble du fichier temp dans le fichier de configuration
			copy(temp,new File(CONFIG_FILE));
			temp.delete();
			return flagOk;
		} catch (IOException e) { 
			return -1;
		}

	}
	
	public static int createParam(String arg, String value) {
		try {
			File temp = File.createTempFile("tempconf",".conf");
			temp.deleteOnExit();
			BufferedWriter out = new BufferedWriter(new FileWriter(temp));
			BufferedReader in = new BufferedReader(new FileReader(CONFIG_FILE));
			String str;
			while ((str = in.readLine()) != null) {
				if (str.indexOf(arg) == 0) {
					return 0;
				}
				str = str + "\n";
				out.write(str);
			}
			out.write(arg + " " + value + "\n");
			out.close();
			
			//On copie maintenant l'ensemble du fichier temp dans le fichier de configuration
			copy(temp,new File(CONFIG_FILE));
			temp.delete();
			return 1;
		} catch (IOException e) { 
			return -1;
		}
	}
}