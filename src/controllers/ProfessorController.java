package controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.validators.ProfessorFormValidator;
import controllers.validators.ValidationPatterns;
import models.Address;
import models.Professor;
import models.Subject;
import persistence.Database;
import persistence.ProfessorDatabase;
import views.Professor.BaseProfessorFormJPanel;
import views.Professor.Add.AddProfessorDialog;
import views.Professor.Edit.EditProfessorDialog;
import views.Professor.Edit.Subject.ProfessorSubjectsJTable;
import views.Professor.Representation.ProfessorsJTable;

public class ProfessorController {
	
	private static ProfessorController controller;
	
	private ProfessorFormValidator formValidator;
	private ProfessorDatabase professorsDatabase;
	
	private ProfessorController() {
		this.formValidator = new ProfessorFormValidator();
		this.professorsDatabase = Database.getInstance().getProfessorDatabase();
	}
	
	public static ProfessorController getInstance() {
		if (controller == null)
			controller = new ProfessorController();
		return controller;
	}
	
	public void add() {
		Professor professor = createProfessor(AddProfessorDialog.getInstance().getAddForm());
		if (professor == null)
			return;
		this.professorsDatabase.addProfessor(professor);
		ProfessorsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Profesor uspesno dodat!");
		AddProfessorDialog.getInstance().dispose();
	}
	
	public void addSubjects(List<Subject> subjects) {
		Professor professor = this.getSelectedProfessor();
		professor.getSubjects().addAll(subjects);
		ProfessorSubjectsJTable.getInstance().updateView();
	}
	
	public void edit() {
		Professor professor = createProfessor(EditProfessorDialog.getInstance().getEditForm());
		if (professor == null)
			return;
		Professor professorToEdit = this.getSelectedProfessor();
		this.professorsDatabase.editProfessor(professorToEdit, professor);
		ProfessorsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Profesor uspesno izmenjen!");
		EditProfessorDialog.getInstance().dispose();
	}
	
	public void delete() {
		Professor professor = this.getSelectedProfessor();
		if (professor == null)
			return;
		if (SubjectController.getInstance().checkProfessorExistence(professor)) {
			JOptionPane.showMessageDialog(null, "Profesor neuspesno obrisan!\nPostoji referenca na predmetnog profesora.");
			return;
		}
		this.professorsDatabase.deleteProfessor(professor);
		ProfessorsJTable.getInstance().updateView();
		JOptionPane.showMessageDialog(null, "Profesor uspesno obrisan!");
	}
	
	public void search(String query) {
		String[] params = query.split(", ");
		if (params.length == 3)
			this.professorsDatabase.filter(params[0], params[1], params[2]);
		else if (params.length == 2)
			this.professorsDatabase.filter(params[0], params[1]);
		else if (params.length == 1 && params[0].compareTo("") != 0)
			this.professorsDatabase.filter(params[0]);
		else
			this.professorsDatabase.resetFilter();
		ProfessorsJTable.getInstance().updateView();
	}
	
	public Professor getSelectedProfessor() {
		int selectedRow = ProfessorsJTable.getInstance().getSelectedRow();
		String email = (String) ProfessorsJTable.getInstance().getValueAt(selectedRow, 3);
		Professor professor = this.professorsDatabase.getByEmail(email);
		return professor;
	}
	
	public List<Professor> getProfessorsBySubject(int subjectId) {
		List<Professor> availableProfessor = new LinkedList<>();
		for (Professor professor : this.professorsDatabase.getProfessors()) {
			for (Subject subject : professor.getSubjects()) {
				if (subject.getId() == subjectId) {
					availableProfessor.add(professor);
					break;
				}
			}
		}
		return availableProfessor;
	}
	
	public List<Subject> getPossibleNewSubjects() {
		Professor professor = this.getSelectedProfessor();
		if (professor.getSubjects().size() == 0)
			return SubjectController.getInstance().getAllSubjects();
		List<Subject> availableSubjects = new LinkedList<>();
		for (Subject subject : SubjectController.getInstance().getAllSubjects()) {
			if (!professor.getSubjects().contains(subject))
				availableSubjects.add(subject);
		}
		return availableSubjects;
	}
	
	public void inputFieldCheck(JTextField input) {
		formValidator.validateInput(input.getName(), input.getText());
	}
	
	public boolean isEmailUnique(String email) {
		boolean result =  this.checkEmailExistence(email) || StudentController.getInstance().checkEmailExistence(email);
		if (result)
			formValidator.setValidation("email", false);
		return !result;
	}
	
	public boolean isIdCardNumberUnique(int idCardNumber) {
		boolean result = this.checkIdCardNumberExistence(idCardNumber);
		if (result)
			formValidator.setValidation("idCardNumber", false);
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
		Address address = new Address(
				form.getAddressStreetTxt().getText(),
				Integer.parseInt(form.getAddressHouseNumberTxt().getText()),
				form.getAddressCityTxt().getText(),
				form.getAddressCountryTxt().getText());
		String phoneNumber = form.getPhoneNumberTxt().getText();
		String email = form.getEmailTxt().getText();
		Address officeAddress = new Address(
				form.getOfficeAddressStreetTxt().getText(),
				Integer.parseInt(form.getOfficeAddressHouseNumberTxt().getText()),
				form.getOfficeAddressCityTxt().getText(),
				form.getOfficeAddressCountryTxt().getText());
		int idCardNumber = Integer.parseInt(form.getIdCardNumberTxt().getText());
		String title = (String) form.getTitleCmb().getSelectedItem();
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
	
	public boolean checkEmailExistence(String email) {
		for (Professor professor : this.professorsDatabase.getProfessors()) {
			if (professor.getEmail().compareTo(email) == 0) {
				this.formValidator.setValidation("email", false);
				return true;
			}
		}
		return false;
	}
	
	private boolean checkIdCardNumberExistence(int idCardNumber) {
		for (Professor professor : this.professorsDatabase.getProfessors()) {
			if (professor.getIdCardNumber() == idCardNumber) {
				this.formValidator.setValidation("idCardNumber", false);
				return true;
			}
		}
		return false;
	}
}
