package persistence;

import java.util.LinkedList;
import java.util.List;

import models.Professor;

public class ProfessorDatabase {
	
	private static ProfessorDatabase db;
	
	private List<Professor> professors;
	private final String dbFilePath = "src/persistence/professors.txt";
	
	private ProfessorDatabase() {
		professors = new LinkedList<>();
	}
	
	public static ProfessorDatabase getInstance() {
		if (db == null)
			db = new ProfessorDatabase();
		return db;
	}
	
	public void printData() {
		for (Professor p : professors)
			System.out.println(p);
	}
	
	public void addProfessor(Professor professor) {
		this.professors.add(professor);
	}
	
	public List<Professor> getProfessors() {
		return this.professors;
	}
	
	public String getDbFilePath() {
		return this.dbFilePath;
	}
}
