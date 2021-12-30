package views.Professor.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import controllers.ProfessorController;
import views.Professor.Add.AddProfessorDialog;

public class AddProfessorFormKeyListener implements KeyListener {

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
			AddProfessorDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(true);
		else
			AddProfessorDialog.getInstance().getAddForm().getSubmitBtn().setEnabled(false);
	}

}
