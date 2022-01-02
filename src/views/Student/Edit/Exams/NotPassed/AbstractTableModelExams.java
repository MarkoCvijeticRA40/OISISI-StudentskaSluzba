package views.Student.Edit.Exams.NotPassed;

import javax.swing.table.AbstractTableModel;

import persistence.StudentDatabase;
import persistence.SubjectDatabase;
import views.Student.Representation.StudentsJTable;

public class AbstractTableModelExams extends AbstractTableModel {

	private static final long serialVersionUID = -8578233622644611565L;

	@Override
	public int getRowCount() {
		return 25;
	}

	@Override
	public int getColumnCount() {
		return SubjectDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int selectedStudentRowIndex = StudentsJTable.getInstance().getSelectedRow();
		return StudentDatabase.getInstance().getValueAtNotPassedExams(selectedStudentRowIndex, rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) { 
		return SubjectDatabase.getInstance().getColumnName(columnIndex);
	}

}
