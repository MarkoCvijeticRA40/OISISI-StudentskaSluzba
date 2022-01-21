package views.Student.Representation;

import javax.swing.table.AbstractTableModel;

import persistence.Database;

public class AbstractTableModelStudent extends AbstractTableModel {

	private static final long serialVersionUID = -3080495657137729787L;

	@Override
	public int getRowCount() {
		return Database.getInstance().getStudentDatabase().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return Database.getInstance().getStudentDatabase().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return Database.getInstance().getStudentDatabase().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return Database.getInstance().getStudentDatabase().getColumnName(columnIndex);
	}
}
