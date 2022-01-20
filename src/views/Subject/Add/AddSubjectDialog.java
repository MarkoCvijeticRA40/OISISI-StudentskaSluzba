package views.Subject.Add;

import javax.swing.JDialog;

import controllers.SubjectController;
import views.MainFrame;

public class AddSubjectDialog extends JDialog {

	private static final long serialVersionUID = 1746158870166193056L;
	private static AddSubjectDialog dialog;
	
	private final String dialogTitle = "Dodavanje predmeta";
	private AddSubjectFormPanel addForm;
	
	private AddSubjectDialog() {
		super();
		this.setTitle(dialogTitle);
		this.setResizable(false);
		this.setModal(true);
		this.addForm = new AddSubjectFormPanel();
		this.add(addForm);
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}
	
	public static AddSubjectDialog getInstance() {
		if (dialog == null)
			dialog = new AddSubjectDialog();
		return dialog;
	}

	public void init() {
		SubjectController.getInstance().formValidatorSet(false);
		this.addForm.init();
		this.setVisible(true);
	}
	
	public AddSubjectFormPanel getAddForm() {
		return this.addForm;
	}
	
}
