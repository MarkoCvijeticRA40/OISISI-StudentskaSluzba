package persistence;

import java.io.Serializable;
import java.util.List;

import models.Professor;

public class ProfessorDatabase implements Serializable {
	
	private static final long serialVersionUID = -2316426675809008740L;
	
	private List<Professor> professors;
	private transient String[] columnNames;
	
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
		return columnNames.length;
	}
	
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	private Object readResolve() {
		this.columnNames = new String[] {"Ime", "Prezime", "Zvanje", "Email"};
		return this;
	}
}
