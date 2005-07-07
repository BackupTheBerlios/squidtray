/*
 * Created on 6 juil. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package squidtray.user_interface.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import squidtray.services.Services;

/**
 * @author Administrateur
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ActionItemServiceStop implements ActionListener {
	
	private final JLabel statusLabel;
	/**
	 * 
	 */
	public ActionItemServiceStop(JLabel label) {
		this.statusLabel = label;
	}

	public void actionPerformed(ActionEvent evt) {
		int i;
		Services.Start();
		statusLabel.setText("SquidTray is stopping the SquidNT service");
		for (i=0; i< Services.MAXTIMEOUT; i++) {
			if ((Services.Stop())!=Services.FAIL) {
				statusLabel.setText("SquidNT is stopped");
				break;
			}
		}
	}
}
