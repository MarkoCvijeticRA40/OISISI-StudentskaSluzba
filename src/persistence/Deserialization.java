package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Professor;
import models.Subject;

public class Deserialization {
	
	private static Deserialization deserialization;
	
	private Deserialization() {
		
	}
	
	public static Deserialization getInstance() {
		if (deserialization == null)
			deserialization = new Deserialization();
		return deserialization;
	}
	
	public void deserialize() {
		loadProfessors();
		loadSubjects();
	}
	
	private void loadProfessors() {
		ProfessorDatabase professorDb = ProfessorDatabase.getInstance();
		Scanner sc = openFile(professorDb.getDbFilePath());
		if (sc == null)
			return;
		while (sc.hasNextLine()) {
			Professor professor = new Professor(sc.next(), sc.next(), sc.next(), sc.next());
			professorDb.addProfessor(professor);
		}
	}
	
	private void loadSubjects() {
		SubjectDatabase subjectDb = SubjectDatabase.getInstance();
		Scanner sc = openFile(subjectDb.getDbFilePath());
		if (sc == null)
			return;
		while (sc.hasNextLine()) {
			Subject subject = new Subject(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			subjectDb.addSubject(subject);
		}
	}
	
	private Scanner openFile(String filePath) {
		try {
			File file = new File(filePath);
			Scanner sc = new Scanner(file);
			return sc;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
