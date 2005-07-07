package squidtray.user_interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import squidtray.user_interface.actions.ActionAboutOk;

public class About extends JDialog {

	public About() {
		super();
		
		JPanel aboutPannel = new JPanel(new BorderLayout());
		ImageIcon image = new ImageIcon(getClass().getResource("/squidtray/images/logo.gif"));
		JLabel messageLabel = new JLabel(image, JLabel.CENTER);
		aboutPannel.add(messageLabel,BorderLayout.CENTER);
		
		JPanel buttonPannel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionAboutOk(this));
		buttonPannel.add(buttonOk);
		
		aboutPannel.add(buttonPannel, BorderLayout.SOUTH);
		
		setTitle("About SquidTray");
		setContentPane(aboutPannel);
		setSize(450,250);
		setResizable(false);
		setVisible(true);
		
	}

}
