package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	public MenuBar( ) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		file.add(createMenuItem("New","src/gui/images/new.png", KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK), 'N'));
		file.add(createMenuItem("Save","src/gui/images/save.png", KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK), 'S'));
		JMenu open = new JMenu("Open");
		open.setMnemonic('O');
		open.setIcon(new ImageIcon("src/gui/images/open.png"));
		open.add(createMenuItem("Studenti","src/gui/images/studenti.png", KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK), 'I'));
		open.add(createMenuItem("Predmeti","src/gui/images/predmeti.png", KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK), 'P'));
		open.add(createMenuItem("Profesori","src/gui/images/profesori.png", KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.SHIFT_MASK), 'R'));
		open.add(createMenuItem("Katedre","src/gui/images/katedre.png", KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.SHIFT_MASK), 'A'));
		file.add(open);
		file.add(createMenuItem("Close","src/gui/images/close.png",KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK), 'C'));
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic('E');
		edit.add(createMenuItem("Edit","src/gui/images/edit.png",KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK), 'D'));
		edit.add(createMenuItem("Delete","src/gui/images/delete.png",KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK), 'T'));
		JMenu help = new JMenu("Help");
		help.setMnemonic('H');
		help.add(createMenuItem("Help","src/gui/images/help.png",KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK), 'L'));
		help.add(createMenuItem("About","src/gui/images/about.png",KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK), 'B'));
		add(file);
		add(edit);
		add(help);
	}	
	
	private JMenuItem createMenuItem(String label, String imageURL, KeyStroke keyStroke, char mnemonic) {
		
		JMenuItem item = new JMenuItem(label);
		item.setIcon(new ImageIcon(imageURL));
		item.setAccelerator(keyStroke);
		item.setMnemonic(mnemonic);
		return item;
	}
	
	
}
