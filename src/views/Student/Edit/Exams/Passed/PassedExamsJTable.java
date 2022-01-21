package views.Student.Edit.Exams.Passed;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PassedExamsJTable extends JTable {

	private static final long serialVersionUID = 3146282931360083814L;
	private static PassedExamsJTable table;
	
	private PassedExamsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setBackground(Color.LIGHT_GRAY);
		this.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		this.setModel(new AbstractTableModelPassedExams());
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	public static PassedExamsJTable getInstance() {
		if (table == null)
			table = new PassedExamsJTable();
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
		AbstractTableModelPassedExams model = (AbstractTableModelPassedExams) this.getModel();
		model.fireTableDataChanged();
		this.setRowSelectionInterval(0, 0);
	}

}
