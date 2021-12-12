package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	public MainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenDimension = kit.getScreenSize();
		setSize(3 * (screenDimension.width / 4), 3 * (screenDimension.height / 4));
		setLocationRelativeTo(null);
		setTitle("Studentska služba");
		setJMenuBar(new MenuBar());
		add(new ToolBar(), BorderLayout.NORTH);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}