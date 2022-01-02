package views.Student.Edit.Exams.NotPassed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		passedBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddPassedExamDialog.getInstance().init();
			}
			
		});
		btnPanel.add(passedBtn);
		container.add(btnPanel);
		
		container.add(Box.createVerticalStrut(10));
		
		examsTable = ExamsJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(examsTable);
		examsTable.updateView();
		container.add(scrollPane);
		
		this.add(container, BorderLayout.NORTH);
		
		JPanel emptyStatusBar = new JPanel();
		emptyStatusBar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		
		this.add(emptyStatusBar, BorderLayout.SOUTH);
		
	}

}
