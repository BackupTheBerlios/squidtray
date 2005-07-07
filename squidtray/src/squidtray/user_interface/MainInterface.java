package squidtray.user_interface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;

import squidtray.parser.ConfigParser;
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
		JPanel treePanel = new JPanel(new BorderLayout());
		JPanel txtPanel = new JPanel(new BorderLayout());
		JTabbedPane globalPane = new JTabbedPane();
		globalPane.add(treePanel,"Simple");
		globalPane.add(txtPanel, "Advanced");
		
		//TextPane
		JTextPane txtConfigPane = new JTextPane();
		StyledDocument doc = (StyledDocument)txtConfigPane.getDocument();
		JScrollBar scrollConfigBar = new JScrollBar();
		insertFile(new File("c:\\squid\\etc\\squid.conf"), doc, scrollConfigBar);
		
		txtPanel.add(txtConfigPane,BorderLayout.CENTER);
		txtPanel.add(scrollConfigBar, BorderLayout.EAST);
		
		globalPane.setTabPlacement(JTabbedPane.TOP);
		mainInterface.add(globalPane, BorderLayout.CENTER);
		setContentPane(mainInterface);
		setSize(800,600);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		//Appel de la barre de menus
		setJMenuBar(new MenuBar(stStatus));
		
		//Tree
		JPanel panelTree = new JPanel(new BorderLayout());
		treePanel.add(panelTree,BorderLayout.CENTER);
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
			int i;
			BufferedReader in = new BufferedReader(new FileReader((GetInstance.class.getResource(confFile).getFile())));
			String str;
			while ((str = in.readLine()) != null) {
				if (str != "\n") {
					ConfigParser cParser = new ConfigParser("c:\\squid\\etc\\squid.conf");
					ArrayList resParam = cParser.getParam(str);
					
					if ( resParam.size() == 1) {
						node.add(new DefaultMutableTreeNode(str + " - " + resParam.get(0)));
					} else {
						DefaultMutableTreeNode tmpNode = new DefaultMutableTreeNode(str);
						for (i = 0; i< resParam.size();i++)
						{
							tmpNode.add(new DefaultMutableTreeNode(str + " - " + resParam.get(i)));
						}
						node.add(tmpNode);
					}
				}
			}
		} catch (IOException e) {}
	}
	
	static private void insertFile(File txtFile, StyledDocument doc, JScrollBar scrollBar) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(txtFile));
			String str;
			int i=1;
			
			while ((str = in.readLine()) != null) {
				doc.insertString(doc.getLength(),str+"\n",null);
				i++;
			}
			scrollBar.setMinimum(0);
			scrollBar.setMaximum(i);
		} catch (Exception e) {}
	}
}


