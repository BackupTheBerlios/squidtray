package squidtray.user_interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultMutableTreeNode;

import squidtray.data.DataModel;
import squidtray.data.DataObject;

public class MainInterface extends JFrame {

	private static JLabel label;
	
	public MainInterface(DataModel dataModel) {
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
		JScrollPane scrollConfigPane = new JScrollPane(txtConfigPane);
		scrollConfigPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		StyledDocument doc = (StyledDocument)txtConfigPane.getDocument();
		
		//Création des styles
		Style styleStd = doc.addStyle("styleStd",null);
		StyleConstants.setFontSize(styleStd, 12);

		Style styleKeyword = doc.addStyle("styleKeyword",styleStd);
		StyleConstants.setBold(styleKeyword,true);
		StyleConstants.setForeground(styleKeyword, new Color(150,15,15));
		
		Style styleArgword1 = doc.addStyle("styleArgword1", styleStd);
		StyleConstants.setForeground(styleArgword1,new Color(15,20,150));
		
		Style styleArgword2 = doc.addStyle("styleArgword2", styleStd);
		StyleConstants.setForeground(styleArgword2,new Color(115,120,190));
		
		Style styleCommword = doc.addStyle("styleCommword", styleStd);
		StyleConstants.setForeground(styleCommword, new Color(40,130,130));
		StyleConstants.setItalic(styleCommword, true);
		
		//Insertion du texte
		Iterator iteratorDataModel = dataModel.iterator();
		Iterator iteratorArgList = null;
		String argStr;
		while (iteratorDataModel.hasNext()) {
			try {
			DataObject object = (DataObject)iteratorDataModel.next();
//			if ( object.getKeyWord()!= null && object.getKeyWord().trim().length() != 0) {
			doc.insertString(doc.getLength(),object.getKeyWord(),styleKeyword);
			doc.insertString(doc.getLength()," ",null);
			if (object.getArgWord() != null) {
				iteratorArgList = object.getArgWord().iterator();
				int flagColor = 1;
				while (iteratorArgList.hasNext()) {
					argStr = (String)iteratorArgList.next();
					if (flagColor == 1) {
						doc.insertString(doc.getLength(),argStr + " ",styleArgword1);
						flagColor = 0;
					} else {
						doc.insertString(doc.getLength(),argStr + " ",styleArgword2);
						flagColor = 1;
					}
					
				}
			}
			doc.insertString(doc.getLength(),object.getCommWord(),styleCommword);
			doc.insertString(doc.getLength(),"\n",null);
//			}
			} catch (Exception e) {
				System.out.println(e.getMessage());	
			}
		}
		
		
		txtPanel.add(scrollConfigPane,BorderLayout.CENTER);
		
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

		JTree tree = new JTree(root);
		
		panelTree.add(tree, BorderLayout.CENTER);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/squidtray/images/icon.png"));
		setIconImage(icon);		
		setVisible(true);

		
	
	}
	
	static public JLabel getLabelStatus () {
		
		return label;
	}

	static private void setTree (DefaultMutableTreeNode node, String confFile) {
	}
	
	static private void insertFile(File txtFile, StyledDocument doc) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(txtFile));
			String str;
			
			Style styleStd = doc.addStyle("styleStd", null);
			StyleConstants.setFontSize(styleStd, 12);
			
			while ((str = in.readLine()) != null) {
					doc.insertString(doc.getLength(),str+"\n",styleStd);
			}
		} catch (Exception e) {}
	}
	
}


