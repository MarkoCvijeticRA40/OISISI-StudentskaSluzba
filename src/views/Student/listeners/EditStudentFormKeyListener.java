package views.Student.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import controllers.StudentController;
import views.Student.Edit.EditStudentDialog;

public class EditStudentFormKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		JTextField input = (JTextField) e.getComponent();
		StudentController.getInstance().inputFieldCheck(input);
		if (StudentController.getInstance().inputFieldsValidationState())
			EditStudentDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(true);
		else
			EditStudentDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(false);
	}

}
