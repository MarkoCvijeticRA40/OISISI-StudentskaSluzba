package models;

import java.util.List;

enum Semestar {letnji,Zimski}

public class Subject {

	public int id;
	public String name;
	public Semestar semester;
	public int studyYear;
	public Professor professor;
	public int espb;
	public List<Student> passedStudents;
	public List<Student> notPassedStudents;
	
	public Subject(int id, String name, Semestar semester, int studyYear, Professor professor, int espb) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.studyYear = studyYear;
		this.professor = professor;
		this.espb = espb;
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
	public Semestar getSemester() {
		return semester;
	}
	public void setSemester(Semestar semester) {
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
}