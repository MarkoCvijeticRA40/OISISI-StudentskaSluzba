package views.Subject.Representation;

import javax.swing.table.AbstractTableModel;

import persistence.Database;

public class AbstractTableModelSubject extends AbstractTableModel {

	private static final long serialVersionUID = -8553583644956871698L;
	
	public AbstractTableModelSubject() {
		
	}

	@Override
	public int getRowCount() {
		return 40;
		//return SubjectDatabase.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return Database.getInstance().getSubjectDatabase().getColumnCount();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return Database.getInstance().getSubjectDatabase().getColumnName(columnIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return Database.getInstance().getSubjectDatabase().getValueAt(rowIndex, columnIndex);
	}

}
