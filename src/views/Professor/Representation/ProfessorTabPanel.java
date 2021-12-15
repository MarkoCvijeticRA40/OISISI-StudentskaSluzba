package views.Professor.Representation;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfessorTabPanel extends JPanel {
	
	private static final long serialVersionUID = 1756527412797373518L;
	public static final String tabName = "Profesori";
	
	private ProfessorsJTable table;

	public ProfessorTabPanel() {
		super();
		this.setLayout(new BorderLayout());
		table = ProfessorsJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
		this.add(scrollPane, BorderLayout.CENTER);
		table.updateView();
	}
	
	public ProfessorsJTable getTable() {
		return this.table;
	}
}
