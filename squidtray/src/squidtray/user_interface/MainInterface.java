package squidtray.user_interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import squidtray.parser.Parser;
import sun.security.jca.GetInstance;

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
		DefaultMutableTreeNode aclConf = new DefaultMutableTreeNode("ACL");
		
		root.add(basicConf);
		root.add(aclConf);
		root.add(adConf);
		setTree(basicConf,"/squidtray/config/basic.conf");
		setTree(adConf,"/squidtray/config/advanced.conf");
		setTree(aclConf,"/squidtray/config/acl.conf");
		JTree tree = new JTree(root);
		
		panelTree.add(tree, BorderLayout.CENTER);
		
		setVisible(true);
		
	
	}
	
	static public JLabel getLabelStatus () {
		
		return label;
	}

	static private void setTree (DefaultMutableTreeNode node, String confFile) {
		try {
			BufferedReader in = new BufferedReader(new FileReader((GetInstance.class.getResource(confFile).getFile())));
			String str;
			while ((str = in.readLine()) != null) {
				if (str != "\n") {
					Parser config_file = new Parser();
					node.add(new DefaultMutableTreeNode(str + " - " + config_file.getParam(str)));
				}
			}
		} catch (IOException e) {}
	}
}
