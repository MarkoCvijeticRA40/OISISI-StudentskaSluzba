package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import models.Professor;
import models.Subject;

// TEMP "PERSISTENCE" SYSTEM
public class Database {
	
	private static Database database;
	
	private List<Professor> professors;
	private List<Subject> subjects;
	
	private Database() {
		professors = new LinkedList<>();
		loadProfessors();
		subjects = new LinkedList<>();
		loadSubjects();
		for (Professor p : professors)
			System.out.println(p);
		for (Subject s : subjects)
			System.out.println(s);
	}
	
	public static Database getInstance() {
		if (database == null)
			database = new Database();
		return database;
	}
	
	private void loadProfessors() {
		Scanner sc = openFile("src/persistence/professors.txt");
		if (sc == null)
			return;
		while (sc.hasNextLine()) {
			String[] data = sc.nextLine().split(" ");
			Professor professor = new Professor(data[0], data[1], data[2], data[3]);
			this.professors.add(professor);
		}
	}
	
	private void loadSubjects() {
		Scanner sc = openFile("src/persistence/subjects.txt");
		if (sc == null)
			return;
		while (sc.hasNextLine()) {
			Subject subject = new Subject(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			this.subjects.add(subject);
		}
	}
	
	private Scanner openFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			return sc;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
