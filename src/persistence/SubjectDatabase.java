package persistence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.Professor;
import models.Semester;
import models.Subject;

public class SubjectDatabase {
	
	private static SubjectDatabase db;
	
	private List<Subject> subjects;
	private List<String> columnNames;
	
	private SubjectDatabase() {
		List<Professor> professors = ProfessorDatabase.getInstance().getProfessors();
		subjects = new LinkedList<>();
		subjects.add(new Subject(0, "Algebra", Semester.Zimski, 1, 9, professors.get(0)));
		subjects.add(new Subject(1, "OISISI", Semester.Zimski, 3, 6, professors.get(1)));
		subjects.add(new Subject(2, "OS", Semester.Letnji, 2, 8, professors.get(1)));
		subjects.add(new Subject(3, "SAU", Semester.Letnji, 2, 8, professors.get(0)));
		subjects.add(new Subject(3, "NANS", Semester.Zimski, 3, 5, professors.get(1)));
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
	
	public void deleteSubject(int rowIndex) {
		this.subjects.remove(rowIndex);
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
	
	public Subject getRow(int row) {
		return subjects.get(row);
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
}
