package persistence;

import java.io.Serializable;
import java.util.List;

import models.Department;

public class DepartmentDatabase implements Serializable {

	private static final long serialVersionUID = 8689793207477963462L;
	
	private List<Department> departments;

	public List<Department> getDepartments() {
		return departments;
	}

}
