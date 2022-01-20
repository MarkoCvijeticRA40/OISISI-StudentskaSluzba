package views.Subject;

import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import models.Semester;

public class BaseSubjectFormJPanel extends JPanel {

	private static final long serialVersionUID = -3408652983104600024L;
	
	protected JTextField idTxt;
	protected JTextField nameTxt;
	protected JComboBox<Semester> semesterCmb;
	protected JTextField esbpTxt;
	protected JComboBox<Integer> studyYearCmb;
	protected JButton submitBtn;
	protected JButton cancelBtn;

	protected BaseSubjectFormJPanel(FocusListener focusListener, KeyListener keyListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.X_AXIS));
		idPanel.add(new JLabel("Id*"));
		idTxt = createTextField();
		idTxt.setName("id");
		idTxt.addFocusListener(focusListener);
		idTxt.addKeyListener(keyListener);
		idPanel.add(Box.createHorizontalGlue());
		idPanel.add(idTxt);
		this.add(idPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
		namePanel.add(new JLabel("Naziv*"));
		nameTxt = createTextField();
		nameTxt.setName("name");
		nameTxt.addFocusListener(focusListener);
		nameTxt.addKeyListener(keyListener);
		namePanel.add(Box.createHorizontalGlue());
		namePanel.add(nameTxt);
		this.add(namePanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel semesterPanel = new JPanel();
		semesterPanel.setLayout(new BoxLayout(semesterPanel, BoxLayout.X_AXIS));
		semesterPanel.add(new JLabel("Semestar*"));
		semesterCmb = new JComboBox<Semester>(Semester.values());
		semesterCmb.setPreferredSize(new Dimension(250, 25));
		semesterCmb.setMaximumSize(new Dimension(250, 25));
		semesterPanel.add(Box.createHorizontalGlue());
		semesterPanel.add(semesterCmb);
		this.add(semesterPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel esbpPanel = new JPanel();
		esbpPanel.setLayout(new BoxLayout(esbpPanel, BoxLayout.X_AXIS));
		esbpPanel.add(new JLabel("ESBP*"));
		esbpTxt = createTextField();
		esbpTxt.setName("esbp");
		esbpTxt.addFocusListener(focusListener);
		esbpTxt.addKeyListener(keyListener);
		esbpPanel.add(Box.createHorizontalGlue());
		esbpPanel.add(esbpTxt);
		this.add(esbpPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel studyYearPanel = new JPanel();
		studyYearPanel.setLayout(new BoxLayout(studyYearPanel, BoxLayout.X_AXIS));
		studyYearPanel.add(new JLabel("Godina studija*"));
		Integer[] studyYears = new Integer[] {1, 2, 3, 4};
		studyYearCmb = new JComboBox<Integer>(studyYears);
		studyYearCmb.setPreferredSize(new Dimension(250, 25));
		studyYearCmb.setMaximumSize(new Dimension(250, 25));
		studyYearPanel.add(Box.createHorizontalGlue());
		studyYearPanel.add(Box.createHorizontalStrut(20));
		studyYearPanel.add(studyYearCmb);
		this.add(studyYearPanel);
	}
	
	protected void setTextFieldsBorder(Border border) {
		this.nameTxt.setBorder(border);
		this.idTxt.setBorder(border);
		this.esbpTxt.setBorder(border);
	}
	
	protected JTextField createTextField() {
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(250, 25));
		input.setMaximumSize(new Dimension(250, 25));
		return input;
	}

	public JTextField getIdTxt() {
		return idTxt;
	}

	public JTextField getNameTxt() {
		return nameTxt;
	}

	public JComboBox<Semester> getSemesterCmb() {
		return semesterCmb;
	}
	
	public JComboBox<Integer> getStudyYearCmb() {
		return studyYearCmb;
	}

	public JTextField getEsbpTxt() {
		return esbpTxt;
	}
	
	public JButton getSubmitButton() {
		return submitBtn;
	}
	
}
