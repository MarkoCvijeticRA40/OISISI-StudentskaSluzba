package views.Subject.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import controllers.SubjectController;
import views.Subject.Edit.EditSubjectDialog;

public class EditSubjectFormKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		JTextField input = (JTextField) e.getComponent();
		SubjectController.getInstance().inputFieldCheck(input);
		if (SubjectController.getInstance().inputFieldsValidationState()) {
			EditSubjectDialog.getInstance().getEditForm().getSubmitButton().setEnabled(true);
		}
		else
			EditSubjectDialog.getInstance().getEditForm().getSubmitButton().setEnabled(false);
	}

}
