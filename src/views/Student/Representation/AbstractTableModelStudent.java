package views.Student.Representation;

import javax.swing.table.AbstractTableModel;

import persistence.StudentDatabase;

public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = -3080495657137729787L;

	@Override
	public int getRowCount() {
		return 40;
	}

	@Override
	public int getColumnCount() {
		return StudentDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return StudentDatabase.getInstance().getColumnName(columnIndex);
	}
}
