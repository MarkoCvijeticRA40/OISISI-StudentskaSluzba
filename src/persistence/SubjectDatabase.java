package persistence;

import java.util.LinkedList;
import java.util.List;

import models.Subject;

public class SubjectDatabase {
	
	private static SubjectDatabase db;
	
	private List<Subject> subjects;
	private final String dbFilePath = "src/persistence/subjects.txt";
	
	private SubjectDatabase() {
		subjects = new LinkedList<>();
	}
	
	public static SubjectDatabase getInstance() {
		if (db == null)
			db = new SubjectDatabase();
		return db;
	}
	
	public void printData() {
		for (Subject s : subjects)
			System.out.println(s);
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}
	
	public List<Subject> getSubjects() {
		return this.subjects;
	}
	
	public String getDbFilePath() {
		return this.dbFilePath;
	}
}
