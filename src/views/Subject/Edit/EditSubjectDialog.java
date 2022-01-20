package views.Subject.Edit;

import javax.swing.JDialog;

import controllers.SubjectController;
import views.MainFrame;


public class EditSubjectDialog extends JDialog {

	private static final long serialVersionUID = -8750527800712138388L;
	private static EditSubjectDialog dialog;
	
	private final String dialogTitle = "Izmena predmeta";
	private EditSubjectFormPanel editForm;
	
	private EditSubjectDialog() {
		super();
		this.setTitle(dialogTitle);
		this.setResizable(false);
		this.setModal(true);
		
		editForm = new EditSubjectFormPanel();
		this.add(editForm);
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}

	public static EditSubjectDialog getInstance() {
		if (dialog == null)
			dialog = new EditSubjectDialog();
		return dialog;
	}
	
	public void init() {
		SubjectController.getInstance().formValidatorSet(true);
		if (editForm.init()) {
			this.setVisible(true);
		}
	}
	
	public EditSubjectFormPanel getEditForm() {
		return this.editForm;
	}
}
