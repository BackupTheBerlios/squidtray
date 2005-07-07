package squidtray.user_interface;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import squidtray.user_interface.actions.ActionItemFileExit;
import squidtray.user_interface.actions.ActionItemHelpAbout;
import squidtray.user_interface.actions.ActionItemServiceReload;
import squidtray.user_interface.actions.ActionItemServiceStart;
import squidtray.user_interface.actions.ActionItemServiceStop;

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
		menuItemServiceStart.addActionListener(new ActionItemServiceStart(stLabel));
		menuService.add(menuItemServiceStart);
		JMenuItem menuItemServiceStop = new JMenuItem("Stop");
		menuItemServiceStop.addActionListener(new ActionItemServiceStop(stLabel));
		menuService.add(menuItemServiceStop);
		JMenuItem menuItemServiceReload = new JMenuItem("Reload");
		menuItemServiceReload.addActionListener(new ActionItemServiceReload(stLabel));
		menuService.add(menuItemServiceReload);
		
		//Description du menu configuration
		JMenu menuConfig = new JMenu("Configuration");
		JMenuItem menuItemConfigReload = new JMenuItem("Reload Config.");
		menuConfig.add(menuItemConfigReload);
		menuItemConfigReload.setEnabled(false);
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
