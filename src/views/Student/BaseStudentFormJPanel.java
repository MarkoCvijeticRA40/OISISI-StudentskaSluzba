package views.Student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import models.Status;

public class BaseStudentFormJPanel extends JPanel{

	private static final long serialVersionUID = 2087655834229249829L;
	
	protected JTextField firstNameTxt;
	protected JTextField lastNameTxt;
	protected JTextField dateOfBirthTxt;
	protected JTextField addressStreetTxt;
	protected JTextField addressHouseNumberTxt;
	protected JTextField addressCityTxt;
	protected JTextField addressCountryTxt;
	protected JTextField phoneNumberTxt;
	protected JTextField emailTxt;
	protected JTextField indexNumberTxt;
	protected JTextField enrollmentYearTxt;
	protected JComboBox<Integer> currentStudiesYearCmb;
	protected JComboBox<Status> financingStatusCmb;
	protected JButton submitBtn;
	protected JButton cancelBtn;
	
	protected BaseStudentFormJPanel(FocusListener focusListener, KeyListener keyListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));
	
		JPanel firstNamePanel = new JPanel();
		firstNamePanel.setLayout(new BoxLayout(firstNamePanel, BoxLayout.X_AXIS));
		firstNamePanel.add(new JLabel("Ime*"));
		firstNameTxt = createTextField();
		firstNameTxt.setName("firstName");
		firstNameTxt.addFocusListener(focusListener);
		firstNameTxt.addKeyListener(keyListener);
		firstNamePanel.add(Box.createHorizontalStrut(200));
		firstNamePanel.add(firstNameTxt);
		this.add(firstNamePanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel lastNamePanel = new JPanel();
		lastNamePanel.setLayout(new BoxLayout(lastNamePanel, BoxLayout.X_AXIS));
		lastNamePanel.add(new JLabel("Prezime*"));
		lastNameTxt = createTextField();
		lastNameTxt.setName("lastName");
		lastNameTxt.addFocusListener(focusListener);
		lastNameTxt.addKeyListener(keyListener);
		lastNamePanel.add(Box.createHorizontalGlue());
		lastNamePanel.add(lastNameTxt);
		this.add(lastNamePanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel dateOfBirthPanel = new JPanel();
		dateOfBirthPanel.setLayout(new BoxLayout(dateOfBirthPanel, BoxLayout.X_AXIS));
		dateOfBirthPanel.add(new JLabel("Datum rođenja*"));
		dateOfBirthTxt = createTextField();
		dateOfBirthTxt.setName("dateOfBirth");
		dateOfBirthTxt.addFocusListener(focusListener);
		dateOfBirthTxt.addKeyListener(keyListener);
		dateOfBirthPanel.add(Box.createHorizontalGlue());
		dateOfBirthPanel.add(dateOfBirthTxt);
		this.add(dateOfBirthPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel addressStreetPanel = new JPanel();
		addressStreetPanel.setLayout(new BoxLayout(addressStreetPanel, BoxLayout.X_AXIS));
		addressStreetPanel.add(new JLabel("Ulica*"));
		addressStreetTxt = createTextField();
		addressStreetTxt.setName("addressStreet");
		addressStreetTxt.addFocusListener(focusListener);
		addressStreetTxt.addKeyListener(keyListener);
		addressStreetPanel.add(Box.createHorizontalGlue());
		addressStreetPanel.add(addressStreetTxt);
		this.add(addressStreetPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel addressHouseNumberPanel = new JPanel();
		addressHouseNumberPanel.setLayout(new BoxLayout(addressHouseNumberPanel, BoxLayout.X_AXIS));
		addressHouseNumberPanel.add(new JLabel("Broj kuće/stana*"));
		addressHouseNumberTxt = createTextField();
		addressHouseNumberTxt.setName("addressHouseNumber");
		addressHouseNumberTxt.addFocusListener(focusListener);
		addressHouseNumberTxt.addKeyListener(keyListener);
		addressHouseNumberPanel.add(Box.createHorizontalGlue());
		addressHouseNumberPanel.add(addressHouseNumberTxt);
		this.add(addressHouseNumberPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel addressCityPanel = new JPanel();
		addressCityPanel.setLayout(new BoxLayout(addressCityPanel, BoxLayout.X_AXIS));
		addressCityPanel.add(new JLabel("Grad*"));
		addressCityTxt = createTextField();
		addressCityTxt.setName("addressCity");
		addressCityTxt.addFocusListener(focusListener);
		addressCityTxt.addKeyListener(keyListener);
		addressCityPanel.add(Box.createHorizontalGlue());
		addressCityPanel.add(addressCityTxt);
		this.add(addressCityPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel addressCountryPanel = new JPanel();
		addressCountryPanel.setLayout(new BoxLayout(addressCountryPanel, BoxLayout.X_AXIS));
		addressCountryPanel.add(new JLabel("Država*"));
		addressCountryTxt = createTextField();
		addressCountryTxt.setName("addressCountry");
		addressCountryTxt.addFocusListener(focusListener);
		addressCountryTxt.addKeyListener(keyListener);
		addressCountryPanel.add(Box.createHorizontalGlue());
		addressCountryPanel.add(addressCountryTxt);
		this.add(addressCountryPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel phoneNumberPanel = new JPanel();
		phoneNumberPanel.setLayout(new BoxLayout(phoneNumberPanel, BoxLayout.X_AXIS));
		phoneNumberPanel.add(new JLabel("Broj telefona*"));
		phoneNumberTxt = createTextField();
		phoneNumberTxt.setName("phoneNumber");
		phoneNumberTxt.addFocusListener(focusListener);
		phoneNumberTxt.addKeyListener(keyListener);
		phoneNumberPanel.add(Box.createHorizontalGlue());
		phoneNumberPanel.add(phoneNumberTxt);
		this.add(phoneNumberPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
		emailPanel.add(new JLabel("Email*"));
		emailTxt = createTextField();
		emailTxt.setName("email");
		emailTxt.addFocusListener(focusListener);
		emailTxt.addKeyListener(keyListener);
		emailPanel.add(Box.createHorizontalGlue());
		emailPanel.add(emailTxt);
		this.add(emailPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel indexNumberPanel = new JPanel();
		indexNumberPanel.setLayout(new BoxLayout(indexNumberPanel, BoxLayout.X_AXIS));
		indexNumberPanel.add(new JLabel("Broj indeksa*"));
		indexNumberTxt = createTextField();
		indexNumberTxt.setName("indexNumber");
		indexNumberTxt.addFocusListener(focusListener);
		indexNumberTxt.addKeyListener(keyListener);
		indexNumberPanel.add(Box.createHorizontalGlue());
		indexNumberPanel.add(indexNumberTxt);
		this.add(indexNumberPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel enrollmentYearPanel = new JPanel();
		enrollmentYearPanel.setLayout(new BoxLayout(enrollmentYearPanel, BoxLayout.X_AXIS));
		enrollmentYearPanel.add(new JLabel("Godina upisa*"));
		enrollmentYearTxt = createTextField();
		enrollmentYearTxt.setName("enrollmentYear");
		enrollmentYearTxt.addFocusListener(focusListener);
		enrollmentYearTxt.addKeyListener(keyListener);
		enrollmentYearPanel.add(Box.createHorizontalGlue());
		enrollmentYearPanel.add(enrollmentYearTxt);
		this.add(enrollmentYearPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel currentStudiesYearPanel = new JPanel();
		currentStudiesYearPanel.setLayout(new BoxLayout(currentStudiesYearPanel, BoxLayout.X_AXIS));
		currentStudiesYearPanel.add(new JLabel("Trenutna godina studija*"));
		Integer[] studyYears = new Integer[] {1, 2, 3, 4};
		currentStudiesYearCmb = new JComboBox<Integer>(studyYears);
		currentStudiesYearCmb.setPreferredSize(new Dimension(200, 25));
		currentStudiesYearCmb.setMaximumSize(new Dimension(200, 25));
		currentStudiesYearPanel.add(Box.createHorizontalGlue());
		currentStudiesYearPanel.add(currentStudiesYearCmb);
		this.add(currentStudiesYearPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel financingStatusPanel = new JPanel();
		financingStatusPanel.setLayout(new BoxLayout(financingStatusPanel, BoxLayout.X_AXIS));
		financingStatusPanel.add(new JLabel("Način finansiranja*"));
		financingStatusCmb = new JComboBox<Status>(Status.values());
		financingStatusCmb.setPreferredSize(new Dimension(200, 25));
		financingStatusCmb.setMaximumSize(new Dimension(200, 25));
		financingStatusPanel.add(Box.createHorizontalGlue());
		financingStatusPanel.add(financingStatusCmb);
		this.add(financingStatusPanel);
		
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
	}
	
	protected void setTextFieldsBorder(Border border) {
		this.firstNameTxt.setBorder(border);
		this.lastNameTxt.setBorder(border);
		this.dateOfBirthTxt.setBorder(border);
		this.addressStreetTxt.setBorder(border);
		this.addressHouseNumberTxt.setBorder(border);
		this.addressCityTxt.setBorder(border);
		this.addressCountryTxt.setBorder(border);
		this.phoneNumberTxt.setBorder(border);
		this.emailTxt.setBorder(border);
		this.indexNumberTxt.setBorder(border);
		this.enrollmentYearTxt.setBorder(border);
	}
	
	private JTextField createTextField() {
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200, 25));
		input.setMaximumSize(new Dimension(200, 25));
		return input;
	}

	public JTextField getFirstNameTxt() {
		return firstNameTxt;
	}

	public JTextField getLastNameTxt() {
		return lastNameTxt;
	}

	public JTextField getDateOfBirthTxt() {
		return dateOfBirthTxt;
	}

	public JTextField getAddressStreetTxt() {
		return addressStreetTxt;
	}

	public JTextField getAddressHouseNumberTxt() {
		return addressHouseNumberTxt;
	}

	public JTextField getAddressCityTxt() {
		return addressCityTxt;
	}

	public JTextField getAddressCountryTxt() {
		return addressCountryTxt;
	}

	public JTextField getPhoneNumberTxt() {
		return phoneNumberTxt;
	}

	public JTextField getEmailTxt() {
		return emailTxt;
	}

	public JTextField getIndexNumberTxt() {
		return indexNumberTxt;
	}

	public JTextField getEnrollmentYearTxt() {
		return enrollmentYearTxt;
	}

	public JComboBox<Integer> getCurrentStudiesYearCmb() {
		return currentStudiesYearCmb;
	}

	public JComboBox<Status> getFinancingStatusCmb() {
		return financingStatusCmb;
	}

	public JButton getSubmitBtn() {
		return submitBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}
}
