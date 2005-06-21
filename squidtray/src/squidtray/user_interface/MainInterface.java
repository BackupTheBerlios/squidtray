package squidtray.user_interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainInterface extends JFrame {

	public MainInterface() {
		super("Squid Tray");
		
		//Définition de l'interface principale.
		JPanel mainInterface = new JPanel(new BorderLayout());
		
		//Défintion de la barre de status
		JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel stStatus = new JLabel("Done.");
		statusBar.add(stStatus);
		
		//Ajout de la barre de status dans le paneau principal.
		mainInterface.add(statusBar, BorderLayout.SOUTH);
		
		setContentPane(mainInterface);
		setSize(800,600);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		//Appel de la barre de menus
		setJMenuBar(new MenuBar(stStatus));
		
		setVisible(true);
		
	
	}

}
