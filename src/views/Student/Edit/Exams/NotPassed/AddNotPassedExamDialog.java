package views.Student.Edit.Exams.NotPassed;

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

import controllers.StudentController;
import models.Subject;
import views.Student.Edit.EditStudentDialog;

public class AddNotPassedExamDialog extends JDialog {

	private static final long serialVersionUID = 3000656877878384922L;
	private static AddNotPassedExamDialog dialog;
	
	@SuppressWarnings("rawtypes")
	private JList list;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private AddNotPassedExamDialog() {
		this.setTitle("Dodavanje predmet");
		this.setResizable(false);
		this.setModal(true);
		
		list = new JList();
		list.setCellRenderer(new DefaultListCellRenderer() {

			private static final long serialVersionUID = -4600806215264076585L;
			
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			    String name = String.valueOf(((Subject) value).getId()) + " - " + ((Subject) value).getName();
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
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"Da li ste sigurni da zelite da dodate predmet studentu?", 
						"Dodavanje predmeta", 
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Subject selectedSubject = (Subject) list.getSelectedValue();
					StudentController.getInstance().addNotPassedExam(selectedSubject);
					dialog.dispose();
				}
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
		
		container.add(Box.createVerticalStrut(10));
		container.add(btnPanel);
		
		this.add(container);
		
		this.pack();
		this.setLocationRelativeTo(EditStudentDialog.getInstance());
	}
	
	public static AddNotPassedExamDialog getInstance() {
		if (dialog == null)
			dialog = new AddNotPassedExamDialog();
		return dialog;
	}
	
	@SuppressWarnings("unchecked")
	public void init() {
		Object[] availableSubjects = StudentController.getInstance().getAvailableNewExams().toArray();
		if (availableSubjects.length != 0) {
			this.list.setListData(StudentController.getInstance().getAvailableNewExams().toArray());
			this.list.setSelectedIndex(0);
			this.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(dialog, "Nema dostupnih predmeta za ovog studenta!");
		}
	}

}
