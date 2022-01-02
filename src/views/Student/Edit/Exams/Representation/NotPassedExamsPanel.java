package views.Student.Edit.Exams.Representation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class NotPassedExamsPanel extends JPanel {

	private static final long serialVersionUID = 5644133560248498219L;
	
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton passedBtn;
	private ExamsJTable examsTable;
	
	public NotPassedExamsPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel container = new JPanel();
		BoxLayout boxLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(boxLayout);
		container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addBtn = new JButton("Dodaj");
		btnPanel.add(addBtn);
		deleteBtn = new JButton("Obrisi");
		btnPanel.add(deleteBtn);
		passedBtn = new JButton("Polaganje");
		btnPanel.add(passedBtn);
		container.add(btnPanel);
		
		container.add(Box.createVerticalStrut(10));
		
		examsTable = new ExamsJTable();
		JScrollPane scrollPane = new JScrollPane(examsTable);
		container.add(scrollPane);
		
		this.add(container, BorderLayout.NORTH);
		
		JPanel emptyStatusBar = new JPanel();
		emptyStatusBar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		
		this.add(emptyStatusBar, BorderLayout.SOUTH);
		
	}

}
