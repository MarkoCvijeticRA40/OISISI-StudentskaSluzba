package views.GlavniProzor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	public MenuBar( ) {
		JMenu file = new JMenu("File");
		file.add(new JMenuItem("New"));
		file.add(new JMenuItem("Save"));
		file.add(new JMenuItem("Open"));
		file.add(new JMenuItem("Close"));
		JMenu edit = new JMenu("Edit");
		edit.add(new JMenuItem("Edit"));
		edit.add(new JMenuItem("Delete"));
		JMenu help = new JMenu("Help");
		help.add(new JMenuItem("Help"));
		help.add(new JMenuItem("About"));
		add(file);
		add(edit);
		add(help);
	}	
}
