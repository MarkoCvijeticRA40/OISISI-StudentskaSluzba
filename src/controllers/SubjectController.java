package controllers;

import javax.swing.JOptionPane;

import models.Professor;
import models.Subject;
import persistence.SubjectDatabase;
import views.Subject.Representation.SubjectsJTable;

public class SubjectController {
	
	private static SubjectController controller;
	
	private SubjectDatabase subjectsDatabase;
	private SubjectsJTable subjectTable;
	
	private SubjectController() {
		this.subjectsDatabase = SubjectDatabase.getInstance();
		this.subjectTable = SubjectsJTable.getInstance();
	}
	
	public static SubjectController getInstance() {
		if (controller == null)
			controller = new SubjectController();
		return controller;
	}
	
	public void delete() {
		int selectedRow = subjectTable.getSelectedRow();
		Subject subject = this.getSelectedStudent();
		if (subject == null)
			return;
		this.subjectsDatabase.deleteSubject(selectedRow);
		this.subjectTable.updateView();
		JOptionPane.showMessageDialog(null, "Predmet uspesno obrisan!");
	}
	
	public Subject getSelectedStudent() {
		int selectedRow = subjectTable.getSelectedRow();
		if (this.subjectsDatabase.getRowCount() <= selectedRow)
			return null;
		Subject subject = this.subjectsDatabase.getRow(selectedRow);
		return subject;
	}
	
	public boolean checkProfessorExistence(Professor professor) {
		for (Subject subject : subjectsDatabase.getSubjects()) {
			if (subject.getProfessor().equals(professor))
				return true;
		}
		return false;
	}
}
