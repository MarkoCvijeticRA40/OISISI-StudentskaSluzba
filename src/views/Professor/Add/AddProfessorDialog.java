package views.Professor.Add;

import javax.swing.JDialog;

import controllers.ProfessorController;
import views.MainFrame;

public class AddProfessorDialog extends JDialog {

	private static final long serialVersionUID = -4074913644390607254L;
	private static AddProfessorDialog dialog;
	
	private final String dialogTitle = "Dodavanje profesora";
	private AddProfessorFormPanel addForm;
	
	private AddProfessorDialog() {
		super();
		this.setTitle(dialogTitle);
		this.setResizable(false);
		this.setModal(true);
		addForm = new AddProfessorFormPanel();
		this.add(addForm);
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}
	
	public static AddProfessorDialog getInstance() {
		if (dialog == null)
			dialog = new AddProfessorDialog();
		return dialog;
	}
	
	public void init() {
		ProfessorController.getInstance().formValidatorSet(false);
		this.addForm.init();
		this.setVisible(true);
	}
	
	public AddProfessorFormPanel getAddForm() {
		return this.addForm;
	}
}
