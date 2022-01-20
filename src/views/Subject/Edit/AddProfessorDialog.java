package views.Subject.Edit;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controllers.ProfessorController;
import controllers.SubjectController;
import models.Professor;
import models.Subject;

public class AddProfessorDialog extends JDialog {

	private static final long serialVersionUID = -8210857508852111956L;
	private static AddProfessorDialog dialog;
	
	@SuppressWarnings("rawtypes")
	private JList list;
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	private AddProfessorDialog() {
		this.setTitle("Odaberi profesora");
		this.setResizable(false);
		this.setModal(true);
		
		list = new JList();
		list.setCellRenderer(new DefaultListCellRenderer() {

			private static final long serialVersionUID = -4600806215264076585L;
			
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			    String name = ((Professor) value).getFirstName() + " " + ((Professor) value).getLastName();
			    Component c =  super.getListCellRendererComponent(list, name, index, isSelected, cellHasFocus);
			    if (isSelected) {
					c.setBackground(Color.MAGENTA);
				}
				else {
					if (index % 2 == 0)
						c.setBackground(Color.WHITE);
					else
						c.setBackground(Color.LIGHT_GRAY);
				}
				return c;
			}
			
		});
		
		JPanel container = new JPanel();
		BoxLayout box = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(box);
		container.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		container.add(scrollPane);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		JButton addBtn = new JButton("Dodaj");
		btnPanel.add(addBtn);
		
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"Da li ste sigurni da zelite da dodate profesora predmetu?", 
						"Dodavanje profesora", 
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Professor selectedProfessor = (Professor) list.getSelectedValue(); 
					SubjectController.getInstance().addProfessor(selectedProfessor);
				}
			}
			
		});
		
		JButton cancelBtn = new JButton("Odustani");
		btnPanel.add(cancelBtn);
		
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		
		container.add(Box.createVerticalStrut(10));
		container.add(btnPanel);
		
		this.add(container);
		
		this.pack();
		this.setLocationRelativeTo(EditSubjectDialog.getInstance());
	}

	public static AddProfessorDialog getInstance() {
		if (dialog == null)
			dialog = new AddProfessorDialog();
		return dialog;
	}
	
	@SuppressWarnings("unchecked")
	public void init() {
		Subject selectedSubject = SubjectController.getInstance().getSelectedSubject();
		Object[] availableProfessors = ProfessorController.getInstance().getProfessorsBySubject(selectedSubject.getId()).toArray();
		if (availableProfessors.length !=0) {
			this.list.setListData(availableProfessors);
			this.list.setSelectedIndex(0);
			this.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(dialog, "Nema dostupnih profesora za ovoj predmet!");
		}
	}
}
