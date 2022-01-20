package views.Subject.Edit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.SubjectController;
import models.Subject;
import views.Subject.BaseSubjectFormJPanel;
import views.Subject.listeners.EditSubjectFormFocusListener;
import views.Subject.listeners.EditSubjectFormKeyListener;

public class EditSubjectFormPanel extends BaseSubjectFormJPanel {
	
	private static final long serialVersionUID = 6001948153229635000L;
	
	private int currentId;
	private JTextField professorTxt;
	private JButton addBtn;
	private JButton deleteBtn;

	public EditSubjectFormPanel() {
		super(new EditSubjectFormFocusListener(), new EditSubjectFormKeyListener());
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel professorPanel = new JPanel();
		professorPanel.setLayout(new BoxLayout(professorPanel, BoxLayout.X_AXIS));
		professorPanel.add(new JLabel("Profesor*"));
		this.professorTxt = new JTextField();
		this.professorTxt.setEditable(false);
		professorPanel.add(Box.createHorizontalGlue());
		professorPanel.add(this.professorTxt);
		this.addBtn = new JButton("+");

		this.professorTxt.setPreferredSize(new Dimension(255 - 2*5 - 2*this.addBtn.getMaximumSize().width, 25));
		this.professorTxt.setMaximumSize(new Dimension(255 - 2*5 - 2*this.addBtn.getMaximumSize().width, 25));
		
		professorPanel.add(Box.createHorizontalStrut(5));
		professorPanel.add(addBtn);
		this.deleteBtn = new JButton("-");
		professorPanel.add(Box.createHorizontalStrut(5));
		professorPanel.add(deleteBtn);
		this.add(professorPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel btnPanel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(50);
		btnPanel.setLayout(layout);
		submitBtn = new JButton("Potvrdi");
		submitBtn.setEnabled(false);
		
		cancelBtn = new JButton("Odustani");
		btnPanel.add(submitBtn, BorderLayout.CENTER);
		btnPanel.add(cancelBtn, BorderLayout.CENTER);
		this.add(btnPanel);
		
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
		
		this.addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddProfessorDialog.getInstance().init();
			}
			
		});
		
		this.deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"Da li ste sigurni?", 
						"Ukloni profesora", 
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					SubjectController.getInstance().deleteProfessor();
				}
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
		if (subject.getProfessor() != null) {
			this.professorTxt.setText(subject.getProfessor().getFirstName() + " " + subject.getProfessor().getLastName());
			this.addBtn.setEnabled(false);
			this.deleteBtn.setEnabled(true);
		}
		else {
			this.addBtn.setEnabled(true);
			this.deleteBtn.setEnabled(false);
			this.professorTxt.setText("");
		}
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
	
	public JButton getAddBtn() {
		return this.addBtn;
	}
	
	public JButton getDeleteBtn() {
		return this.deleteBtn;
	}

}
