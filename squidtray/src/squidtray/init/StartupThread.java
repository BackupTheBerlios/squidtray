/*
 * Created on 2 août 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.init;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import squidtray.data.DataModel;
import squidtray.parser.RegulParser;
import squidtray.services.Services;
import squidtray.user_interface.MainInterface;

/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StartupThread  extends Thread {
	private JFrame splash;
	/**
	 * 
	 */
	public StartupThread(JFrame splashFrame) {
		super();
		// TODO Auto-generated constructor stub
		splash = splashFrame;
	}

    public void run() {
    	int i;
		
    	DataModel squidDataModel = new DataModel();
		RegulParser rParser = new RegulParser("c:\\squid\\etc\\squid.conf",squidDataModel);
		rParser.parseFile();
		
		//Appel de la fenêtre principale.
		JFrame frmMain = new MainInterface(squidDataModel);
		frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		((MainInterface) frmMain).getLabelStatus().setText("SquidTray is starting the SquidNT service");
		splash.dispose();
		Services.Stop();
		
		for (i=0; i< Services.MAXTIMEOUT; i++) {
			if ((Services.Start())!=Services.FAIL) {
				((MainInterface) frmMain).getLabelStatus().setText("SquidNT is started");
				break;
			}
		}
		
    }
    
}

