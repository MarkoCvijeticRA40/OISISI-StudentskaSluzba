package persistence;

import java.io.Serializable;
import java.util.List;

import controllers.validators.ValidationPatterns;
import models.ExamGrade;
import models.Student;
import models.Subject;

public class StudentDatabase implements Serializable {

	private static final long serialVersionUID = 393667417381023594L;
	
	private List<Student> students;
	private transient String[] columnNames;
	
	public void addStudent(Student student) {
		this.students.add(student);
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
	public void deleteStudent(int row) {
		this.students.remove(row);
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public String getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex >= students.size())
			return "";
		Student student = students.get(rowIndex);
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
		return this.students.get(rowIndex);
	}
	
	public int getRowCount() {
		return students.size();
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
	
	private Object readResolve() {
		this.columnNames = new String[] {"Index", "Ime", "Prezime", "Godina studija", "Status", "Prosek"};
		return this;
	}
}