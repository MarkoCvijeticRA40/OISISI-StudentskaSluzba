package controllers;

import models.Professor;
import models.Subject;
import persistence.SubjectDatabase;

public class SubjectController {
	
	private static SubjectController controller;
	
	private SubjectDatabase subjectsDatabase;
	
	private SubjectController() {
		this.subjectsDatabase = SubjectDatabase.getInstance();
	}
	
	public static SubjectController getInstance() {
		if (controller == null)
			controller = new SubjectController();
		return controller;
	}
	
	public boolean checkProfessorExistence(Professor professor) {
		for (Subject subject : subjectsDatabase.getSubjects()) {
			if (subject.getProfessor().equals(professor))
				return true;
		}
		return false;
	}
}
