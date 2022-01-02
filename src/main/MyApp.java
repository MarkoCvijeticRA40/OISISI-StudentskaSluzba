package main;

import javax.swing.JOptionPane;

import persistence.Deserialization;
import views.MainFrame;

public class MyApp {

	public static void main(String[] args) {
		if(!Deserialization.run()) {
			JOptionPane.showMessageDialog(null, "Ucitavanje podataka neuspesno!");
			return;
		}
		MainFrame.getInstance();
	}

}
