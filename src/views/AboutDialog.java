package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog {

	private static final long serialVersionUID = -2998222663327944960L;
	private static AboutDialog dialog;
	
	private AboutDialog() {
		this.setTitle("About");
		this.setModal(true);
		
		JPanel container = new JPanel();
		container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea txt1 = new JTextArea(
				"Studentska sluzba verzija 1.\n"
				+ "Aplikacija ja namenjena za rad sa studentima, profesorima i predmetima."
				);
		txt1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		txt1.setEnabled(false);
		container.add(txt1);
		
		container.add(Box.createVerticalStrut(10));
		
		JTextArea txt2 = new JTextArea(
				"Autori:\n"
				+ "Rapic Marko RA42/2019\n"
				+ "Cvijetic Marko RA40/2019"
				);
		txt2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		txt2.setEnabled(false);
		container.add(txt2);
		
		this.add(container);
		this.pack();
		this.setLocationRelativeTo(MainFrame.getInstance());
		this.setVisible(true);
	}
	
	public static AboutDialog getInstance() {
		if (dialog == null)
			dialog = new AboutDialog();
		return dialog;
	}
}
