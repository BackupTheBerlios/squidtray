package squidtray.init;

import javax.swing.JFrame;

import squidtray.user_interface.Splash;

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
        
		//Appel de la fenêtre splash
		JFrame splash = new Splash();
		splash.setVisible(true);
		
        Thread startup = new StartupThread(splash);
        startup.start();
        
        try {
            startup.join();
        } catch (Exception ignore) {
        }

	}
	
}
	

