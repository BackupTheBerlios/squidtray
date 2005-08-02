/*
 * Created on 2 août 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.user_interface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Splash extends JFrame {

	/**
	 * 
	 */
	public Splash() {
		super();
        final JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/squidtray/images/splash.png")));
        icon.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        icon.setDoubleBuffered(false);

        setUndecorated(true);
        getContentPane().add(icon, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);

	}

}
