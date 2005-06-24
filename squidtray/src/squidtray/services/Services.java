/*
 * Created on 24 juin 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.services;

import java.io.InputStream;


/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Services {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int STARTED = 4;
	public static final int STOPPED = 5;
	
	public static int Start() {
		try {
			String command = "NET START SquidNT";
			Process child = Runtime.getRuntime().exec(command);
			if (child.getInputStream().read() == -1) {
				return FAIL;
			}
		} catch (Exception e) {}
		return SUCCESS;
	}
	
	public static int Stop() {
		try {
			String command = "NET STOP SquidNT";
			Process child = Runtime.getRuntime().exec(command);
			if (child.getInputStream().read() == -1) {
				return FAIL;
			}
		} catch (Exception e) {}
		return SUCCESS;
	}
	
	public static int Status() {
		
		try {
			String command = "c:\\squid\\sbin\\squid.exe -n SquidNT -k check";
			Process child = Runtime.getRuntime().exec(command);
	        
			InputStream in = child.getErrorStream();
	        int c;
	        while ((c = in.read()) != -1) {
	            System.out.println(((char)c));
	        }
	        
	        in.close();
		} catch (Exception e){}
		return FAIL;
	}

	public static int Kill() {
		
		return FAIL;
	}
}
