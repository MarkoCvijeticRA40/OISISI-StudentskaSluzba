package persistence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.Subject;

public class SubjectDatabase {
	
	private static SubjectDatabase db;
	
	private List<Subject> subjects;
	private List<String> columnNames;
	private final String dbFilePath = "src/persistence/subjects.txt";
	
	private SubjectDatabase() {
		subjects = new LinkedList<>();
		columnNames = new ArrayList<>();
		columnNames.add("Šifra");
		columnNames.add("Naziv");
		columnNames.add("ESPB");
		columnNames.add("Godina");
		columnNames.add("Semestar");
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
	
	public String getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= subjects.size())
			return "";
		Subject subject = subjects.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return String.valueOf(subject.getId());
			case 1:
				return subject.getName();
			case 2:
				return String.valueOf(subject.getEspb());
			case 3:
				return String.valueOf(subject.getStudyYear());
			case 4:
				return subject.getSemester();
			default:
				return null;
		}
	}
	
	public int getRowCount() {
		return subjects.size();
	}
	
	public int getColumnCount() {
		return columnNames.size();
	}
	
	public String getColumnName(int columnIndex) {
		return columnNames.get(columnIndex);
	}
	
	public String getDbFilePath() {
		return this.dbFilePath;
	}
}
