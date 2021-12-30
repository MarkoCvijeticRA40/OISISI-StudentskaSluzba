package views.Professor.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.ProfessorController;
import views.Professor.Add.AddProfessorDialog;

public class AddProfessorFormFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField input = (JTextField)e.getComponent();
		boolean result = ProfessorController.getInstance().getInputValidationState(input.getName());
		if (result && input.getName().compareTo("email") == 0) {
			result = ProfessorController.getInstance().isEmailUnique(input.getText());
			if (!result) {
				AddProfessorDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(false);
				JOptionPane.showMessageDialog(null, "Email vec postoji!");
			}
		}
		else if (result && input.getName().compareTo("idCardNumber") == 0) {
			result = ProfessorController.getInstance().isIdCardNumberUnique(Integer.parseInt(input.getText()));
			if (!result) {
				AddProfessorDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(false);
				JOptionPane.showMessageDialog(null, "Broj licne karte vec postoji!");
			}
		}
		if(result)
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		else
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
	}
	
}
