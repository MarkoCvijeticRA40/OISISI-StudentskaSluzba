package persistence;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import controllers.validators.ValidationPatterns;
import models.Address;
import models.Professor;

public class ProfessorDatabase {
	
	private static ProfessorDatabase db;
	
	private List<Professor> professors;
	private List<String> columnNames;
	
	private ProfessorDatabase() {
		professors = new LinkedList<>();
		try {
			professors.add(new Professor(
					"Pera",
					"Peric",
					ValidationPatterns.dateFormat.parse("01/01/1990"),
					new Address("Sutjeska", 1, "Novi Sad", "Srbija"),
					"06445679",
					"pera.peric@uns.ac.rs",
					new Address("Bulevar Evrope", 150, "Novi Sad", "Srbija"),
					753951456,
					"Asistent",
					2));
			professors.add(new Professor(
					"Mika",
					"Mikic",
					ValidationPatterns.dateFormat.parse("01/01/1660"),
					new Address("Pere Perica", 10, "Novi Sad", "Srbija"),
					"065863256",
					"mika.mikic@uns.ac.rs",
					new Address("Bulevar Evrope", 150, "Novi Sad", "Srbija"),
					852741963,
					"Red. profesor",
					30));
			professors.add(new Professor(
					"Djura",
					"Djuric",
					ValidationPatterns.dateFormat.parse("01/01/1995"),
					new Address("Bate Brkica", 16, "Novi Sad", "Srbija"),
					"060753863",
					"djura.djuric@uns.ac.rs",
					new Address("Bulevar Evrope", 150, "Novi Sad", "Srbija"),
					753963423,
					"Red. profesor",
					5));
			professors.add(new Professor(
					"Branko",
					"Brankovic",
					ValidationPatterns.dateFormat.parse("01/01/1993"),
					new Address("Branka Bajica", 30, "Novi Sad", "Srbija"),
					"0627456893",
					"branko.brankovic@uns.ac.rs",
					new Address("Bulevar Evrope", 150, "Novi Sad", "Srbija"),
					741753963,
					"Vandr. profesor",
					5));
			professors.add(new Professor(
					"Andjela",
					"Andjelic",
					ValidationPatterns.dateFormat.parse("01/01/1989"),
					new Address("Futoski put", 68, "Novi Sad", "Srbija"),
					"061423568",
					"andjela.andjelic@uns.ac.rs",
					new Address("Bulevar Evrope", 150, "Novi Sad", "Srbija"),
					789456123,
					"Asistent",
					5));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
	
	public void editProfessor(int row, Professor professor) {
		Professor professorToEdit = this.getRow(row);
		professorToEdit.setFirstName(professor.getFirstName());
		professorToEdit.setLastName(professor.getLastName());
		professorToEdit.setDateOfBirth(professor.getDateOfBirth());
		professorToEdit.setAddress(professor.getAddress());
		professorToEdit.setEmail(professor.getEmail());
		professorToEdit.setOfficeAddress(professor.getOfficeAddress());
		professorToEdit.setTitle(professor.getTitle());
		professorToEdit.setPhoneNumber(professor.getPhoneNumber());
		professorToEdit.setIdCardNumber(professor.getIdCardNumber());
		professorToEdit.setYearsOfService(professor.getYearsOfService());
	}
	
	public void deleteProfessor(int row) {
		this.professors.remove(row);
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
	
	public Professor getRow(int rowIndex) {
		return this.professors.get(rowIndex);
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
}
