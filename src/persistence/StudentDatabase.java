package persistence;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import controllers.validators.ValidationPatterns;
import models.Address;
import models.Status;
import models.Student;
import models.Subject;

public class StudentDatabase {

private static StudentDatabase db;
	
	private List<Student> students;
	private List<String> columnNames;
	
	private StudentDatabase() {
		
		students = new LinkedList<>();
		try {
			students.add(new Student(
					"Marko",
					"Markovic",
					ValidationPatterns.dateFormat.parse("05/12/2000"),
					new Address("Laze Kostica", 150, "Novi Sad", "Srbija"),
					"0628440456",
					"marko.markovic@uns.ac.rs",
					"RA40/2019",
					2019,
					3,
					Status.B,
					8.50));
			students.add(new Student(
					"Dejan",
					"Micic",
					ValidationPatterns.dateFormat.parse("04/11/2001"),
					new Address("Futoski put", 44, "Novi Sad", "Srbija"),
					"0647740489",
					"dejan.micic@uns.ac.rs",
					"RA124/2020",
					2020,
					2,
					Status.B,
					9.12));
			students.add(new Student(
					"Mirko",
					"Dejanovic",
					ValidationPatterns.dateFormat.parse("15/02/2002"),
					new Address("Safarikova", 10, "Novi Sad", "Srbija"),
					"0623465409",
					"mirko.dejanovic@uns.ac.rs",
					"RA40/2021",
					2021,
					1,
					Status.S,
					7.10));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		columnNames = new ArrayList<>();
		columnNames.add("Indeks");
		columnNames.add("Ime");
		columnNames.add("Prezime");
		columnNames.add("Godina studija");
		columnNames.add("Status");
		columnNames.add("Prosek");
	}
	
	public static StudentDatabase getInstance() {
		if (db == null)
			db = new StudentDatabase();
		return db;
	}
	
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
		return columnNames.size();
	}
	
	public String getColumnName(int column) {
		return columnNames.get(column);
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
			return subject.getSemester();
		default:
			return null;
		}
	}
}