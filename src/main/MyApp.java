package main;

import controllers.ProfessorController;
import persistence.Deserialization;
import views.MainFrame;

public class MyApp {

	public static void main(String[] args) {
		Deserialization desr = Deserialization.getInstance();
		desr.deserialize();
		ProfessorController.getInstance();
		MainFrame.getInstance();
	}

}
