package controllers;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.validators.SubjectValidator;
import models.Professor;
import models.Semester;
import models.Subject;
import persistence.Database;
import persistence.SubjectDatabase;
import views.Subject.BaseSubjectFormJPanel;
import views.Subject.Add.AddSubjectDialog;
import views.Subject.Edit.EditSubjectDialog;
import views.Subject.Representation.SubjectsJTable;

public class SubjectController {
	
	private static SubjectController controller;
	
	private SubjectValidator formValidator;
	private SubjectDatabase subjectsDatabase;
	
	private SubjectController() {
		this.formValidator = new SubjectValidator();
		this.subjectsDatabase = Database.getInstance().getSubjectDatabase();
	}
	
	public static SubjectController getInstance() {
		if (controller == null)
			controller = new SubjectController();
		return controller;
	}
	
	public void add() {
		Subject subject = createSubject(AddSubjectDialog.getInstance().getAddForm());
		if (subject == null)
			return;
		this.subjectsDatabase.addSubject(subject);
		SubjectsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Predmet uspesno dodat!");
		AddSubjectDialog.getInstance().dispose();
	}
	
	public void edit() {
		Subject subject = createSubject(EditSubjectDialog.getInstance().getEditForm());
		if (subject == null)
			return;
		Subject subjectToEdit = this.getSelectedSubject();
		String professorEmail = EditSubjectDialog.getInstance().getEditForm().getProfessorEmail();
		if (!professorEmail.isEmpty()) {
			Professor p = Database.getInstance().getProfessorDatabase().getByEmail(professorEmail);
			subjectToEdit.setProfessor(p);
		}
		else
			subjectToEdit.setProfessor(null);
		this.subjectsDatabase.editSubject(subject, subjectToEdit);
		SubjectsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Predmet uspesno izmenjen!");
		EditSubjectDialog.getInstance().dispose();
	} 
	
	public void delete() {
		int selectedRow = SubjectsJTable.getInstance().getSelectedRow();
		Subject subject = this.getSelectedSubject();
		if (subject == null)
			return;
		if (StudentController.getInstance().checkSubjectExistence(subject)
				|| ProfessorController.getInstance().checkSubjectExistence(subject)) {
			JOptionPane.showMessageDialog(null, "Predmet neuspesno obrisan!\nPostoji referenca na predmet!");
			return;
		}
		this.subjectsDatabase.deleteSubject(selectedRow);
		SubjectsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Predmet uspesno obrisan!");
	}
	
	public void search(String query) {
		String[] params = query.split(", ");
		if (params.length == 2)
			this.subjectsDatabase.filter(params[0], params[1]);
		else if (params.length == 1 && params[0].compareTo("") != 0)
			this.subjectsDatabase.filter(params[0]);
		else
			this.subjectsDatabase.resetFilter();
		SubjectsJTable.getInstance().updateView();
	}
	
	public Subject getSelectedSubject() {
		int selectedRow = SubjectsJTable.getInstance().getSelectedRow();
		if (this.subjectsDatabase.getRowCount() <= selectedRow)
			return null;
		Subject subject = this.subjectsDatabase.getRow(selectedRow);
		return subject;
	}
	
	public Subject getSubjectById(String id) {
		for (Subject subject : this.subjectsDatabase.getSubjects()) {
			if (subject.getId().compareTo(id) == 0)
				return subject;
		}
		return null;
	}
	
	public List<Subject> getAllSubjects() {
		return this.subjectsDatabase.getSubjects();
	}
	
	public boolean checkProfessorExistence(Professor professor) {
		for (Subject subject : subjectsDatabase.getSubjects()) {
			if (subject.getProfessor() == professor)
				return true;
		}
		return false;
	}
	
	public boolean isIdUnique(String id) {
		for (Subject subject : this.subjectsDatabase.getSubjects()) {
			if (subject.getId().compareTo(id) == 0)
				return false;
		}
		return true;
	}
	
	public boolean inputFieldsValidationState() {
		return formValidator.isAllValid();
	}
	
	public void inputFieldCheck(JTextField input) {
		formValidator.validateInput(input.getName(), input.getText());
	}
	
	public void formValidatorSet(boolean state) {
		formValidator.setValidator(state);
	}
	
	public boolean getInputValidationState(String inputName) {
		return formValidator.getValidationState(inputName);
	}
	
	private Subject createSubject(BaseSubjectFormJPanel form) {
		if (!this.formValidator.isAllValid()) {
			JOptionPane.showMessageDialog(null, "Podaci nisu validni!");
			return null;
		}
		String id = form.getIdTxt().getText();
		String name = form.getNameTxt().getText();
		int esbp = Integer.valueOf(form.getEsbpTxt().getText());
		Semester semester = (Semester) form.getSemesterCmb().getSelectedItem();
		int studyYear = (Integer) form.getStudyYearCmb().getSelectedItem();
		return new Subject(id, name, semester, studyYear, esbp);
	}
}
