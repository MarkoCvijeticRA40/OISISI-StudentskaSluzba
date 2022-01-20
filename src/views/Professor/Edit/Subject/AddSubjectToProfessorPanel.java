package views.Professor.Edit.Subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		btnPanel.add(addBtn);
		
		deleteBtn = new JButton("Ukloni predmet");
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
