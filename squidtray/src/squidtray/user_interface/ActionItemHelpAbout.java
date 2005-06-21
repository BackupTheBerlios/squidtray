package squidtray.user_interface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class ActionItemHelpAbout implements ActionListener {
	
	public void actionPerformed(ActionEvent evt) {
		JDialog frmAbout = new About();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    // Determine the new location of the window
	    int w = frmAbout.getSize().width;
	    int h = frmAbout.getSize().height;
	    int x = (dim.width-w)/2;
	    int y = (dim.height-h)/2;
	    
	    // Move the window
	    frmAbout.setLocation(x, y);
	}

}
