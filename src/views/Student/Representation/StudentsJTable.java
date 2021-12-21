package views.Student.Representation;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import views.Professor.Representation.AbstractTableModelProfessor;
import views.Professor.Representation.ProfessorsJTable;

public class StudentsJTable extends JTable {

	private static final long serialVersionUID = -7484521471348882698L;
	
	private static StudentsJTable studentsTable;

	private StudentsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setBackground(Color.LIGHT_GRAY);
		this.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		this.setModel(new AbstractTableModelStudent());
	}
	
	public static StudentsJTable getInstance() {
		if (studentsTable == null)
			studentsTable = new StudentsJTable();
		return studentsTable;
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.MAGENTA);
		}
		else {
			if (row % 2 == 0)
				c.setBackground(Color.WHITE);
			else
				c.setBackground(Color.LIGHT_GRAY);
		}
		return c;
	}
	
	public void updateView() {
		AbstractTableModelStudent model = (AbstractTableModelStudent) this.getModel();
		model.fireTableDataChanged();
		this.setRowSelectionInterval(0, 0);
	}
}