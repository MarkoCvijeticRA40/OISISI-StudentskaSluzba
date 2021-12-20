package controllers;

import java.text.ParseException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.validators.ProfessorFormValidator;
import controllers.validators.ValidationPatterns;
import models.Address;
import models.Professor;
import persistence.ProfessorDatabase;
import views.MainFrame;
import views.Professor.BaseProfessorFormJPanel;
import views.Professor.Add.AddProfessorDialog;
import views.Professor.Representation.ProfessorsJTable;

public class ProfessorController {
	
	private static ProfessorController controller;
	
	private ProfessorFormValidator formValidator;
	private BaseProfessorFormJPanel addForm;
	private ProfessorsJTable professorTable;
	private ProfessorDatabase professorsDatabase;
	
	private ProfessorController() {
		this.formValidator = new ProfessorFormValidator();
		this.addForm = AddProfessorDialog.getInstance().getAddForm();
		this.professorTable = MainFrame.getInstance().getTabbedPane().getProfessorTab().getTable();
		this.professorsDatabase = ProfessorDatabase.getInstance();
	}
	
	public static ProfessorController getInstance() {
		if (controller == null)
			controller = new ProfessorController();
		return controller;
	}
	
	public void add() {
		Professor professor = createProfessor(this.addForm);
		if (professor == null)
			return;
		this.professorsDatabase.addProfessor(professor);
		ProfessorsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Profesor uspesno dodat!");
		AddProfessorDialog.getInstance().dispose();
	}
	
	public void delete() {
		int selectedRow = professorTable.getSelectedRow();
		this.professorsDatabase.deleteProfessor(selectedRow);
		ProfessorsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Profesor uspesno obrisan!");
	}
	
	public Professor getSelectedProfessor() {
		int selectedRow = this.professorTable.getSelectedRow();
		if (this.professorsDatabase.getRowCount() <= selectedRow)
			return null;
		Professor professor = this.professorsDatabase.getRow(selectedRow);
		return professor;
	}
	
	public boolean inputFieldCheck(JTextField input) {
		return formValidator.validateInput(input.getName(), input.getText());
	}
	
	public boolean inputFieldsValidationState() {
		return formValidator.isAllValid();
	}
	
	public void formValidatorSet(boolean state) {
		formValidator.setValidator(state);
	}

	private Professor createProfessor(BaseProfessorFormJPanel form) {
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
		Address address = createAddress(form.getAddressTxt().getText());
		String phoneNumber = form.getPhoneNumberTxt().getText();
		String email = form.getEmailTxt().getText();
		Address officeAddress = createAddress(form.getOfficeAddressTxt().getText());
		int idCardNumber = Integer.parseInt(form.getIdCardNumberTxt().getText());
		String title = form.getTitleTxt().getText();
		int yearsOfService = Integer.parseInt(form.getYearsOfServiceTxt().getText());
		return new Professor(
				firstName,
				lastName,
				dateOfBirth,
				address,
				phoneNumber,
				email,
				officeAddress,
				idCardNumber,
				title,
				yearsOfService);
	}
	
	private Address createAddress(String addressString) {
		String[] fullAddress = addressString.split(", ");
		String city = fullAddress[1];
		String country = fullAddress[2];
		String[] streetAndNumber = fullAddress[0].split(" ");
		int houseNumber = Integer.parseInt(streetAndNumber[streetAndNumber.length - 1]);
		String street = fullAddress[0].replaceAll("\s[0-9]+", "");
		return new Address(
				street,
				houseNumber,
				city,
				country);
	}
}
