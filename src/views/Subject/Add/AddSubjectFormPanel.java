package views.Subject.Add;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.SubjectController;
import views.Subject.BaseSubjectFormJPanel;
import views.Subject.listeners.AddSubjectFormFocusListener;
import views.Subject.listeners.AddSubjectFormKeyListener;

public class AddSubjectFormPanel extends BaseSubjectFormJPanel {
	
	private static final long serialVersionUID = -5255830521031429149L;

	public AddSubjectFormPanel() {
		super(new AddSubjectFormFocusListener(), new AddSubjectFormKeyListener());
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel btnPanel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(50);
		btnPanel.setLayout(layout);
		this.submitBtn = new JButton("Potvrdi");
		this.submitBtn.setEnabled(false);
		this.cancelBtn = new JButton("Odustani");
		btnPanel.add(submitBtn, BorderLayout.CENTER);
		btnPanel.add(cancelBtn, BorderLayout.CENTER);
		this.add(btnPanel);
		
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectController.getInstance().add();
			}
			
		});
		
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddSubjectDialog.getInstance().dispose();
			}
			
		});
	}
	
	public void init() {
		resetTextFields();
		this.idTxt.requestFocus();
		this.submitBtn.setEnabled(false);
	}
	
	private void resetTextFields() {
		this.setTextFieldsBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		this.idTxt.setText("");
		this.nameTxt.setText("");
		this.esbpTxt.setText("");
		this.semesterCmb.setSelectedIndex(0);
		this.studyYearCmb.setSelectedIndex(0);
	}

}
