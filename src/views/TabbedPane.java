package views;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import views.Professor.Representation.ProfessorTabPanel;
import views.Subject.Representation.SubjectTabPanel;

public class TabbedPane extends JTabbedPane {
	
	private static final long serialVersionUID = -8493573945768543417L;

	public TabbedPane() {
		super();
		this.addTab(ProfessorTabPanel.tabName, new ProfessorTabPanel());
		this.addTab(SubjectTabPanel.tabName, new SubjectTabPanel());
		this.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 10));
	}
}
