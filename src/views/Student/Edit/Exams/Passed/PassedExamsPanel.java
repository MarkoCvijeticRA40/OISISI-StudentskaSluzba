package views.Student.Edit.Exams.Passed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controllers.StudentController;
import models.ExamGrade;
import models.Student;

public class PassedExamsPanel extends JPanel {

	private static final long serialVersionUID = -8111997311388142975L;
	
	private PassedExamsJTable examsTable;
	private JLabel avgGrade;
	private JLabel numOfESBP;
	
	public PassedExamsPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel container = new JPanel();
		BoxLayout boxLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(boxLayout);
		container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JButton removeBtn = new JButton("Ponisti ocenu");
		removeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String examId = (String) examsTable.getValueAt(examsTable.getSelectedRow(), 0);
				if (examId.isEmpty())
					return;
				int result = JOptionPane.showConfirmDialog(null,
						"Da li ste sigurni da zelite da ponistite ocenu?", 
						"Ponistavanje ocene", 
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					StudentController.getInstance().deletePassedExam(examId);
				}
			}
			
		});
		btnPanel.add(removeBtn);
		container.add(btnPanel);
		
		container.add(Box.createVerticalStrut(10));
		
		examsTable = PassedExamsJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(examsTable);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		examsTable.updateView();
		container.add(scrollPane);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		
		avgGrade = new JLabel();
		labelPanel.add(avgGrade);
		
		labelPanel.add(Box.createVerticalStrut(5));
		
		numOfESBP = new JLabel();
		labelPanel.add(numOfESBP);
		
		labelPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		container.add(labelPanel);
		
		this.add(container, BorderLayout.CENTER);
		
		JPanel emptyStatusBar = new JPanel();
		emptyStatusBar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		
		this.add(emptyStatusBar, BorderLayout.SOUTH);
		
	}
	
	public void updateView() {
		this.examsTable.updateView();
		this.avgGrade.setText("Prosecna ocena: " + String.valueOf(this.averageGrade()));
		this.numOfESBP.setText("Ukupno ESBP: " + String.valueOf(this.numOfESBP()));
	}
	
	private double averageGrade() {
		double sum = 0;
		Student student = StudentController.getInstance().getSelectedStudent();
		for (ExamGrade grade : student.getPassedExams()) {
			sum += grade.getMark();
		}
		if(sum != 0)
			return sum / student.getPassedExams().size();
		return 0;
	}
	
	private int numOfESBP() {
		int sum = 0;
		Student student = StudentController.getInstance().getSelectedStudent();
		for (ExamGrade grade : student.getPassedExams()) {
			sum += grade.getSubject().getEspb();
		}
		return sum;
	}

}
