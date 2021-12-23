package controllers;

import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.validators.StudentFormValidator;
import controllers.validators.ValidationPatterns;
import models.Address;
import models.Status;
import models.Student;
import persistence.StudentDatabase;
import views.MainFrame;
import views.Student.BaseStudentFormJPanel;
import views.Student.Add.AddStudentDialog;
import views.Student.Edit.EditStudentDialog;
import views.Student.Representation.StudentsJTable;

public class StudentController {

	private static StudentController controller;
	
	private StudentFormValidator formValidator;
	private BaseStudentFormJPanel addForm;
	private BaseStudentFormJPanel editForm;
	private StudentsJTable studentTable;
	private StudentDatabase studentsDatabase;
	
	private StudentController() {
		this.formValidator = new StudentFormValidator();
		this.addForm = AddStudentDialog.getInstance().getAddForm();
		this.editForm = EditStudentDialog.getInstance().getEditForm();
		this.studentTable = MainFrame.getInstance().getTabbedPane().getStudentTab().getTable();
		this.studentsDatabase = StudentDatabase.getInstance();
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
		if (this.studentsDatabase.getRowCount() <= selectedRow)
			return null;
		Student student = this.studentsDatabase.getRow(selectedRow);
		return student;
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
	
	public boolean inputFieldCheck(JTextField input, String formType) {
		boolean result =  formValidator.validateInput(input.getName(), input.getText());
		if (result && input.getName().compareTo("email") == 0) {
			if (formType.compareTo("edit") == 0 && input.getText().compareTo(EditStudentDialog.getInstance().getEditForm().getCurrentEmail()) == 0)
				return true;
			return !this.checkEmailExistence(input.getText());
		}
		return result;
	}
	
	public boolean inputFieldsValidationState() {
		return formValidator.isAllValid();
	}
	
	public void formValidatorSet(boolean state) {
		formValidator.setValidator(state);
	}
	
	private boolean checkEmailExistence(String email) {
		for (Student student : this.studentsDatabase.getStudents()) {
			if (student.getEmail().compareTo(email) == 0) {
				this.formValidator.setValidation("email", false);
				return true;
			}
		}
		return false;
	}
}
