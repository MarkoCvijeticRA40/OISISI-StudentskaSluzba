package views.Professor.Representation;

import javax.swing.table.AbstractTableModel;

import persistence.Database;

public class AbstractTableModelProfessor extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7765393314528292347L;

	public AbstractTableModelProfessor() {
		
	}

	@Override
	public int getRowCount() {
		return 40;
		//return ProfessorDatabase.getInstance().getRowCount();
	}

	@Override
	public int getColumnCount() {
		return Database.getInstance().getProfessorDatabase().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return Database.getInstance().getProfessorDatabase().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return Database.getInstance().getProfessorDatabase().getValueAt(rowIndex, columnIndex);
	}
}
