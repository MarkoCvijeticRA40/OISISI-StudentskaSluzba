package views.GlavniProzor;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class GlavniProzor extends JFrame {

	public GlavniProzor() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenDimension = kit.getScreenSize();
		setSize(3 * (screenDimension.width / 4), 3 * (screenDimension.height / 4));
		setLocationRelativeTo(null);
		setTitle("Studentska slu�ba");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}