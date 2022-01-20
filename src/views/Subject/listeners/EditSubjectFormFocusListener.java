package views.Subject.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.SubjectController;
import views.Subject.Edit.EditSubjectDialog;

public class EditSubjectFormFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField input = (JTextField)e.getComponent();
		boolean result = SubjectController.getInstance().getInputValidationState(input.getName());
		if (result && input.getName().compareTo("id") == 0) {
			if (!(EditSubjectDialog.getInstance().getEditForm().getCurrentId() == Integer.valueOf(input.getText()))) {
				result = SubjectController.getInstance().isIdUnique(Integer.valueOf(input.getText()));
				if (!result) {
					EditSubjectDialog.getInstance().getEditForm().getSubmitButton().setEnabled(false);
					JOptionPane.showMessageDialog(null, "Id vec postoji!");
				}
			}
		}
		if(result)
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		else
			input.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
	}

}
