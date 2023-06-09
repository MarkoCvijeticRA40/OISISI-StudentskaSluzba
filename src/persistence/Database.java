package persistence;

import java.io.Serializable;

public class Database implements Serializable {
	
	private static final long serialVersionUID = -5033381225427085285L;
	private static transient Database database;
	public static final String dbPath = "database.txt";
	
	private ProfessorDatabase professorDatabase;
	private StudentDatabase studentDatabase;
	private SubjectDatabase subjectDatabase;
	private DepartmentDatabase departmentDatabase;
	
	public static Database getInstance() {
		if (database == null)
			database = new Database();
		return database;
	}
	
	public static void setInstance(Database database) {
		Database.database = database;
	}

	public ProfessorDatabase getProfessorDatabase() {
		return professorDatabase;
	}

	public StudentDatabase getStudentDatabase() {
		return studentDatabase;
	}

	public SubjectDatabase getSubjectDatabase() {
		return subjectDatabase;
	}
	
	public DepartmentDatabase getDepartmentDatabase() {
		return this.departmentDatabase;
	}
	
}
