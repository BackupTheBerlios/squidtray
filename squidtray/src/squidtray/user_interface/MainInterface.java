package squidtray.user_interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainInterface extends JFrame {

	private static JLabel label;
	
	public MainInterface() {
		super("Squid Tray");
		
		//Définition de l'interface principale.
		JPanel mainInterface = new JPanel(new BorderLayout());
		
		//Défintion de la barre de status
		JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel stStatus = new JLabel("SquidTray starts the SquidNT service...");
		statusBar.add(stStatus);
		label = stStatus;
		//Ajout de la barre de status dans le paneau principal.
		mainInterface.add(statusBar, BorderLayout.SOUTH);
		
		setContentPane(mainInterface);
		setSize(800,600);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		//Appel de la barre de menus
		setJMenuBar(new MenuBar(stStatus));
		
		//Tree
		JPanel panelTree = new JPanel(new BorderLayout());
		mainInterface.add(panelTree,BorderLayout.CENTER);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("SquidTray");
		DefaultMutableTreeNode basicConf = new DefaultMutableTreeNode("Basic Config");
		DefaultMutableTreeNode adConf = new DefaultMutableTreeNode("Advanced Config");
		root.add(basicConf);
		basicConf.add(new DefaultMutableTreeNode("http_port"));
		root.add(adConf);
		adConf.add(new DefaultMutableTreeNode("no_cache"));
		JTree tree = new JTree(root);
		
		panelTree.add(tree, BorderLayout.WEST);
		setVisible(true);
		
	
	}
	
	static public JLabel getLabelStatus () {
		
		return label;
	}

}
