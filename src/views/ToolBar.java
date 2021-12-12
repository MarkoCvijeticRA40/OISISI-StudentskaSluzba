package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
	
	public ToolBar()
	{
		setBackground(Color.WHITE);
		setFloatable(false);
		setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY));
		
		JButton newBtn = createButton("src/views/images/new.png", "Novi", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JButton editBtn = createButton("src/views/images/edit.png", "Izmeni", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JButton deleteBtn = createButton("src/views/images/delete.png", "Obrisi", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		JButton searchBtn = createButton("src/views/images/search.png", "Pretraga", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		
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
	
	private JButton createButton(String imageURL, String tooltip, Color color, KeyStroke keyStroke) 
	{
		Action buttonAction = new AbstractAction()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(tooltip + " pressed");
			}
			
		};
		buttonAction.putValue(Action.ACCELERATOR_KEY, keyStroke);
		buttonAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
		JButton newBtn = new JButton(buttonAction);
		newBtn.setIcon(new ImageIcon(imageURL));
		newBtn.setBorder(BorderFactory.createEmptyBorder());
		newBtn.setBackground(color);
		newBtn.setToolTipText(tooltip);
		newBtn.getActionMap().put("btnAction", buttonAction);
		newBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) buttonAction.getValue(Action.ACCELERATOR_KEY), "btnAction");
		return newBtn;
	}
}
