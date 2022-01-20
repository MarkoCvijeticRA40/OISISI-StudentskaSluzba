package persistence;

import java.io.Serializable;
import java.util.List;

import models.Subject;

public class SubjectDatabase implements Serializable {
	
	private static final long serialVersionUID = -94351079205237111L;
	
	private List<Subject> subjects;
	private transient String[] columnNames;
	private transient String[] examGradeNames;
	
	public void printData() {
		for (Subject s : subjects)
			System.out.println(s);
	}
	
	public void addSubject(Subject subject) {
		this.subjects.add(subject);
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
	}
	
	public List<Subject> getSubjects() {
		return this.subjects;
	}
	
	public Subject getSubjctById(int id) {
		for (Subject s : this.subjects) {
			if (s.getId() == id)
				return s;
		}
		return null;
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
				return String.valueOf(subject.getStudyYear());
			case 3:
				return subject.getSemester().toString();
			case 4:
				return String.valueOf(subject.getEspb());
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
	
	private Object readResolve() {
		this.columnNames = new String[] {"Sifra", "Naziv", "Godina", "Semestar", "ESPB"};
		this.examGradeNames = new String[] {"Sifra predmeta", "Naziv predmeta", "ESPB", "Ocena", "Datum"};
		return this;
	}
}
