package views.Professor.Edit.Subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controllers.ProfessorController;

public class AddSubjectToProfessorPanel extends JPanel {

	private static final long serialVersionUID = -8907080320781724406L;
	
	private JButton addBtn;
	private JButton deleteBtn;
	
	public AddSubjectToProfessorPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel container = new JPanel();
		BoxLayout boxLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(boxLayout);
		container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addBtn = new JButton("Dodaj predmet");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListSubjectsDialog.getInstance().init();
			}
			
		});
		btnPanel.add(addBtn);
		
		deleteBtn = new JButton("Ukloni predmet");
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> selectedIds = ProfessorSubjectsJTable.getInstance().getSelectedIds();
				if (selectedIds.size() == 0)
					return;
				int result = JOptionPane.showConfirmDialog(null,
						"Da li ste sigurni?", 
						"Ukloni predmet", 
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					ProfessorController.getInstance().deleteSubjects(selectedIds);
				}
			}
			
		});
		btnPanel.add(deleteBtn);
		
		container.add(btnPanel);
		
		JScrollPane scrollPane = new JScrollPane(ProfessorSubjectsJTable.getInstance());
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		ProfessorSubjectsJTable.getInstance().updateView();
		
		container.add(scrollPane);
		
		this.add(container, BorderLayout.NORTH);
		
		JPanel emptyStatusBar = new JPanel();
		emptyStatusBar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		
		this.add(emptyStatusBar, BorderLayout.SOUTH);
		
	}

}
