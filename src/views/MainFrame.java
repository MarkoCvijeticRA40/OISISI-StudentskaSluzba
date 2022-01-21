package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import persistence.Serialization;

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
		setTitle("Studentska služba");
		setJMenuBar(new MenuBar());
		add(new ToolBar(), BorderLayout.NORTH);
		tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		this.setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent e) {
                Serialization.run();
                System.exit(0);
            }
		});
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