package views.Professor.Edit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import controllers.ProfessorController;
import controllers.validators.ValidationPatterns;
import models.Professor;
import views.Professor.BaseProfessorFormJPanel;
import views.Professor.listeners.EditProfessorFocusListener;

public class EditProfessorFormPanel extends BaseProfessorFormJPanel {

	private static final long serialVersionUID = -1915079276643860971L;

	public EditProfessorFormPanel() {
		super(new EditProfessorFocusListener());
		
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorController.getInstance().edit();
			}
			
		});
		
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditProfessorDialog.getInstance().dispose();
			}
			
		});
	}
	
	public boolean init() {
		Professor selectedProfessor = ProfessorController.getInstance().getSelectedProfessor();
		if (selectedProfessor == null)
			return false;
		setTextFields(selectedProfessor);
		this.firstNameTxt.requestFocus();
		this.submitBtn.setEnabled(false);
		return true;
	}
	
	private void setTextFields(Professor professor) {
		this.setTextFieldsBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		this.firstNameTxt.setText(professor.getFirstName());
		this.lastNameTxt.setText(professor.getLastName());
		this.dateOfBirthTxt.setText(ValidationPatterns.dateFormat.format(professor.getDateOfBirth()));
		this.addressTxt.setText(professor.getAddress().toString());
		this.phoneNumberTxt.setText(professor.getPhoneNumber());
		this.emailTxt.setText(professor.getEmail());
		this.officeAddressTxt.setText(professor.getOfficeAddress().toString());
		this.idCardNumberTxt.setText(String.valueOf(professor.getIdCardNumber()));
		this.titleTxt.setText(professor.getTitle());
		this.yearsOfServiceTxt.setText(String.valueOf(professor.getYearsOfService()));
	}
	
}
