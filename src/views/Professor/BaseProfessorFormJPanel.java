package views.Professor;

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

import models.Title;

public class BaseProfessorFormJPanel extends JPanel {

	private static final long serialVersionUID = 9054594765895744121L;
	
	protected JTextField firstNameTxt;
	protected JTextField lastNameTxt;
	protected JTextField dateOfBirthTxt;
	protected JTextField addressStreetTxt;
	protected JTextField addressHouseNumberTxt;
	protected JTextField addressCityTxt;
	protected JTextField addressCountryTxt;
	protected JTextField phoneNumberTxt;
	protected JTextField emailTxt;
	protected JTextField officeAddressStreetTxt;
	protected JTextField officeAddressHouseNumberTxt;
	protected JTextField officeAddressCityTxt;
	protected JTextField officeAddressCountryTxt;
	protected JTextField idCardNumberTxt;
	protected JTextField yearsOfServiceTxt;
	protected JComboBox<Title> titleCmb;
	protected JButton submitBtn;
	protected JButton cancelBtn;
	
	protected BaseProfessorFormJPanel(FocusListener focusListener, KeyListener keyListener) {
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
		
		JPanel officeAddressStreetPanel = new JPanel();
		officeAddressStreetPanel.setLayout(new BoxLayout(officeAddressStreetPanel, BoxLayout.X_AXIS));
		officeAddressStreetPanel.add(new JLabel("Ulica kancelarije*"));
		officeAddressStreetTxt = createTextField();
		officeAddressStreetTxt.setName("officeAddressStreet");
		officeAddressStreetTxt.addFocusListener(focusListener);
		officeAddressStreetTxt.addKeyListener(keyListener);
		officeAddressStreetPanel.add(Box.createHorizontalGlue());
		officeAddressStreetPanel.add(officeAddressStreetTxt);
		this.add(officeAddressStreetPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel officeAddressHouseNumberPanel = new JPanel();
		officeAddressHouseNumberPanel.setLayout(new BoxLayout(officeAddressHouseNumberPanel, BoxLayout.X_AXIS));
		officeAddressHouseNumberPanel.add(new JLabel("Broj kuće/stana*"));
		officeAddressHouseNumberTxt = createTextField();
		officeAddressHouseNumberTxt.setName("officeAddressHouseNumber");
		officeAddressHouseNumberTxt.addFocusListener(focusListener);
		officeAddressHouseNumberTxt.addKeyListener(keyListener);
		officeAddressHouseNumberPanel.add(Box.createHorizontalGlue());
		officeAddressHouseNumberPanel.add(officeAddressHouseNumberTxt);
		this.add(officeAddressHouseNumberPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel officeAddressCityPanel = new JPanel();
		officeAddressCityPanel.setLayout(new BoxLayout(officeAddressCityPanel, BoxLayout.X_AXIS));
		officeAddressCityPanel.add(new JLabel("Grad*"));
		officeAddressCityTxt = createTextField();
		officeAddressCityTxt.setName("officeAddressCity");
		officeAddressCityTxt.addFocusListener(focusListener);
		officeAddressCityTxt.addKeyListener(keyListener);
		officeAddressCityPanel.add(Box.createHorizontalGlue());
		officeAddressCityPanel.add(officeAddressCityTxt);
		this.add(officeAddressCityPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel officeAddressCountryPanel = new JPanel();
		officeAddressCountryPanel.setLayout(new BoxLayout(officeAddressCountryPanel, BoxLayout.X_AXIS));
		officeAddressCountryPanel.add(new JLabel("Država*"));
		officeAddressCountryTxt = createTextField();
		officeAddressCountryTxt.setName("officeAddressCountry");
		officeAddressCountryTxt.addFocusListener(focusListener);
		officeAddressCountryTxt.addKeyListener(keyListener);
		officeAddressCountryPanel.add(Box.createHorizontalGlue());
		officeAddressCountryPanel.add(officeAddressCountryTxt);
		this.add(officeAddressCountryPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel idCardNumberPanel = new JPanel();
		idCardNumberPanel.setLayout(new BoxLayout(idCardNumberPanel, BoxLayout.X_AXIS));
		idCardNumberPanel.add(new JLabel("Broj lične karte*"));
		idCardNumberTxt = createTextField();
		idCardNumberTxt.setName("idCardNumber");
		idCardNumberTxt.addFocusListener(focusListener);
		idCardNumberTxt.addKeyListener(keyListener);
		idCardNumberPanel.add(Box.createHorizontalGlue());
		idCardNumberPanel.add(idCardNumberTxt);
		this.add(idCardNumberPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel yearsOfServicePanel = new JPanel();
		yearsOfServicePanel.setLayout(new BoxLayout(yearsOfServicePanel, BoxLayout.X_AXIS));
		yearsOfServicePanel.add(new JLabel("Staž*"));
		yearsOfServiceTxt = createTextField();
		yearsOfServiceTxt.setName("yearsOfService");
		yearsOfServiceTxt.addFocusListener(focusListener);
		yearsOfServiceTxt.addKeyListener(keyListener);
		yearsOfServicePanel.add(Box.createHorizontalGlue());
		yearsOfServicePanel.add(yearsOfServiceTxt);
		this.add(yearsOfServicePanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		titlePanel.add(new JLabel("Zvanje*"));
		titleCmb = new JComboBox<Title>(Title.values());
		titleCmb.setPreferredSize(new Dimension(200, 25));
		titleCmb.setMaximumSize(new Dimension(200, 25));
		titlePanel.add(Box.createHorizontalGlue());
		titlePanel.add(titleCmb);
		this.add(titlePanel);
		
		this.add(Box.createVerticalStrut(30));
		
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
		this.officeAddressStreetTxt.setBorder(border);
		this.officeAddressHouseNumberTxt.setBorder(border);
		this.officeAddressCityTxt.setBorder(border);
		this.officeAddressCountryTxt.setBorder(border);
		this.idCardNumberTxt.setBorder(border);
		this.yearsOfServiceTxt.setBorder(border);
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

	public JTextField getPhoneNumberTxt() {
		return phoneNumberTxt;
	}

	public JTextField getEmailTxt() {
		return emailTxt;
	}

	public JTextField getOfficeAddressStreetTxt() {
		return officeAddressStreetTxt;
	}

	public JTextField getIdCardNumberTxt() {
		return idCardNumberTxt;
	}

	public JTextField getYearsOfServiceTxt() {
		return yearsOfServiceTxt;
	}
	
	public JButton getSubmitBtn() {
		return this.submitBtn;
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

	public JTextField getOfficeAddressHouseNumberTxt() {
		return officeAddressHouseNumberTxt;
	}

	public JTextField getOfficeAddressCityTxt() {
		return officeAddressCityTxt;
	}

	public JTextField getOfficeAddressCountryTxt() {
		return officeAddressCountryTxt;
	}
	
	public JComboBox<Title> getTitleCmb() {
		return this.titleCmb;
	}
}
