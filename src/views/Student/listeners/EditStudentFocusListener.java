package views.Student.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.StudentController;
import views.Student.Edit.EditStudentDialog;

public class EditStudentFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField input = (JTextField)e.getComponent();
		boolean result = StudentController.getInstance().inputFieldCheck(input);
		if (!result && input.getText().compareTo("") != 0) {
			JOptionPane.showMessageDialog(null, "Pogresan unos!");
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
		}
		else if(result)
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		else
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
		if (StudentController.getInstance().inputFieldsValidationState())
			EditStudentDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(true);
		else
			EditStudentDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(false);
	}
}

