package views;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import views.Professor.Representation.ProfessorTabPanel;
import views.Student.Representation.StudentTabPanel;
import views.Subject.Representation.SubjectTabPanel;

public class TabbedPane extends JTabbedPane {
	
	private static final long serialVersionUID = -8493573945768543417L;
	
	private ProfessorTabPanel professorTab;
	private StudentTabPanel studentTab;

	public TabbedPane() {
		super();
		professorTab = new ProfessorTabPanel();
		studentTab = new StudentTabPanel();
		this.addTab(StudentTabPanel.tabName, studentTab);
		this.addTab(ProfessorTabPanel.tabName, professorTab);
		this.addTab(SubjectTabPanel.tabName, new SubjectTabPanel());
		this.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 10));
	}
	
	public ProfessorTabPanel getProfessorTab() {
		return this.professorTab;
	}

	public StudentTabPanel getStudentTab() {
		return studentTab;
	}
}