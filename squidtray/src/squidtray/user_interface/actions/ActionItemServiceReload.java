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
public class ActionItemServiceReload implements ActionListener {
	private final JLabel statusLabel;
	/**
	 * 
	 */
	public ActionItemServiceReload(JLabel label) {
		this.statusLabel = label;
	}
	
	public void actionPerformed(ActionEvent evt) {
		int i;
		Services.Stop();
		statusLabel.setText("SquidTray is reloading the service");
		for (i=0; i< Services.MAXTIMEOUT; i++) {
			if ((Services.Start())!=Services.FAIL) {
				statusLabel.setText("SquidNT is started");
				break;
			}
		}
	}

}
