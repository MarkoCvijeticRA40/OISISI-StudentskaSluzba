package views.Professor.Edit.Subject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controllers.ProfessorController;
import models.Subject;
import views.Student.Edit.EditStudentDialog;

public class ListSubjectsDialog extends JDialog {

	private static final long serialVersionUID = 571989358345934587L;
	private static ListSubjectsDialog dialog;
	
	@SuppressWarnings("rawtypes")
	private JList list;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ListSubjectsDialog() {
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
		container.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		
		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		labelPanel.add(new JLabel("Predmeti:"));
		container.add(labelPanel);
		
		container.add(Box.createVerticalStrut(5));
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		container.add(scrollPane);
		
		this.add(container, BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		btnPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		JButton confirmBtn = new JButton("Potvrdi");
		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Subject> selectedSubjects = list.getSelectedValuesList();
				ProfessorController.getInstance().addSubjects(selectedSubjects);
				dialog.dispose();
			}
			
		});
		btnPanel.add(confirmBtn);
		
		JButton cancelBtn = new JButton("Odustani");
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
			
		});
		btnPanel.add(cancelBtn);
		
		this.add(btnPanel, BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(EditStudentDialog.getInstance());
	}
	
	public static ListSubjectsDialog getInstance() {
		if (dialog == null)
			dialog = new ListSubjectsDialog();
		return dialog;
	}
	
	@SuppressWarnings("unchecked")
	public void init() {
		Object[] availabelSubjects = ProfessorController.getInstance().getPossibleNewSubjects().toArray();
		if (availabelSubjects.length > 0) {
			this.list.setListData(availabelSubjects);
			this.list.setSelectedIndex(0);
			this.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(dialog, "Nema dostupnih predmeta u sistemu!");
		}
	}

}
