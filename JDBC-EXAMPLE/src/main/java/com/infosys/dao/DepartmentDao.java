package com.infosys.dao;

import java.util.List;
import java.util.Map;

import com.infosys.model.Department;
import com.infosys.model.HOD;


public interface DepartmentDao {
	
	public List<Department> listDepartment();
	public Map<String, Object> listDepartmentandHOD(int dept_id);
	public boolean search(Department department);
	public boolean CreateDepartment(Department department);
	public boolean CreateHod(HOD hod);
	public Department getDept_id(int dept_id);
	public boolean updateDepartment(Department department);
	
}
