package main;

import persistence.Database;
import views.MainFrame;

public class MyApp {

	public static void main(String[] args) {
		Database db = Database.getInstance();
		new MainFrame();
	}

}
