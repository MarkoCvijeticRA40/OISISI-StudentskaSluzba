package views.Student.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import controllers.StudentController;
import views.Student.Add.AddStudentDialog;

public class AddStudentFormKeyListener implements KeyListener {

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
			AddStudentDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(true);
		else
			AddStudentDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(false);
	}

}
