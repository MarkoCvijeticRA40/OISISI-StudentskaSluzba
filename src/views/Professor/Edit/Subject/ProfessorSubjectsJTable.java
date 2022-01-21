package views.Professor.Edit.Subject;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ProfessorSubjectsJTable extends JTable {

	private static final long serialVersionUID = -5437146108378716077L;
	private static ProfessorSubjectsJTable table;
	
	private ProfessorSubjectsJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(false);
		this.getTableHeader().setBackground(Color.LIGHT_GRAY);
		this.getTableHeader().setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		this.setModel(new AbstractTableModelProfessorSubjects());
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	public static ProfessorSubjectsJTable getInstance() {
		if (table == null)
			table = new ProfessorSubjectsJTable();
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
		AbstractTableModelProfessorSubjects model = (AbstractTableModelProfessorSubjects) table.getModel();
		model.fireTableDataChanged();
		this.setRowSelectionInterval(0, 0);
	}
	
	public List<String> getSelectedIds() {
		List<String> selectedIds = new ArrayList<>();
		for (int selectedRow : getInstance().getSelectedRows()) {
			String value = (String) getInstance().getValueAt(selectedRow, 0);
			if (value.isEmpty())
				continue;
			selectedIds.add(value);
		}
		return selectedIds;
	}

}
