package com.infosys.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class HodMapper implements RowMapper<Map<String, Object>>{

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Department department=new Department();
		department.setDept_id(rs.getInt("dept_id"));
		department.setDept_name(rs.getString("dept_name"));
		department.setDept_intake(rs.getInt("dept_intake"));
		department.setDept_duration(rs.getInt("dept_duration"));
		
		HOD hod=new HOD();
		hod.setHod_id(rs.getInt("hod_id"));
		hod.setHod_name(rs.getString("hod_name"));
		hod.setHod_experience(rs.getInt("hod_experience"));
		hod.setHod_incharge_date(rs.getInt("hod_incharge_date"));
		hod.setDept_id(department.getDept_id());
		
		Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("department", department);
        resultMap.put("hod", hod);
        return resultMap;
		
	}
	
}
