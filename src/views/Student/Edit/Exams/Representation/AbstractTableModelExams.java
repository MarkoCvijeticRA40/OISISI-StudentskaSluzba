package views.Student.Edit.Exams.Representation;

import javax.swing.table.AbstractTableModel;

import controllers.StudentController;
import persistence.StudentDatabase;
import persistence.SubjectDatabase;

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
		return StudentDatabase.getInstance().getValueAtNotPassedExams(StudentController.getInstance().getSelectedStudent(), rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) { 
		return SubjectDatabase.getInstance().getColumnName(columnIndex);
	}

}
