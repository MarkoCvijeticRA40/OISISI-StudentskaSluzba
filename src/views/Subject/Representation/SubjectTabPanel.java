package views.Subject.Representation;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SubjectTabPanel extends JPanel {

	private static final long serialVersionUID = -2281457415689987833L;
	public static final String tabName = "Predmeti";
	
	public SubjectTabPanel() {
		super();
		this.setLayout(new BorderLayout());
		SubjectsJTable table = new SubjectsJTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
		this.add(scrollPane, BorderLayout.CENTER);
		table.updateView();
	}

}
