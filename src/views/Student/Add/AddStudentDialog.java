package views.Student.Add;

import javax.swing.JDialog;

import controllers.StudentController;
import views.MainFrame;

public class AddStudentDialog extends JDialog {

	private static final long serialVersionUID = -6366567364136282572L;
	private static AddStudentDialog dialog;
	
	private final String dialogTitle = "Dodavanje studenta";
	private AddStudentFormPanel addForm;
	
	private AddStudentDialog() {
		super();
		this.setTitle(dialogTitle);
		this.setResizable(false);
		this.setModal(true);
		addForm = new AddStudentFormPanel();
		this.add(addForm);
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}
	
	public static AddStudentDialog getInstance() {
		if (dialog == null)
			dialog = new AddStudentDialog();
		return dialog;
	}
	
	public void init() {
		StudentController.getInstance().formValidatorSet(false);
		this.addForm.init();
		this.setVisible(true);
	}
	
	public AddStudentFormPanel getAddForm() {
		return this.addForm;
	}
}
