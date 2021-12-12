package persistence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.Professor;

public class ProfessorDatabase {
	
	private static ProfessorDatabase db;
	
	private List<Professor> professors;
	private List<String> columnNames;
	private final String dbFilePath = "src/persistence/professors.txt";
	
	private ProfessorDatabase() {
		professors = new LinkedList<>();
		columnNames = new ArrayList<>();
		columnNames.add("Ime");
		columnNames.add("Prezime");
		columnNames.add("Zvanje");
		columnNames.add("Email");
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
	
	public String getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= professors.size())
			return "";
		Professor professor = professors.get(rowIndex);
		switch (columnIndex) {
			case 0: 
				return professor.getFirstName();
			case 1:
				return professor.getLastName();
			case 2:
				return professor.getTitle();
			case 3:
				return professor.getEmail();
			default:
				return null;
		}
	}
	
	public int getRowCount() {
		return professors.size();
	}
	
	public int getColumnCount() {
		return columnNames.size();
	}
	
	public String getColumnName(int column) {
		return columnNames.get(column);
	}
	
	public String getDbFilePath() {
		return this.dbFilePath;
	}
}
