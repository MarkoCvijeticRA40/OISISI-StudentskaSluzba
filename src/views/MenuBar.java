package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controllers.ProfessorController;
import controllers.StudentController;
import controllers.SubjectController;
import views.Professor.Add.AddProfessorDialog;
import views.Professor.Edit.EditProfessorDialog;
import views.Student.Add.AddStudentDialog;
import views.Student.Edit.EditStudentDialog;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

	public MenuBar( ) {
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		
		JMenuItem newEntity = createMenuItem("New","src/views/images/new.png", KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK), 'N');
		newEntity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAppropriateWindow("add");
			}
			
		});
		file.add(newEntity);
		
		file.add(createMenuItem("Save","src/views/images/save.png", KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK), 'S'));
		
		JMenu open = new JMenu("Open");
		open.setMnemonic('O');
		open.setIcon(new ImageIcon("src/views/images/open.png"));
		JMenuItem openStudent = createMenuItem("Studenti","src/views/images/studenti.png", KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK), 'I');
		openStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().getTabbedPane().setSelectedIndex(0);
			}
			
		});
		open.add(openStudent);
		JMenuItem openPredmeti = createMenuItem("Profesori","src/views/images/profesori.png", KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK), 'P');
		openPredmeti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().getTabbedPane().setSelectedIndex(1);
			}
			
		});
		open.add(openPredmeti);
		JMenuItem openProfessor = createMenuItem("Predmeti","src/views/images/predmeti.png", KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK), 'R');
		openProfessor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.getInstance().getTabbedPane().setSelectedIndex(2);
			}
			
		});
		open.add(openProfessor);
		open.add(createMenuItem("Katedre","src/views/images/katedre.png", KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK), 'A'));
		file.add(open);
		file.add(createMenuItem("Close","src/views/images/close.png",KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK), 'C'));
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic('E');
		JMenuItem editEntity = createMenuItem("Edit","src/views/images/edit.png",KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK), 'D');
		editEntity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAppropriateWindow("edit");
			}
			
		});
		edit.add(editEntity);
		JMenuItem deleteEntity = createMenuItem("Delete","src/views/images/delete.png",KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK), 'T');
		deleteEntity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAppropriateWindow("delete");
			}
			
		});
		edit.add(deleteEntity);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic('H');
		help.add(createMenuItem("Help","src/views/images/help.png",KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK), 'L'));
		help.add(createMenuItem("About","src/views/images/about.png",KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK), 'B'));
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
	
	private void showAppropriateWindow(String window) {
		int selectedTab = MainFrame.getInstance().getTabbedPane().getSelectedIndex();
		switch(selectedTab) {
			case 0:
				switch(window) {
				case "add": 
					AddStudentDialog.getInstance().init();
					break;
				case "edit": 
					EditStudentDialog.getInstance().init();
					break;
				case "delete":
					int result = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurno da zelite da obriste studenta", 
							"Brisanje studenta", 
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION)
						StudentController.getInstance().delete();
					break;
			}
				break;
			case 1:
				switch(window) {
				case "add": 
					AddProfessorDialog.getInstance().init();
					break;
				case "edit": 
					EditProfessorDialog.getInstance().init();
					break;
				case "delete":
					int result = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurno da zelite da obriste profesora", 
							"Brisanje profesora", 
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION)
						ProfessorController.getInstance().delete();
					break;
			}
				break;
			case 2:
				switch(window) {
				case "add": 
					break;
				case "edit": 
					break;
				case "delete":
					int result = JOptionPane.showConfirmDialog(null,
							"Da li ste sigurni da zelite da obriste predmet", 
							"Brisanje predmeta", 
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION)
						SubjectController.getInstance().delete();
					break;
			}
				break;
		}
	}	
}
