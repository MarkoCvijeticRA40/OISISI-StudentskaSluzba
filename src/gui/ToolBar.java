package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
	
	public ToolBar()
	{
		setBackground(Color.WHITE);
		setFloatable(false);
		setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY));
		
		JButton newBtn = createButton("src/gui/images/new.png", "Novi", getBackground());
		JButton editBtn = createButton("src/gui/images/edit.png", "Izmeni", getBackground());
		JButton deleteBtn = createButton("src/gui/images/delete.png", "Obrisi", getBackground());
		JButton searchBtn = createButton("src/gui/images/search.png", "Pretraga", getBackground());
		
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200, 25));
		input.setMaximumSize(new Dimension(200, 25));
		input.setToolTipText("Pretraga");
		
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(box);
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setBackground(getBackground());
		panel.add(Box.createHorizontalStrut(10));
		panel.add(newBtn);
		panel.add(Box.createHorizontalStrut(15));
		panel.add(editBtn);
		panel.add(Box.createHorizontalStrut(15));
		panel.add(deleteBtn);
		panel.add(Box.createGlue());
		panel.add(input);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(searchBtn);
		panel.add(Box.createHorizontalStrut(10));
		
		add(panel, BorderLayout.CENTER);
	}
	
	private JButton createButton(String imageURL, String tooltip, Color color) 
	{
		JButton newBtn = new JButton(new ImageIcon(imageURL));
		newBtn.setBorder(BorderFactory.createEmptyBorder());
		newBtn.setToolTipText(tooltip);
		newBtn.setBackground(color);
		return newBtn;
	}
}
