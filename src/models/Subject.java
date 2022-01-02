package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Subject implements Serializable {

	private static final long serialVersionUID = -826929363813020936L;
	
	private int id;
	private String name;
	private Semester semester;
	private int studyYear;
	private Professor professor;
	private int espb;
	private List<Student> passedStudents;
	private List<Student> notPassedStudents;
	
	public Subject(int id, String name, Semester semester, int studyYear, int espb, Professor professor) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.studyYear = studyYear;
		this.espb = espb;
		this.professor = professor;
		this.passedStudents = new LinkedList<>();
		this.notPassedStudents = new LinkedList<>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSemester() {
		return semester.toString();
	}
	
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
	public int getStudyYear() {
		return studyYear;
	}
	
	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public int getEspb() {
		return espb;
	}
	
	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<Student> getPassedStudents() {
		return passedStudents;
	}
	
	public List<Student> getNotPassedStudents() {
		return notPassedStudents;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", semester=" + semester + ", studyYear=" + studyYear
				+ ", espb=" + espb + "]";
	}
}