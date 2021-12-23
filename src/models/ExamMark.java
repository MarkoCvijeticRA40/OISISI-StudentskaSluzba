package models;

import java.util.Date;

public class ExamMark {

	private Student student;
	private Subject subject;
	private int mark;
	private Date examDate;
	
	public ExamMark(Student student, Subject subject, int mark, Date examDate) {
		super();
		this.student = student;
		this.subject = subject;
		this.mark = mark;
		this.examDate = examDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		if(mark >= 6 && mark <= 10)
			this.mark = mark;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}	
}