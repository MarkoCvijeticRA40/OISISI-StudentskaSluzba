package views.Professor.Add;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import controllers.ProfessorController;
import views.Professor.BaseProfessorFormJPanel;
import views.Professor.listeners.AddProfessorFocusListener;

public class AddProfessorFormPanel extends BaseProfessorFormJPanel {
	
	private static final long serialVersionUID = 8830694607456986724L;

	public AddProfessorFormPanel() {
		super(new AddProfessorFocusListener());
		
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorController.getInstance().add();
			}
			
		});
		
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddProfessorDialog.getInstance().dispose();
			}
			
		});
		
	}
	
	public void init() {
		resetTextFields();
		this.firstNameTxt.requestFocus();
		this.submitBtn.setEnabled(false);
	}
	
	private void resetTextFields() {
		this.setTextFieldsBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		this.firstNameTxt.setText("");
		this.lastNameTxt.setText("");
		this.dateOfBirthTxt.setText("31/01/2000");
		this.addressStreetTxt.setText("");
		this.addressHouseNumberTxt.setText("");
		this.addressCityTxt.setText("");
		this.addressCountryTxt.setText("");
		this.phoneNumberTxt.setText("");
		this.emailTxt.setText("");
		this.officeAddressStreetTxt.setText("");
		this.officeAddressHouseNumberTxt.setText("");
		this.officeAddressCityTxt.setText("");
		this.officeAddressCountryTxt.setText("");
		this.idCardNumberTxt.setText("");
		this.titleCmb.setSelectedIndex(0);
		this.yearsOfServiceTxt.setText("");
	}
}
