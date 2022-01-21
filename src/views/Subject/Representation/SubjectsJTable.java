package views.Subject.Representation;

import java.awt.Color;
import java.awt.Component;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class SubjectsJTable extends JTable {

	private static final long serialVersionUID = 8052273003161493585L;
	private static SubjectsJTable table;

	private SubjectsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setBackground(Color.LIGHT_GRAY);
		this.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		AbstractTableModelSubject model = new AbstractTableModelSubject();
		this.setModel(model);
		
		TableRowSorter<AbstractTableModelSubject> sorter = new TableRowSorter<>(model);
		sorter.setComparator(2, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int n1 = Integer.parseInt(o1);
				int n2 = Integer.parseInt(o2);
				if (n1 > n2)
					return 1;
				else if (n1 < n2)
					return -1;
				else
					return 0;
			}
			
		});
		sorter.setComparator(4, sorter.getComparator(2));
		this.setRowSorter(sorter);
		
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	public static SubjectsJTable getInstance() {
		if (table == null)
			table = new SubjectsJTable();
		return table;
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
		AbstractTableModelSubject model = (AbstractTableModelSubject) this.getModel();
		model.fireTableDataChanged();
		if (this.getRowCount() != 0)
			this.setRowSelectionInterval(0, 0);
	}
}
