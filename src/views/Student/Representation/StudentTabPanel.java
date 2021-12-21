package views.Student.Representation;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentTabPanel extends JPanel{

	private static final long serialVersionUID = -8807834708163724557L;

	public static final String tabName = "Studenti";
	
	private StudentsJTable table;

	public StudentTabPanel() {
		super();
		this.setLayout(new BorderLayout());
		table = StudentsJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));
		this.add(scrollPane, BorderLayout.CENTER);
		table.updateView();
	}
	
	public StudentsJTable getTable() {
		return this.table;
	}	
}