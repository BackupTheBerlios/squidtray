package squidtray.user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class ActionAboutOk implements ActionListener {
	private final JDialog dialog;
	
	public ActionAboutOk(final JDialog dialog) {
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent evt) {
		dialog.dispose();
	}

}
