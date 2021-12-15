package views.Professor.Edit;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import controllers.ProfessorController;
import views.MainFrame;

public class EditProfessorDialog extends JDialog {

	private static final long serialVersionUID = 1566175629434702930L;
	private static EditProfessorDialog dialog;
	
	private final String dialogTitle = "Izmena profesora";
	private EditProfessorFormPanel editForm;
	
	private EditProfessorDialog() {
		super();
		this.setTitle(dialogTitle);
		this.setResizable(false);
		this.setModal(true);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		editForm = new EditProfessorFormPanel();
		tabbedPane.addTab("Informacije", editForm);
		this.add(tabbedPane);
		
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}
	
	public static EditProfessorDialog getInstance() {
		if (dialog == null)
			dialog = new EditProfessorDialog();
		return dialog;
	}
	
	public void init() {
		ProfessorController.getInstance().formValidatorSet(true);
		if (editForm.init())
			this.setVisible(true);
	}
	
	public EditProfessorFormPanel getEditForm() {
		return this.editForm;
	}

}
