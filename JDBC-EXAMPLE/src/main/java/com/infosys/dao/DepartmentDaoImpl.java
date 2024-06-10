package com.infosys.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.infosys.model.Department;
import com.infosys.model.DepartmentMapper;
import com.infosys.model.HOD;
import com.infosys.model.HodMapper;

@Component
public class DepartmentDaoImpl implements DepartmentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_SEARCH_department="SELECT d.dept_id, d.dept_name,d.dept_intake,d.dept_duration, h.hod_id, h.hod_name, h.hod_experience, h.hod_incharge_date FROM department d JOIN hod h ON d.dept_id = h.dept_id WHERE d.dept_id = ?;";
	private final String SQL_INSERT_department="insert into department(dept_id,dept_name,dept_intake,dept_duration) values(?,?,?,?)";
	private final String SQL_FIND_department ="select * from department where dept_id=?";
	private final String SQL_UPDATE_department="";
	private final String SQL_INSERT_HOD="insert into hod(hod_id,hod_name,hod_experience,hod_incharge_date,dept_id) values(?,?,?,?,?)";
	
	@Override
	public List<Department> listDepartment() {

		String SQL="select * from department";
		List<Department> department=jdbcTemplate.query(SQL, new DepartmentMapper());
		return department;
	}
	
	@Override
	public boolean search(Department department) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_SEARCH_department,department.getDept_id())>0;
	}

	@Override
	public boolean CreateDepartment(Department department) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_department,department.getDept_id(),department.getDept_name(),department.getDept_intake(),department.getDept_duration())>0;
	}

	@Override
	public Department getDept_id(int dept_id) {
		
		return jdbcTemplate.queryForObject(SQL_FIND_department,new Object[] {dept_id},new DepartmentMapper());
	}

	@Override
	public boolean updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_UPDATE_department,department.getDept_id(),department.getDept_name(),department.getDept_intake(),department.getDept_duration())>0;
	}

	@Override
	public Map<String, Object> listDepartmentandHOD(int dept_id) {
		// TODO Auto-generated method stub
		String SQL="select * from department";
		return jdbcTemplate.queryForObject(SQL_SEARCH_department, new Object[]{dept_id}, new HodMapper());
	}

	@Override
	public boolean CreateHod(HOD hod) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_HOD,hod.getHod_id(),hod.getHod_name(),hod.getHod_experience(),hod.getHod_incharge_date(),hod.getDept_id())>0;
	}

	
	
	
	
}
