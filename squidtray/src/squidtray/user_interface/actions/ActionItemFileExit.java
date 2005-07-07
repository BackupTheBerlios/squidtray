package squidtray.user_interface.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ActionItemFileExit implements ActionListener {
	private final JLabel statusLabel;
	
	public ActionItemFileExit(final JLabel label) {
		this.statusLabel = label;
	}

	public void actionPerformed(ActionEvent evt) {
		//statusLabel.setText("Coucou");
		System.exit(0);
	}

}
