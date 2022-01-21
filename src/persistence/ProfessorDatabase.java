package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import models.Professor;

public class ProfessorDatabase implements Serializable {
	
	private static final long serialVersionUID = -2316426675809008740L;
	
	private List<Professor> professors;
	private transient List<Boolean> filteredDataMap;
	private transient int numOfFiltered;
	private transient String[] columnNames;
	
	public void set(List<Professor> professors) {
		this.professors = professors;
	}
	
	public void addProfessor(Professor professor) {
		this.professors.add(professor);
		this.filteredDataMap.add(true);
	}
	
	public void editProfessor(Professor professorToEdit, Professor professor) {
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
	
	public void deleteProfessor(Professor professor) {
		this.filteredDataMap.remove(this.professors.indexOf(professor));
		this.professors.remove(professor);
		if (this.numOfFiltered > 0)
			this.numOfFiltered--;
	}
	
	public List<Professor> getProfessors() {
		return this.professors;
	}
	
	public String getValueAt(int rowIndex, int columnIndex) {
		/*if ((this.numOfFiltered == -1 && rowIndex >= this.professors.size())
				|| this.numOfFiltered == 0
				|| (this.numOfFiltered > 0 && rowIndex >= this.numOfFiltered))
			return "";*/
		Professor professor = this.getRow(rowIndex);
		switch (columnIndex) {
			case 0: 
				return professor.getFirstName();
			case 1:
				return professor.getLastName();
			case 2:
				return professor.getTitle().toString();
			case 3:
				return professor.getEmail();
			default:
				return null;
		}
	}
	
	public Professor getByEmail(String email) {
		for(Professor p : this.professors) {
			if (p.getEmail().compareTo(email) == 0)
				return p;
		}
		return null;
	}
	
	public Professor getRow(int rowIndex) {
		if (this.numOfFiltered == -1)
			return this.professors.get(rowIndex);
		int i;
		int filterCounter = 0;
		for (i = 0; i < this.filteredDataMap.size(); i++) {
			if (this.filteredDataMap.get(i) == true) {
				filterCounter++;
				if (filterCounter == rowIndex + 1)
					break;
			}
		}
		return this.professors.get(i);
	}
	
	public int getRowCount() {
		if (this.numOfFiltered == -1)
			return this.professors.size();
		else if (this.numOfFiltered == 0)
			return 0;
		else
			return this.numOfFiltered;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	public void filter(String lastName) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Professor professor : this.professors) {
			if (professor.getLastName().toLowerCase().contains(lastName)) {
				this.filteredDataMap.set(i, true);
				this.numOfFiltered++;
			}
			else
				this.filteredDataMap.set(i, false);
			i++;
		}
	}
	
	public void filter(String lastName, String firstName) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Professor professor : this.professors) {
			if (professor.getLastName().toLowerCase().contains(lastName.toLowerCase()) 
					&& professor.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
				this.filteredDataMap.set(i, true);
				this.numOfFiltered++;
			}
			else
				this.filteredDataMap.set(i, false);
			i++;
		}
	}
	
	public void filter(String email, String lastName, String firstName) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Professor professor : this.professors) {
			if (professor.getEmail().toLowerCase().contains(email)
					&& professor.getLastName().toLowerCase().contains(lastName.toLowerCase())
					&& professor.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
				this.filteredDataMap.set(i, true);
				this.numOfFiltered++;
			}
			else
				this.filteredDataMap.set(i, false);
			i++;
		}
	}
	
	public void resetFilter() {
		int i;
		for (i = 0; i < this.filteredDataMap.size(); i++)
			this.filteredDataMap.set(i, true);
		this.numOfFiltered = -1;
	}
	
	@SuppressWarnings("unused")
	private Object readResolve() {
		this.columnNames = new String[] {"Ime", "Prezime", "Zvanje", "Email"};
		this.filteredDataMap = new ArrayList<>();
		for (Professor p : this.professors)
			this.filteredDataMap.add(true);
		this.numOfFiltered = -1;
		return this;
	}
}
