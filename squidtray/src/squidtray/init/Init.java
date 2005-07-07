package squidtray.init;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import squidtray.user_interface.MainInterface;

import com.jgoodies.looks.LookUtils;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyKrupp;

public class Init {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		int i;
		try {
			LookUtils.setLookAndTheme(new PlasticXPLookAndFeel(), new SkyKrupp());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Appel de la fenêtre principale.
		JFrame frmMain = new MainInterface();
		frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		((MainInterface) frmMain).getLabelStatus().setText("SquidTray is starting the SquidNT service");
//		Services.Stop();
//		
//		for (i=0; i< Services.MAXTIMEOUT; i++) {
//			if ((Services.Start())!=Services.FAIL) {
//				((MainInterface) frmMain).getLabelStatus().setText("SquidNT is started");
//				break;
//			}
//		}
//		
//		//On fabrique le nouveau parseur.
		
	}
}
