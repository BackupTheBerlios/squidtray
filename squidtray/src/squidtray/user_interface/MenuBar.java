package squidtray.user_interface;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	public MenuBar(final JLabel stLabel) {
		super();
		
		//Description du menu Fichier
		JMenu menuFile = new JMenu("File");
		JMenuItem menuItemFileExit = new JMenuItem("Exit");
		menuItemFileExit.addActionListener(new ActionItemFileExit(stLabel));
		menuFile.add(menuItemFileExit);
		
		//Description du menu Service
		JMenu menuService = new JMenu("Service");
		JMenuItem menuItemServiceStart = new JMenuItem("Start");
		menuService.add(menuItemServiceStart);
		JMenuItem menuItemServiceStop = new JMenuItem("Stop");
		menuService.add(menuItemServiceStop);
		JMenuItem menuItemServiceReload = new JMenuItem("Reload");
		menuService.add(menuItemServiceReload);
		
		//Description du menu configuration
		JMenu menuConfig = new JMenu("Configuration");
		JMenuItem menuItemConfigReload = new JMenuItem("Reload Config.");
		menuConfig.add(menuItemConfigReload);
		
		//Description du menu Aide
		JMenu menuHelp = new JMenu("Help");
		JMenuItem menuItemHelpAbout = new JMenuItem("About SquidTray");
		menuItemHelpAbout.addActionListener(new ActionItemHelpAbout());
		menuHelp.add(menuItemHelpAbout);
		
		
		//Inscription des menus
		add(menuFile);
		add(menuService);
		add(menuConfig);
		add(menuHelp);
	}
	
}
