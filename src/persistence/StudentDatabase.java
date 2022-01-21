package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import controllers.validators.ValidationPatterns;
import models.ExamGrade;
import models.Student;
import models.Subject;

public class StudentDatabase implements Serializable {

	private static final long serialVersionUID = 393667417381023594L;
	
	private List<Student> students;
	private transient List<Boolean> filteredDataMap;
	private transient int numOfFiltered;
	private transient String[] columnNames;
	
	public void set(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
		this.filteredDataMap.add(true);
	}
	
	public void editStudent(int row, Student student) {
		Student studentToEdit = this.getRow(row);
		studentToEdit.setFirstName(student.getFirstName());
		studentToEdit.setLastName(student.getLastName());
		studentToEdit.setDateOfBirth(student.getDateOfBirth());
		studentToEdit.setAddress(student.getAddress());
		studentToEdit.setEmail(student.getEmail());
		studentToEdit.setIndexNumber(student.getIndexNumber());
		studentToEdit.setEnrollmentYear(student.getEnrollmentYear());
		studentToEdit.setCurrentStudiesYear(student.getCurrentStudiesYear());
		studentToEdit.setFinancingStatus(student.getFinancingStatus());
	}
	
	public void deleteStudent(Student student) {
		this.filteredDataMap.remove(this.students.indexOf(student));
		this.students.remove(student);
		if (this.numOfFiltered > 0)
			this.numOfFiltered--;
	}
	
	public void filter(String lName) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Student student : this.students) {
			if (student.getLastName().toLowerCase().contains(lName.toLowerCase())) {
				this.filteredDataMap.set(i, true);
				this.numOfFiltered++;
			}
			else
				this.filteredDataMap.set(i, false);
			i++;
		}
	}
	
	public void filter(String lName, String fName) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Student student : this.students) {
			if (student.getLastName().toLowerCase().contains(lName.toLowerCase()) 
					&& student.getFirstName().toLowerCase().contains(fName.toLowerCase())) {
				System.out.println(i);
				this.filteredDataMap.set(i, true);
				this.numOfFiltered++;
			}
			else
				this.filteredDataMap.set(i, false);
			i++;
		}
	}

	public void filter(String index, String lName, String fName) {
		int i = 0;
		this.numOfFiltered = 0;
		for (Student student : this.students) {
			if (student.getLastName().toLowerCase().contains(lName.toLowerCase()) 
					&& student.getFirstName().toLowerCase().contains(fName.toLowerCase())
					&& student.getIndexNumber().toLowerCase().contains(index.toLowerCase())) {
				this.filteredDataMap.set(i, true);
				this.numOfFiltered++;
			}
			else
				this.filteredDataMap.set(i, false);
			i++;
		}
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public String getValueAt(int rowIndex, int columnIndex) {
		if ((this.numOfFiltered == -1 && rowIndex >= this.students.size())
				|| this.numOfFiltered == 0
				|| (this.numOfFiltered > 0 && rowIndex >= this.numOfFiltered))
			return "";
		Student student = this.getRow(rowIndex);
		switch (columnIndex) {
			case 0: 
				return student.getIndexNumber();
			case 1:
				return student.getFirstName();
			case 2:
				return student.getLastName();
			case 3:
				return String.valueOf(student.getCurrentStudiesYear());
			case 4:
				return student.getFinancingStatus().toString();
			case 5:
				return String.valueOf(student.getRating());
			default:
				return null;
		}
	}
	
	public Student getRow(int rowIndex) {
		if (this.numOfFiltered == -1)
			return this.students.get(rowIndex);
		int i;
		int filterCounter = 0;
		for (i = 0; i < this.filteredDataMap.size(); i++) {
			if (this.filteredDataMap.get(i) == true) {
				filterCounter++;
				if (filterCounter == rowIndex + 1)
					break;
			}
		}
		return students.get(i);
	}
	
	public int getRowCount() {
		if (this.numOfFiltered == -1)
			return this.students.size();
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
	
	public Subject getNotPassedExamRow(int rowIndexStudent, int rowIndexExam) {
		Student student = students.get(rowIndexStudent);
		return student.getNotPassedExams().get(rowIndexExam);
	}
	
	public Student getByIndexNumber(String indexNumber) {
		for (Student student : this.students) {
			if (student.getIndexNumber().compareTo(indexNumber) == 0)
				return student;
		}
		return null;
	}
	
	public String getValueAtNotPassedExams(Student student, int rowIndex, int columnIndex) {
		if (rowIndex >= student.getNotPassedExams().size())
			return "";
		Subject subject = student.getNotPassedExams().get(rowIndex);
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
			return subject.getSemester().toString();
		default:
			return null;
		}
	}
	
	public String getValueAtPassedExams(Student student, int rowIndex, int columnIndex) {
		if (rowIndex >= student.getPassedExams().size())
			return "";
		ExamGrade examGrade = student.getPassedExams().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return String.valueOf(examGrade.getSubject().getId());
		case 1:
			return examGrade.getSubject().getName();
		case 2:
			return String.valueOf(examGrade.getSubject().getEspb());
		case 3:
			return String.valueOf(examGrade.getMark());
		case 4:
			return ValidationPatterns.dateFormat.format(examGrade.getExamDate());
		default:
			return null;
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
		this.columnNames = new String[] {"Index", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
		this.filteredDataMap = new ArrayList<>();
		for (Student s : this.students)
			this.filteredDataMap.add(true);
		this.numOfFiltered = -1;
		return this;
	}
}