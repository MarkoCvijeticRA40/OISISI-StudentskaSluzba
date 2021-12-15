package views.Professor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BaseProfessorFormJPanel extends JPanel {

	private static final long serialVersionUID = 9054594765895744121L;
	
	protected JTextField firstNameTxt;
	protected JTextField lastNameTxt;
	protected JTextField dateOfBirthTxt;
	protected JTextField addressTxt;
	protected JTextField phoneNumberTxt;
	protected JTextField emailTxt;
	protected JTextField officeAddressTxt;
	protected JTextField idCardNumberTxt;
	protected JTextField titleTxt;
	protected JTextField yearsOfServiceTxt;
	protected JButton submitBtn;
	protected JButton cancelBtn;
	
	protected BaseProfessorFormJPanel(FocusListener listener) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(15, 40, 15, 40));
		
		JPanel firstNamePanel = new JPanel();
		firstNamePanel.setLayout(new BoxLayout(firstNamePanel, BoxLayout.X_AXIS));
		firstNamePanel.add(new JLabel("Ime*"));
		firstNameTxt = createTextField();
		firstNameTxt.setName("firstName");
		firstNameTxt.addFocusListener(listener);
		firstNamePanel.add(Box.createHorizontalStrut(200));
		firstNamePanel.add(firstNameTxt);
		this.add(firstNamePanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel lastNamePanel = new JPanel();
		lastNamePanel.setLayout(new BoxLayout(lastNamePanel, BoxLayout.X_AXIS));
		lastNamePanel.add(new JLabel("Prezime*"));
		lastNameTxt = createTextField();
		lastNameTxt.setName("lastName");
		lastNameTxt.addFocusListener(listener);
		lastNamePanel.add(Box.createHorizontalGlue());
		lastNamePanel.add(lastNameTxt);
		this.add(lastNamePanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel dateOfBirthPanel = new JPanel();
		dateOfBirthPanel.setLayout(new BoxLayout(dateOfBirthPanel, BoxLayout.X_AXIS));
		dateOfBirthPanel.add(new JLabel("Datum rođenja*"));
		dateOfBirthTxt = createTextField();
		dateOfBirthTxt.setName("dateOfBirth");
		dateOfBirthTxt.addFocusListener(listener);
		dateOfBirthPanel.add(Box.createHorizontalGlue());
		dateOfBirthPanel.add(dateOfBirthTxt);
		this.add(dateOfBirthPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel addressPanel = new JPanel();
		addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.X_AXIS));
		addressPanel.add(new JLabel("Adresa stanovanja*"));
		addressTxt = createTextField();
		addressTxt.setName("address");
		addressTxt.addFocusListener(listener);
		addressPanel.add(Box.createHorizontalGlue());
		addressPanel.add(addressTxt);
		this.add(addressPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel phoneNumberPanel = new JPanel();
		phoneNumberPanel.setLayout(new BoxLayout(phoneNumberPanel, BoxLayout.X_AXIS));
		phoneNumberPanel.add(new JLabel("Broj telefona*"));
		phoneNumberTxt = createTextField();
		phoneNumberTxt.setName("phoneNumber");
		phoneNumberTxt.addFocusListener(listener);
		phoneNumberPanel.add(Box.createHorizontalGlue());
		phoneNumberPanel.add(phoneNumberTxt);
		this.add(phoneNumberPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
		emailPanel.add(new JLabel("Email*"));
		emailTxt = createTextField();
		emailTxt.setName("email");
		emailTxt.addFocusListener(listener);
		emailPanel.add(Box.createHorizontalGlue());
		emailPanel.add(emailTxt);
		this.add(emailPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel officeAddressPanel = new JPanel();
		officeAddressPanel.setLayout(new BoxLayout(officeAddressPanel, BoxLayout.X_AXIS));
		officeAddressPanel.add(new JLabel("Adresa kancelarije*"));
		officeAddressTxt = createTextField();
		officeAddressTxt.setName("officeAddress");
		officeAddressTxt.addFocusListener(listener);
		officeAddressPanel.add(Box.createHorizontalGlue());
		officeAddressPanel.add(officeAddressTxt);
		this.add(officeAddressPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel idCardNumberPanel = new JPanel();
		idCardNumberPanel.setLayout(new BoxLayout(idCardNumberPanel, BoxLayout.X_AXIS));
		idCardNumberPanel.add(new JLabel("Broj lične karte*"));
		idCardNumberTxt = createTextField();
		idCardNumberTxt.setName("idCardNumber");
		idCardNumberTxt.addFocusListener(listener);
		idCardNumberPanel.add(Box.createHorizontalGlue());
		idCardNumberPanel.add(idCardNumberTxt);
		this.add(idCardNumberPanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		titlePanel.add(new JLabel("Zvanje*"));
		titleTxt = createTextField();
		titleTxt.setName("title");
		titleTxt.addFocusListener(listener);
		titlePanel.add(Box.createHorizontalGlue());
		titlePanel.add(titleTxt);
		this.add(titlePanel);
		
		this.add(Box.createVerticalStrut(10));
		
		JPanel yearsOfServicePanel = new JPanel();
		yearsOfServicePanel.setLayout(new BoxLayout(yearsOfServicePanel, BoxLayout.X_AXIS));
		yearsOfServicePanel.add(new JLabel("Staž*"));
		yearsOfServiceTxt = createTextField();
		yearsOfServiceTxt.setName("yearsOfService");
		yearsOfServiceTxt.addFocusListener(listener);
		yearsOfServicePanel.add(Box.createHorizontalGlue());
		yearsOfServicePanel.add(yearsOfServiceTxt);
		this.add(yearsOfServicePanel);
		
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
		this.addressTxt.setBorder(border);
		this.phoneNumberTxt.setBorder(border);
		this.emailTxt.setBorder(border);
		this.officeAddressTxt.setBorder(border);
		this.idCardNumberTxt.setBorder(border);
		this.titleTxt.setBorder(border);
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

	public JTextField getAddressTxt() {
		return addressTxt;
	}

	public JTextField getPhoneNumberTxt() {
		return phoneNumberTxt;
	}

	public JTextField getEmailTxt() {
		return emailTxt;
	}

	public JTextField getOfficeAddressTxt() {
		return officeAddressTxt;
	}

	public JTextField getIdCardNumberTxt() {
		return idCardNumberTxt;
	}

	public JTextField getTitleTxt() {
		return titleTxt;
	}

	public JTextField getYearsOfServiceTxt() {
		return yearsOfServiceTxt;
	}
	
	public JButton getSubmitBtn() {
		return this.submitBtn;
	}
}
