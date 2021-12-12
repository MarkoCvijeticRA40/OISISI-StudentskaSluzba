package controllers;

public class ProfessorController {
	
	private static ProfessorController controller;
	
	private ProfessorController() {
		
	}
	
	public static ProfessorController getInstance() {
		if (controller == null)
			controller = new ProfessorController();
		return controller;
	}
}
