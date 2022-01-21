package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Department implements Serializable {

	private static final long serialVersionUID = -6056426272631516162L;
	
	private String id;
	private String name;
	private Professor manager;
	private List<Professor> professors;
	
	public Department(String id, String name, Professor manager) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.professors = new LinkedList<>();
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

	public Professor getManager() {
		return manager;
	}

	public void setManager(Professor manager) {
		this.manager = manager;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager=" + manager + ", professors=" + professors + "]";
	}
}