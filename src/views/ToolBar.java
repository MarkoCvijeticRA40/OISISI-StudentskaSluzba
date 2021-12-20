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

import views.Professor.Add.AddProfessorDialog;
import views.Professor.Edit.EditProfessorDialog;

public class ToolBar extends JToolBar {
	
	private static final long serialVersionUID = 8774931849219584680L;

	public ToolBar()
	{
		setBackground(Color.WHITE);
		setFloatable(false);
		setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.DARK_GRAY));
		
		JButton newBtn = createButton("src/views/images/new.png", "Novi", "add", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JButton editBtn = createButton("src/views/images/edit.png", "Izmeni", "edit", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JButton deleteBtn = createButton("src/views/images/delete.png", "Obrisi", "delete", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		JButton searchBtn = createButton("src/views/images/search.png", "Pretraga", "search", getBackground(), KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		
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
	
	private JButton createButton(String imageURL, String tooltip, String btnName, Color color, KeyStroke keyStroke) 
	{
		JButton newBtn = new JButton(new ButtonAbstractAction(btnName));
		newBtn.getAction().putValue(Action.ACCELERATOR_KEY, keyStroke);
		newBtn.getAction().putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
		newBtn.setName(tooltip);
		newBtn.setIcon(new ImageIcon(imageURL));
		newBtn.setBorder(BorderFactory.createEmptyBorder());
		newBtn.setBackground(color);
		newBtn.setToolTipText(tooltip);
		newBtn.getActionMap().put("btnAction", newBtn.getAction());
		newBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) newBtn.getAction().getValue(Action.ACCELERATOR_KEY), "btnAction");
		return newBtn;
	}
	
	class ButtonAbstractAction extends AbstractAction {
		
		private static final long serialVersionUID = 3856937795633689149L;
		
		private String btnName;
		
		public ButtonAbstractAction(String btnName) {
			this.btnName = btnName;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedTab = MainFrame.getInstance().getTabbedPane().getSelectedIndex();
			switch (selectedTab) {
				case 0:
					switch(btnName) {
						case "add": 
							AddProfessorDialog.getInstance().init();
							break;
						case "edit": 
							EditProfessorDialog.getInstance().init();
							break;
						case "delete":
							break;
					}
					break;
				case 1:
					break;
				case 2:
					break;
			}
		}
		
	}
}
