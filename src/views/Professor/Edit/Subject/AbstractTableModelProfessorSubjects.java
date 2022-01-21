package views.Professor.Edit.Subject;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import controllers.ProfessorController;
import models.Subject;
import persistence.Database;

public class AbstractTableModelProfessorSubjects extends AbstractTableModel {

	private static final long serialVersionUID = 6227543012996788607L;

	@Override
	public int getRowCount() {
		int rowCount =  ProfessorController.getInstance().getSelectedProfessor().getSubjects().size();
		return (rowCount < 15)? 15 : rowCount;
	}

	@Override
	public int getColumnCount() {
		return Database.getInstance().getSubjectDatabase().getColumnCount() - 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Subject> subjects = ProfessorController.getInstance().getSelectedProfessor().getSubjects();
		if (rowIndex >= subjects.size())
			return "";
		Subject subject = subjects.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return String.valueOf(subject.getId());
			case 1:
				return subject.getName();
			case 2:
				return String.valueOf(subject.getStudyYear());
			case 3:
				return subject.getSemester().toString();
			default:
				return "";
		}
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return Database.getInstance().getSubjectDatabase().getColumnName(columnIndex);
	}

}
