package views.Student.Representation;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

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
		AbstractTableModelStudent model = new AbstractTableModelStudent();
		this.setModel(model);
		TableRowSorter<AbstractTableModelStudent> rowSorter = new TableRowSorter<>(model);
		rowSorter.setComparator(3, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				double d1 = Double.parseDouble(o1);
				double d2 = Double.parseDouble(o2);
				if (d1 > d2)
					return 1;
				else if (d1 < d2)
					return -1;
				else
					return 0;
			}
			
		});
		rowSorter.setComparator(5, rowSorter.getComparator(3));
		this.setRowSorter(rowSorter);
		this.getTableHeader().setReorderingAllowed(false);
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
		if (studentsTable.getRowCount() != 0)
			this.setRowSelectionInterval(0, 0);
	}
}