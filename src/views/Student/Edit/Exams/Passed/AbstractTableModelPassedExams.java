package views.Student.Edit.Exams.Passed;

import javax.swing.table.AbstractTableModel;

import controllers.StudentController;
import models.Student;
import persistence.Database;

public class AbstractTableModelPassedExams extends AbstractTableModel {

	private static final long serialVersionUID = -1842906875330833159L;

	@Override
	public int getRowCount() {
		Student selectedStudent = StudentController.getInstance().getSelectedStudent();
		int rowCount = selectedStudent.getPassedExams().size();
		return (rowCount < 15)? 15 : rowCount;
	}

	@Override
	public int getColumnCount() {
		return Database.getInstance().getSubjectDatabase().getExamGradeColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student selectedStudent = StudentController.getInstance().getSelectedStudent();
		return Database.getInstance().getStudentDatabase().getValueAtPassedExams(selectedStudent, rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) { 
		return Database.getInstance().getSubjectDatabase().getExamGradeColumnName(columnIndex);
	}

}
