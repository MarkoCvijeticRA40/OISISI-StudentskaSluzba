package views.Student.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.StudentController;
import views.Student.Edit.EditStudentDialog;

public class EditStudentFormFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField input = (JTextField)e.getComponent();
		boolean result = StudentController.getInstance().getInputValidationState(input.getName());
		if (result && input.getName().compareTo("email") == 0) {
			if (!(EditStudentDialog.getInstance().getEditForm().getCurrentEmail().compareTo(input.getText()) == 0)) {
				result = StudentController.getInstance().isEmailUnique(input.getText());
				if (!result) {
					EditStudentDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(false);
					JOptionPane.showMessageDialog(null, "Email vec postoji!");
				}
			}
		}
		else if (result && input.getName().compareTo("idCardNumber") == 0) {
			if (!(EditStudentDialog.getInstance().getEditForm().getCurrentIndexNumber().compareTo(input.getText()) == 0)) {
				result = StudentController.getInstance().isIndexNumberUnique(input.getText());
				if (!result) {
					EditStudentDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(false);
					JOptionPane.showMessageDialog(null, "Broj licne karte vec postoji!");
				}
			}
		}
		if(result)
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		else
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
	}
}

