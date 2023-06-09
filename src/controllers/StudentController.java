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
import views.Student.Edit.Exams.NotPassed.NotPassedExamsJTable;
import views.Student.Representation.StudentsJTable;

public class StudentController {

	private static StudentController controller;
	
	private StudentFormValidator formValidator;
	private StudentDatabase studentsDatabase;
	
	private StudentController() {
		this.formValidator = new StudentFormValidator();
		this.studentsDatabase = Database.getInstance().getStudentDatabase();
	}
	
	public static StudentController getInstance() {
		if (controller == null)
			controller = new StudentController();
		return controller;
	}
	
	public void add() {
		Student student = createStudent(AddStudentDialog.getInstance().getAddForm());
		if (student == null)
			return;
		this.studentsDatabase.addStudent(student);
		StudentsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Student uspesno dodat!");
		AddStudentDialog.getInstance().dispose();
	}
	
	public void addNotPassedExam(Subject subject) {
		Student student = this.getSelectedStudent();
		student.getNotPassedExams().add(subject);
		NotPassedExamsJTable.getInstance().updateView();
	}
	
	public void edit() {
		Student student = createStudent(EditStudentDialog.getInstance().getEditForm());
		if (student == null)
			return;
		int selectedRow = StudentsJTable.getInstance().getSelectedRow();
		this.studentsDatabase.editStudent(selectedRow,student);
		StudentsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Student uspesno izmenjen!");
		EditStudentDialog.getInstance().dispose();
	}
	
	public void delete() {
		Student student = this.getSelectedStudent();
		if (student  == null)
			return;
		this.studentsDatabase.deleteStudent(student);
		StudentsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Student uspesno obrisan!");
	}
	
	public void deleteNotPassExam(String id) {
		Subject exam = Database.getInstance().getSubjectDatabase().getSubjctById(id);
		Student student = this.getSelectedStudent();
		student.getNotPassedExams().remove(exam);
		NotPassedExamsJTable.getInstance().updateView();
	}
	
	public void deletePassedExam(String id) {
		Subject exam = Database.getInstance().getSubjectDatabase().getSubjctById(id);
		Student student = this.getSelectedStudent();
		for (ExamGrade examGrade : student.getPassedExams()) {
			if (examGrade.getSubject() == exam) {
				student.getPassedExams().remove(examGrade);
				break;
			}
		}
		student.getNotPassedExams().add(exam);
		student.setRating(this.studentsDatabase.getAvgRating(student));
		StudentsJTable.getInstance().updateView();
		EditStudentDialog.getInstance().getPassedExamesPanel().updateView();
		NotPassedExamsJTable.getInstance().updateView();
	}
	
	public void search(String query) {
		String[] params = query.split(", ");
		if (params.length == 3)
			this.studentsDatabase.filter(params[0], params[1], params[2]);
		else if (params.length == 2)
			this.studentsDatabase.filter(params[0], params[1]);
		else if (params.length == 1 && params[0].compareTo("") != 0)
			this.studentsDatabase.filter(params[0]);
		else
			this.studentsDatabase.resetFilter();
		StudentsJTable.getInstance().updateView();
	}
	
	public Student getSelectedStudent() {
		int selectedRow = StudentsJTable.getInstance().getSelectedRow();
		String indexNumber = (String) StudentsJTable.getInstance().getValueAt(selectedRow, 0);
		Student student = this.studentsDatabase.getByIndexNumber(indexNumber);
		return student;
	}
	
	public Subject getSelectedNotPassedExam() {
		int selectedStudent = StudentsJTable.getInstance().getSelectedRow();
		int selectedNotPassedExam = NotPassedExamsJTable.getInstance().getSelectedRow();
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
		student.setRating(this.studentsDatabase.getAvgRating(student));
		StudentsJTable.getInstance().updateView();
		NotPassedExamsJTable.getInstance().updateView();
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
				form.getAddressHouseNumberTxt().getText(),
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
	
	public boolean checkSubjectExistence(Subject subject) {
		for (Student s : this.studentsDatabase.getStudents()) {
			if (s.getNotPassedExams().contains(subject))
				return true;
			for (ExamGrade grade : s.getPassedExams()) {
				if (grade.getSubject() == subject)
					return true;
			}
		}
		return false;
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