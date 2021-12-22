package views.Student.Edit;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import controllers.ProfessorController;
import views.MainFrame;

public class EditStudentDialog extends JDialog {

	private static final long serialVersionUID = 7257157234335251902L;
	private static EditStudentDialog dialog;
	
	private final String dialogTitle = "Izmena studenta";
	private EditStudentFormPanel editForm;
	
	private EditStudentDialog() {
		super();
		this.setTitle(dialogTitle);
		this.setResizable(false);
		this.setModal(true);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		editForm = new EditStudentFormPanel();
		tabbedPane.addTab("Informacije", editForm);
		this.add(tabbedPane);
		
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}
	
	public static EditStudentDialog getInstance() {
		if (dialog == null)
			dialog = new EditStudentDialog();
		return dialog;
	}
	
	public void init() {
		ProfessorController.getInstance().formValidatorSet(true);
		if (editForm.init())
			this.setVisible(true);
	}
	
	public EditStudentFormPanel getEditForm() {
		return this.editForm;
	}
}
