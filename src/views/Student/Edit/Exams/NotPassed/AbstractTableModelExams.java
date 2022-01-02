package views.Student.Edit.Exams.NotPassed;

import javax.swing.table.AbstractTableModel;

import persistence.Database;
import views.Student.Representation.StudentsJTable;

public class AbstractTableModelExams extends AbstractTableModel {

	private static final long serialVersionUID = -8578233622644611565L;

	@Override
	public int getRowCount() {
		return 25;
	}

	@Override
	public int getColumnCount() {
		return Database.getInstance().getSubjectDatabase().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selectedStudentRowIndex = StudentsJTable.getInstance().getSelectedRow();
		return Database.getInstance().getStudentDatabase().getValueAtNotPassedExams(selectedStudentRowIndex, rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) { 
		return Database.getInstance().getSubjectDatabase().getColumnName(columnIndex);
	}

}
