package persistence;

import java.io.Serializable;
import java.util.List;

import models.Subject;

public class SubjectDatabase implements Serializable {
	
	private static final long serialVersionUID = -94351079205237111L;
	
	private List<Subject> subjects;
	private transient String[] columnNames;
	
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
		return columnNames.length;
	}
	
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	private Object readResolve() {
		this.columnNames = new String[] {"Sifra", "Naziv", "ESPB", "Godina", "Semestar"};
		return this;
	}
}
