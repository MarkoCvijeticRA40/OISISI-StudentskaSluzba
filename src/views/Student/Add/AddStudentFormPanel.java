package views.Student.Add;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import controllers.StudentController;
import views.Student.BaseStudentFormJPanel;
import views.Student.listeners.AddStudentFocusListener;

public class AddStudentFormPanel extends BaseStudentFormJPanel{

	private static final long serialVersionUID = 729883046410324169L;
	
	public AddStudentFormPanel () {
		super(new AddStudentFocusListener());
		
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentController.getInstance().add();
			}
			
		});
		
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddStudentDialog.getInstance().dispose();
			}
			
		});
	}
	
	public void init() {
		resetTextFields();
		this.firstNameTxt.requestFocus();
		this.submitBtn.setEnabled(false);
	}
	
	private void resetTextFields() {
		this.setTextFieldsBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		this.firstNameTxt.setText("");
		this.lastNameTxt.setText("");
		this.dateOfBirthTxt.setText("31/01/2000");
		this.addressStreetTxt.setText("");
		this.addressHouseNumberTxt.setText("");
		this.addressCityTxt.setText("");
		this.addressCountryTxt.setText("");
		this.phoneNumberTxt.setText("");
		this.emailTxt.setText("");
		this.indexNumberTxt.setText("");
		this.enrollmentYearTxt.setText("");
		this.currentStudiesYearCmb.setSelectedIndex(0);
		this.financingStatusCmb.setSelectedIndex(0);
	}
}
