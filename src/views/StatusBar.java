package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = -6823574192113464251L;
	
	private JLabel selectedTab;
	
	public StatusBar() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		
		this.add(Box.createHorizontalStrut(5));
		selectedTab = new JLabel("Studentska sluzba - Studenti");
		this.add(selectedTab);
		this.add(Box.createHorizontalGlue());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy");
		JLabel time = new JLabel(dateFormat.format(new Date()));
		this.add(time);
		this.add(Box.createHorizontalStrut(20));
		
		
		Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				time.setText(dateFormat.format(new Date()));
			}
			
		});
		
		timer.start();
	}
	
	public void setSelectedTabLabel(String tabName) {
		selectedTab.setText("Studentska sluzba - " + tabName);
	}
	
}
