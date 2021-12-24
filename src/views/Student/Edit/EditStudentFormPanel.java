package views.Student.Edit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import controllers.StudentController;
import controllers.validators.ValidationPatterns;
import models.Student;
import views.Student.BaseStudentFormJPanel;
import views.Student.listeners.EditStudentFocusListener;

public class EditStudentFormPanel extends BaseStudentFormJPanel {

	private static final long serialVersionUID = -3983591677674751305L;
	
	private String currentEmail;
	private String currentIndexNumber;
	
	public EditStudentFormPanel() {
		super(new EditStudentFocusListener());
		
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController.getInstance().edit();
			}
			
		});
		
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditStudentDialog.getInstance().dispose();
			}
			
		});

	}
	
	public boolean init() {
		Student selectedStudent = StudentController.getInstance().getSelectedStudent();
		if (selectedStudent == null)
			return false;
		this.currentEmail = selectedStudent.getEmail();
		this.currentIndexNumber = selectedStudent.getIndexNumber();
		setTextFields(selectedStudent);
		this.firstNameTxt.requestFocus();
		this.submitBtn.setEnabled(true);
		return true;
	}
	
	private void setTextFields(Student student) {
		this.setTextFieldsBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		this.firstNameTxt.setText(student.getFirstName());
		this.lastNameTxt.setText(student.getLastName());
		this.dateOfBirthTxt.setText(ValidationPatterns.dateFormat.format(student.getDateOfBirth()));
		this.addressStreetTxt.setText(student.getAddress().getStreet());
		this.addressHouseNumberTxt.setText(String.valueOf(student.getAddress().getHouseNumber()));
		this.addressCityTxt.setText(student.getAddress().getCity());
		this.addressCountryTxt.setText(student.getAddress().getCountry());
		this.phoneNumberTxt.setText(student.getPhoneNumber());
		this.emailTxt.setText(student.getEmail());
		this.indexNumberTxt.setText(student.getIndexNumber());
		this.enrollmentYearTxt.setText(String.valueOf(student.getEnrollmentYear()));
		this.currentStudiesYearCmb.setSelectedItem(student.getCurrentStudiesYear());
		this.financingStatusCmb.setSelectedItem(student.getFinancingStatus());
	}
	
	public String getCurrentEmail() {
		return this.currentEmail;
	}
	public String getCurrentIndexNumber () {
		return this.currentIndexNumber;
	}
}