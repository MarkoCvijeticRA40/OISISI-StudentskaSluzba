package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private static MainFrame frame;
	
	private TabbedPane tabbedPane;
	private StatusBar statusBar;

	private MainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenDimension = kit.getScreenSize();
		setSize(3 * (screenDimension.width / 4), 3 * (screenDimension.height / 4));
		setLocationRelativeTo(null);
		setTitle("Studentska slu�ba");
		setJMenuBar(new MenuBar());
		add(new ToolBar(), BorderLayout.NORTH);
		tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static MainFrame getInstance() {
		if (frame == null)
			frame = new MainFrame();
		return frame;
	}
	
	public TabbedPane getTabbedPane() {
		return this.tabbedPane;
	}
	
	public StatusBar getStatusBar() {
		return this.statusBar;
	}

}