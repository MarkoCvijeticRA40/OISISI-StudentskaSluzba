package views.Student.Edit.Exams.NotPassed;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.StudentController;
import controllers.validators.ValidationPatterns;
import models.Subject;
import views.Student.Edit.EditStudentDialog;

public class AddPassedExamDialog extends JDialog {

	private static final long serialVersionUID = 4074887124535108443L;
	private static AddPassedExamDialog dialog;
	
	private JTextField idTxt;
	private JTextField nameTxt;
	private JComboBox<Integer> gradeCmb;
	private JTextField dateTxt;
	private JButton submitBtn;
	private JButton cancelBtn;

	private AddPassedExamDialog() {
		this.setTitle("Unos ocene");
		this.setResizable(false);
		this.setModal(true);
		
		JPanel container = new JPanel();
		BoxLayout box = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(box);
		container.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
		idPanel.add(new JLabel("Sifra*"));
		idTxt = createTextField();
		idTxt.setEditable(false);
		idPanel.add(Box.createHorizontalGlue());
		idPanel.add(idTxt);
		container.add(idPanel);
		
		container.add(Box.createVerticalStrut(20));
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		namePanel.add(new JLabel("Naziv*"));
		nameTxt = createTextField();
		nameTxt.setEditable(false);
		namePanel.add(Box.createHorizontalGlue());
		namePanel.add(nameTxt);
		container.add(namePanel);
		
		container.add(Box.createVerticalStrut(20));
		
		JPanel gradePanel = new JPanel();
		gradePanel.setLayout(new BoxLayout(gradePanel, BoxLayout.X_AXIS));
		gradePanel.add(new JLabel("Ocena*"));
		Integer[] grades = new Integer[] {6, 7, 8, 9, 10};
		gradeCmb = new JComboBox<Integer>(grades);
		gradeCmb.setPreferredSize(new Dimension(100, 25));
		gradeCmb.setMaximumSize(new Dimension(100, 25));
		gradePanel.add(Box.createHorizontalGlue());
		gradePanel.add(gradeCmb);
		container.add(gradePanel);
		
		container.add(Box.createVerticalStrut(20));
		
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.X_AXIS));
		datePanel.add(new JLabel("Datum*"));
		dateTxt = createTextField();
		dateTxt.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					ValidationPatterns.dateFormat.parse(dateTxt.getText());
					submitBtn.setEnabled(true);
				} catch (ParseException e1) {
					submitBtn.setEnabled(false);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			
		});
		datePanel.add(Box.createHorizontalGlue());
		datePanel.add(dateTxt);
		container.add(datePanel);
		
		container.add(Box.createVerticalStrut(20));
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		submitBtn = new JButton("Potvrdi");
		submitBtn.setEnabled(false);
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"Da li ste sigurni da zelite da upiste ocenu?", 
						"Upis ocene", 
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					StudentController.getInstance().addPassedExam();
					EditStudentDialog.getInstance().getPassedExamesPanel().updateView();
					dialog.dispose();
				}
			}
			
		});
		
		cancelBtn = new JButton("Odustani");
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		btnPanel.add(submitBtn);
		btnPanel.add(cancelBtn);
		container.add(btnPanel);
		
		this.add(container);
		
		this.pack();
		this.setLocationRelativeTo(EditStudentDialog.getInstance());
	}
	
	public static AddPassedExamDialog getInstance() {
		if (dialog == null)
			dialog = new AddPassedExamDialog();
		return dialog;
	}
	
	public void init() {
		Subject subject = StudentController.getInstance().getSelectedNotPassedExam();
		this.idTxt.setText(String.valueOf(subject.getId()));
		this.nameTxt.setText(subject.getName());
		this.dateTxt.setText(ValidationPatterns.dateFormat.toPattern());
		this.setVisible(true);
	}
	
	private JTextField createTextField() {
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(100, 25));
		input.setMaximumSize(new Dimension(100, 25));
		return input;
	}
	
	public int getSelectedGrade() {
		return (int) gradeCmb.getSelectedItem();
	}
	
	public Date getSelectedDate() {
		try {
			return ValidationPatterns.dateFormat.parse(dateTxt.getText());
		} catch (ParseException e) {
			return null;
		}
	}
	
}
