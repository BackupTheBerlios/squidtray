package squidtray.init;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import squidtray.messages.DialogBoxs;
import squidtray.user_interface.MainInterface;

import com.jgoodies.looks.LookUtils;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.plastic.theme.SkyKrupp;

public class Init {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		try {
			LookUtils.setLookAndTheme(new PlasticXPLookAndFeel(), new SkyKrupp());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Appel de la fenêtre principale.
		JFrame frmMain = new MainInterface();
		frmMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		System.out.println( DialogBoxs.MsgBox("Un message","Un titre",3));
		
	}

}
