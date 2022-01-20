package views.Subject.Edit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import controllers.SubjectController;
import models.Subject;
import views.Subject.BaseSubjectFormJPanel;
import views.Subject.listeners.EditSubjectFormFocusListener;
import views.Subject.listeners.EditSubjectFormKeyListener;

public class EditSubjectFormPanel extends BaseSubjectFormJPanel {
	
	private static final long serialVersionUID = 6001948153229635000L;
	
	private int currentId;

	public EditSubjectFormPanel() {
		super(new EditSubjectFormFocusListener(), new EditSubjectFormKeyListener());
		
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectController.getInstance().edit();
			}
			
		});
		
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditSubjectDialog.getInstance().dispose();
			}
			
		});
	}
	
	public boolean init() {
		Subject subject = SubjectController.getInstance().getSelectedSubject();
		if (subject == null)
			return false;
		this.currentId = subject.getId();
		this.setTextFields(subject);
		this.idTxt.requestFocus();
		this.submitBtn.setEnabled(true);
		return true;
	}
	
	private void setTextFields(Subject subject) {
		this.setTextFieldsBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		this.idTxt.setText(String.valueOf(subject.getId()));
		this.nameTxt.setText(subject.getName());
		this.esbpTxt.setText(String.valueOf(subject.getEspb()));
		this.semesterCmb.setSelectedItem(subject.getSemester());
		this.studyYearCmb.setSelectedItem(subject.getStudyYear());
	}
	
	public int getCurrentId() {
		return this.currentId;
	}

}
