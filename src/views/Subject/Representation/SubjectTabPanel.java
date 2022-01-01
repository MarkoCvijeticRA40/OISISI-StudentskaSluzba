package views.Subject.Representation;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SubjectTabPanel extends JPanel {

	private static final long serialVersionUID = -2281457415689987833L;
	public static final String tabName = "Predmeti";
	
	private SubjectsJTable subjectTable;
	
	public SubjectTabPanel() {
		super();
		this.setLayout(new BorderLayout());
		subjectTable = new SubjectsJTable();
		JScrollPane scrollPane = new JScrollPane(subjectTable);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
		this.add(scrollPane, BorderLayout.CENTER);
		subjectTable.updateView();
	}
	
	public SubjectsJTable getTable() {
		return subjectTable;
	}

}
