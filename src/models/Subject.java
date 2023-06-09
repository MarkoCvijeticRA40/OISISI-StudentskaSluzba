package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Subject implements Serializable {

	private static final long serialVersionUID = -826929363813020936L;
	
	private String id;
	private String name;
	private Semester semester;
	private int studyYear;
	private Professor professor;
	private int espb;
	private List<Student> passedStudents;
	private List<Student> notPassedStudents;
	
	public Subject(String id, String name, Semester semester, int studyYear, int espb) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.studyYear = studyYear;
		this.espb = espb;
		this.passedStudents = new LinkedList<>();
		this.notPassedStudents = new LinkedList<>();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Semester getSemester() {
		return semester;
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

}