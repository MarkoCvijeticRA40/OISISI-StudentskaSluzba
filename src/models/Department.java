package models;

import java.util.LinkedList;
import java.util.List;

public class Department {

	private int id;
	private String name;
	private Professor manager;
	private List<Professor> professors;
	
	public Department(int id, String name, Professor manager) {
		super();
		this.id = id;
		this.name = name;
		this.manager = manager;
		this.professors = new LinkedList<>();
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

	public Professor getManager() {
		return manager;
	}

	public void setManager(Professor manager) {
		this.manager = manager;
	}

	public List<Professor> getProfessors() {
		return professors;
	}
}