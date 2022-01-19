package controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.validators.StudentFormValidator;
import controllers.validators.ValidationPatterns;
import models.Address;
import models.ExamGrade;
import models.Status;
import models.Student;
import models.Subject;
import persistence.Database;
import persistence.StudentDatabase;
import views.Student.BaseStudentFormJPanel;
import views.Student.Add.AddStudentDialog;
import views.Student.Edit.EditStudentDialog;
import views.Student.Edit.Exams.NotPassed.AddPassedExamDialog;
import views.Student.Edit.Exams.NotPassed.ExamsJTable;
import views.Student.Representation.StudentsJTable;

public class StudentController {

	private static StudentController controller;
	
	private StudentFormValidator formValidator;
	private BaseStudentFormJPanel addForm;
	private BaseStudentFormJPanel editForm;
	private StudentsJTable studentTable;
	private ExamsJTable examTable;
	private StudentDatabase studentsDatabase;
	
	private StudentController() {
		this.formValidator = new StudentFormValidator();
		this.addForm = AddStudentDialog.getInstance().getAddForm();
		this.editForm = EditStudentDialog.getInstance().getEditForm();
		this.studentTable = StudentsJTable.getInstance();
		this.examTable = ExamsJTable.getInstance();
		this.studentsDatabase = Database.getInstance().getStudentDatabase();
	}
	
	public static StudentController getInstance() {
		if (controller == null)
			controller = new StudentController();
		return controller;
	}
	
	public void add() {
		Student student = createStudent(this.addForm);
		if (student == null)
			return;
		this.studentsDatabase.addStudent(student);
		this.studentTable.updateView();
		JOptionPane.showMessageDialog(null, "Student uspesno dodat!");
		AddStudentDialog.getInstance().dispose();
	}
	
	public void addNotPassedExam(Subject subject) {
		Student student = this.getSelectedStudent();
		student.getNotPassedExams().add(subject);
		this.examTable.updateView();
	}
	
	public void edit() {
		Student student = createStudent(this.editForm);
		if (student == null)
			return;
		int selectedRow = studentTable.getSelectedRow();
		this.studentsDatabase.editStudent(selectedRow,student);
		this.studentTable.updateView();
		JOptionPane.showMessageDialog(null, "Student uspesno izmenjen!");
		EditStudentDialog.getInstance().dispose();
	}
	
	public void delete() {
		int selectedRow = studentTable.getSelectedRow();
		Student student = this.getSelectedStudent();
		if (student  == null)
			return;
		this.studentsDatabase.deleteStudent(selectedRow);
		this.studentTable.updateView();
		JOptionPane.showMessageDialog(null, "Student uspesno obrisan!");
	}
	
	public Student getSelectedStudent() {
		int selectedRow = studentTable.getSelectedRow();
		String indexNumber = (String) this.studentTable.getValueAt(selectedRow, 0);
		Student student = this.studentsDatabase.getByIndexNumber(indexNumber);
		return student;
	}
	
	public Subject getSelectedNotPassedExam() {
		int selectedStudent = this.studentTable.getSelectedRow();
		int selectedNotPassedExam = this.examTable.getSelectedRow();
		return this.studentsDatabase.getNotPassedExamRow(selectedStudent, selectedNotPassedExam);
	}
	
	public List<Subject> getAvailableNewExams() {
		Student student = this.getSelectedStudent();
		List<Subject> subjects = Database.getInstance().getSubjectDatabase().getSubjects();
		List<Subject> availableSubjects = new LinkedList<>();
		for (Subject subject : subjects) {
			if (subject.getStudyYear() <= student.getCurrentStudiesYear()) {
				if (!student.getNotPassedExams().contains(subject)) {
					boolean found = false;
					for (ExamGrade examGrade : student.getPassedExams()) {
						if (examGrade.getSubject() == subject) {
							found = true;
							break;
						}
					}
					if (!found)
						availableSubjects.add(subject);
				}
			}
		}
		return availableSubjects;
	}
	
	public void addPassedExam() {
		Student student = this.getSelectedStudent();
		Subject subject = this.getSelectedNotPassedExam();
		if (!student.getNotPassedExams().remove(subject)) {
			JOptionPane.showMessageDialog(null, "Upis ocene neuspesan!");
		}
		int grade = AddPassedExamDialog.getInstance().getSelectedGrade();
		Date date = AddPassedExamDialog.getInstance().getSelectedDate();
		ExamGrade examGrade = new ExamGrade(
				student, 
				subject, 
				grade,
				date);
		student.getPassedExams().add(examGrade);
		examTable.updateView();
	}
	
	private Student createStudent(BaseStudentFormJPanel form) {
		if (!this.formValidator.isAllValid()) {
			JOptionPane.showMessageDialog(null, "Podaci nisu validni!");
			return null;
		}
		String firstName = form.getFirstNameTxt().getText();
		String lastName = form.getLastNameTxt().getText();
		Date dateOfBirth;
		try {
			dateOfBirth = ValidationPatterns.dateFormat.parse(form.getDateOfBirthTxt().getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Datum nije validan!");
			return null;
		}
		Address address = new Address(
				form.getAddressStreetTxt().getText(),
				Integer.parseInt(form.getAddressHouseNumberTxt().getText()),
				form.getAddressCityTxt().getText(),
				form.getAddressCountryTxt().getText());
		String phoneNumber = form.getPhoneNumberTxt().getText();
		String email = form.getEmailTxt().getText();
		String indexNumber = form.getIndexNumberTxt().getText();
		int enrollmentYear = Integer.parseInt(form.getEnrollmentYearTxt().getText());
		int currentYear = (Integer) form.getCurrentStudiesYearCmb().getSelectedItem();
		Status financingStatus = (Status) form.getFinancingStatusCmb().getSelectedItem();
		return new Student(
				firstName,
				lastName,
				dateOfBirth,
				address,
				phoneNumber,
				email,
				indexNumber,
				enrollmentYear,
				currentYear,
				financingStatus,
				0);
	}
	
	public void inputFieldCheck(JTextField input) {
		formValidator.validateInput(input.getName(), input.getText());
	}
	
	public boolean isEmailUnique(String email) {
		boolean result =  this.checkEmailExistence(email) || ProfessorController.getInstance().checkEmailExistence(email);
		if (result)
			formValidator.setValidation("email", false);
		return !result;
	}
	
	public boolean isIndexNumberUnique(String indexNumber) {
		boolean result = this.checkIndexNumberExistence(indexNumber);
		if (result)
			formValidator.setValidation("indexNumber", false);
		return !result;
	}
	
	public boolean inputFieldsValidationState() {
		return formValidator.isAllValid();
	}
	
	public void formValidatorSet(boolean state) {
		formValidator.setValidator(state);
	}
	
	public boolean getInputValidationState(String inputName) {
		return formValidator.getValidationState(inputName);
	}
	
	public boolean checkEmailExistence(String email) {
		for (Student student : this.studentsDatabase.getStudents()) {
			if (student.getEmail().compareTo(email) == 0) {
				this.formValidator.setValidation("email", false);
				return true;
			}
		}
		return false;
	}
	
	private boolean checkIndexNumberExistence(String indexNumber) {
		for (Student student : this.studentsDatabase.getStudents()) {
			if (student.getIndexNumber().compareTo(indexNumber) == 0) {
				this.formValidator.setValidation("indexNumber", false);
				return true;
			}
		}
		return false;	
	}	
}