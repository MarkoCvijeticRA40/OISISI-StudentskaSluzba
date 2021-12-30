package views.Student.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.StudentController;
import views.Student.Add.AddStudentDialog;

public class AddStudentFormFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField input = (JTextField)e.getComponent();
		boolean result = StudentController.getInstance().getInputValidationState(input.getName());
		if (result && input.getName().compareTo("email") == 0) {
			result = StudentController.getInstance().isEmailUnique(input.getText());
			if (!result) {
				AddStudentDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(false);
				JOptionPane.showMessageDialog(null, "Email vec postoji!");
			}
		}
		else if (result && input.getName().compareTo("indexNumber") == 0) {
			result = StudentController.getInstance().isIndexNumberUnique(input.getText());
			if (!result) {
				AddStudentDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(false);
				JOptionPane.showMessageDialog(null, "Broj indeksa vec postoji!");
			}
		}
		if(result)
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		else
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
	}
}
