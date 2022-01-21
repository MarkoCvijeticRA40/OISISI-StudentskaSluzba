package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import models.Subject;

public class SubjectDatabase implements Serializable {
	
	private static final long serialVersionUID = -94351079205237111L;
	
	private List<Subject> subjects;
	private transient List<Boolean> filteredDataMap;
	private transient int numOfFiltered;
	private transient String[] columnNames;
	private transient String[] examGradeNames;
	
	public void set(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
		this.filteredDataMap.add(true);
	}
	
	public void editSubject(Subject subject, Subject subjectToEdit) {
		subjectToEdit.setId(subject.getId());
		subjectToEdit.setName(subject.getName());
		subjectToEdit.setStudyYear(subject.getStudyYear());
		subjectToEdit.setEspb(subject.getEspb());
		subjectToEdit.setSemester(subject.getSemester());
	}
	
	public void deleteSubject(int rowIndex) {
		this.subjects.remove(rowIndex);
		if (this.numOfFiltered > 0)
			this.numOfFiltered--;
	}
	
	public List<Subject> getSubjects() {
		return this.subjects;
	}
	
	public Subject getSubjctById(String id) {
		for (Subject s : this.subjects) {
			if (s.getId().compareTo(id) == 0)
				return s;
		}
		return null;
	}
	
	public String getValueAt(int rowIndex, int columnIndex) {
		if ((this.numOfFiltered == -1 && rowIndex >= this.subjects.size())
				|| this.numOfFiltered == 0
				|| (this.numOfFiltered > 0 && rowIndex >= this.numOfFiltered))
			return "";
		Subject subject = this.getRow(rowIndex);
		switch (columnIndex) {
			case 0:
				return String.valueOf(subject.getId());
			case 1:
				return subject.getName();
			case 2:
				return String.valueOf(subject.getStudyYear());
			case 3:
				return subject.getSemester().toString();
			case 4:
				return String.valueOf(subject.getEspb());
			default:
				return null;
		}
	}
	
	public Subject getRow(int rowIndex) {
		if (this.numOfFiltered == -1)
			return this.subjects.get(rowIndex);
		int i;
		int filterCounter = 0;
		for (i = 0; i < this.filteredDataMap.size(); i++) {
			if (this.filteredDataMap.get(i) == true) {
				filterCounter++;
				if (filterCounter == rowIndex + 1)
					break;
			}
		}
		return subjects.get(i);
	}
	
	public int getRowCount() {
		if (this.numOfFiltered == -1)
			return this.subjects.size();
		else if (this.numOfFiltered == 0)
			return 0;
		else
			return this.numOfFiltered;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	public int getExamGradeColumnCount() {
		return this.examGradeNames.length;
	}
	
	public String getExamGradeColumnName(int columnIndex) {
		return examGradeNames[columnIndex];
	}
	
	public void filter(String id) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Subject subject : this.subjects) {
			if (subject.getId().toLowerCase().contains(id)) {
				this.filteredDataMap.set(i, true);
				this.numOfFiltered++;
			}
			else
				this.filteredDataMap.set(i, false);
			i++;
		}
	}
	
	public void filter(String id, String name) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Subject subject : this.subjects) {
			if (subject.getId().toLowerCase().contains(id) && subject.getName().toLowerCase().contains(name)) {
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
		this.columnNames = new String[] {"Sifra", "Naziv", "Godina", "Semestar", "ESPB"};
		this.examGradeNames = new String[] {"Sifra predmeta", "Naziv predmeta", "ESPB", "Ocena", "Datum"};
		this.filteredDataMap = new ArrayList<>();
		for (Subject s : this.subjects)
			this.filteredDataMap.add(true);
		this.numOfFiltered = -1;
		return this;
	}
}
