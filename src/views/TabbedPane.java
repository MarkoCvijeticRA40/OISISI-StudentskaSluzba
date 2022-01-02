package views;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import views.Professor.Representation.ProfessorTabPanel;
import views.Student.Representation.StudentTabPanel;
import views.Subject.Representation.SubjectTabPanel;

public class TabbedPane extends JTabbedPane {
	
	private static final long serialVersionUID = -8493573945768543417L;
	
	private ProfessorTabPanel professorTab;
	private StudentTabPanel studentTab;
	private SubjectTabPanel subjectTab;

	public TabbedPane() {
		super();
		professorTab = new ProfessorTabPanel();
		studentTab = new StudentTabPanel();
		subjectTab = new SubjectTabPanel();
		this.addTab(StudentTabPanel.tabName, studentTab);
		this.addTab(ProfessorTabPanel.tabName, professorTab);
		this.addTab(SubjectTabPanel.tabName, subjectTab);
		this.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 10));
		
		this.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int selectedTab = getSelectedIndex();
				switch (selectedTab) {
					case 0:
						MainFrame.getInstance().getStatusBar().setSelectedTabLabel("Studenti");
						break;
					case 1:
						MainFrame.getInstance().getStatusBar().setSelectedTabLabel("Profesori");
						break;
					case 2:
						MainFrame.getInstance().getStatusBar().setSelectedTabLabel("Predmeti");
						break;
				}
			}
			
		});
		this.setSelectedIndex(0);
	}
}