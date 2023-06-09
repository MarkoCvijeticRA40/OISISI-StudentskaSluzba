package views.Student.Edit.Exams.NotPassed;

import javax.swing.table.AbstractTableModel;

import controllers.StudentController;
import models.Student;
import persistence.Database;

public class AbstractTableModelExams extends AbstractTableModel {

	private static final long serialVersionUID = -8578233622644611565L;

	@Override
	public int getRowCount() {
		Student selectedStudent = StudentController.getInstance().getSelectedStudent();
		int rowCount = selectedStudent.getNotPassedExams().size();
		return (rowCount < 15)? 15 : rowCount;
	}

	@Override
	public int getColumnCount() {
		return Database.getInstance().getSubjectDatabase().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student selectedStudent = StudentController.getInstance().getSelectedStudent();
		return Database.getInstance().getStudentDatabase().getValueAtNotPassedExams(selectedStudent, rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) { 
		return Database.getInstance().getSubjectDatabase().getColumnName(columnIndex);
	}

}
