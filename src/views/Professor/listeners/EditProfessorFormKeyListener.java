package views.Professor.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import controllers.ProfessorController;
import views.Professor.Edit.EditProfessorDialog;

public class EditProfessorFormKeyListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		JTextField input = (JTextField) e.getComponent();
		ProfessorController.getInstance().inputFieldCheck(input);
		if (ProfessorController.getInstance().inputFieldsValidationState())
			EditProfessorDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(true);
		else
			EditProfessorDialog.getInstance().getEditForm().getSubmitBtn().setEnabled(false);
	}

}
