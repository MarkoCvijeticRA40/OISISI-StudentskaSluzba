package controllers;

public class SubjectController {
	
	private static SubjectController controller;
	
	private SubjectController() {
		
	}
	
	public static SubjectController getInstance() {
		if (controller == null)
			controller = new SubjectController();
		return controller;
	}
}
