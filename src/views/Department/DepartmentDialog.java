package views.Department;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.Department;
import models.Professor;
import models.Title;
import persistence.Database;
import views.MainFrame;

public class DepartmentDialog extends JDialog {

	private static final long serialVersionUID = 2841005305127215091L;
	private static DepartmentDialog dialog;
	
	private final String dialogTitle = "Katedre";
	private JComboBox<Object> departmetCmb;
	private JComboBox<Object> professorCmb;
	
	private DepartmentDialog() {
		this.setTitle(dialogTitle);
		this.setResizable(false);
		this.setModal(true);
		
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JPanel deparmentPanel = new JPanel();
		deparmentPanel.setLayout(new BoxLayout(deparmentPanel, BoxLayout.X_AXIS));
		deparmentPanel.add(new JLabel("Department"));
		deparmentPanel.add(Box.createHorizontalGlue());
		this.departmetCmb = new JComboBox<>(Database.getInstance().getDepartmentDatabase().getDepartments().toArray());
		this.departmetCmb.setPreferredSize(new Dimension(250, 25));
		this.departmetCmb.setMaximumSize(new Dimension(250, 25));
		
		this.departmetCmb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				populateProfessorCmb();
			}
			
		});
		
		deparmentPanel.add(Box.createHorizontalStrut(20));
		deparmentPanel.add(departmetCmb);
		container.add(deparmentPanel);
		
		container.add(Box.createVerticalStrut(10));
		
		JPanel professorPanel = new JPanel();
		professorPanel.setLayout(new BoxLayout(professorPanel, BoxLayout.X_AXIS));
		professorPanel.add(new JLabel("Sef katedre"));
		professorPanel.add(Box.createHorizontalGlue());
		this.professorCmb = new JComboBox<>();
		this.professorCmb.setPreferredSize(new Dimension(250, 25));
		this.professorCmb.setMaximumSize(new Dimension(250, 25));
		professorPanel.add(professorCmb);
		container.add(professorPanel);
		
		container.add(Box.createVerticalStrut(10));
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton addBtn = new JButton("Izmeni");
		
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Department d = (Department) departmetCmb.getSelectedItem();
				d.setManager((Professor) professorCmb.getSelectedItem());
				JOptionPane.showMessageDialog(null, "Postavljanje sefa katedre uspesno!");
				dialog.dispose();
			}
			
		});
		
		btnPanel.add(addBtn);
		
		JButton cancelBtn = new JButton("Odustani");
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		btnPanel.add(cancelBtn);
		
		container.add(btnPanel);
		
		this.add(container);
		
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
	}
	
	public static DepartmentDialog getInstance() {
		if (dialog == null)
			dialog = new DepartmentDialog();
		return dialog;
	}
	
	public void init() {
		this.departmetCmb.setSelectedIndex(0);
		populateProfessorCmb();
		this.setVisible(true);
	}
	
	private void populateProfessorCmb() {
		this.professorCmb.removeAllItems();
		Department selectedDepartment = (Department) this.departmetCmb.getSelectedItem();
		for (Professor p : selectedDepartment.getProfessors()) {
			if ((p.getTitle() == Title.REDOVNI_PROFESOR || p.getTitle() == Title.VANREDNI_PROFESOR) && p.getYearsOfService() >= 5)
				this.professorCmb.addItem(p);
		}
		this.professorCmb.setSelectedItem(selectedDepartment.getManager());
	}
	
}
