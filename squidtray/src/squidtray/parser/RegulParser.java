/*
 * Created on 15 juil. 2005
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import squidtray.data.DataModel;
import squidtray.data.DataObject;

/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RegulParser {
	private File configFile;
	private DataModel squidDataModel;
	
	public RegulParser(String src,DataModel dataModel) {
		super();
		configFile = new File(src);
		squidDataModel = dataModel;
	}
	
	public void copy(File src, File dst) throws IOException {
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
	
	public void parseFile() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(configFile));
			String str;
			Pattern motif;
			Matcher match;
			while ((str = in.readLine()) != null) {
				motif = Pattern.compile("(\\w*)\\s(.*)\\s(#.*)");
				match = motif.matcher(str);
				if ( match.matches())
				{
					squidDataModel.addObject(
							new DataObject(
									match.group(1),
									match.group(2),
									match.group(3))
									);
				} else {
					motif = motif.compile("(\\w*)\\s(.*)");
					match = motif.matcher(str);
					if ( match.matches())
					{
						squidDataModel.addObject(
								new DataObject(
										match.group(1),
										match.group(2))
										);
					} else {
						motif= motif.compile("(\\w*)");
						match = motif.matcher(str);
						if ( match.matches()) {
							squidDataModel.addObject(
									new DataObject(match.group(1))
									);
						} else {
							motif = motif.compile("(#.*)");
							match = motif.matcher(str);
							if ( match.matches()) {
								squidDataModel.addObject(
										new DataObject(match.group(1),1)
										);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("il y a une erreur.");
			System.out.println(e.getMessage());
		}
	}
}
