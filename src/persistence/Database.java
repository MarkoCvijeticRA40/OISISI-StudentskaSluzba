package persistence;

import java.io.Serializable;

public class Database implements Serializable {
	
	private static final long serialVersionUID = -5033381225427085285L;
	private static transient Database database;
	public static final String dbPath = "src/persistence/database.txt";
	
	private ProfessorDatabase professorDatabase;
	private StudentDatabase studentDatabase;
	private SubjectDatabase subjectDatabase;
	
	private Database() {
		/*this.professorDatabase = ProfessorDatabase.getInstance();
		this.studentDatabase = StudentDatabase.getInstance();
		this.subjectDatabase = SubjectDatabase.getInstance();*/
	}
	
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
	
}