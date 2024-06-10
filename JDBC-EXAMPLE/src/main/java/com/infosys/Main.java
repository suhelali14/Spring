package com.infosys;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.config.JdbcConfig;
import com.infosys.dao.DepartmentDao;
import com.infosys.model.Department;
import com.infosys.model.HOD;


public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		DepartmentDao departmentdao=context.getBean(DepartmentDao.class);
		
	
		System.out.println("List of departments");
		for(Department s:departmentdao.listDepartment()) {
			System.out.println(s);
		}
		
		
//		System.out.println(" \n List of Departments and Hod");
//		System.out.println(departmentdao.listDepartmentandHOD(1));
		
		System.out.println(" \nList of Department and HOD");
        Map<String, Object> resultMap = (Map<String, Object>) departmentdao.listDepartmentandHOD(2);
        Department department = (Department) resultMap.get("department");
        HOD hod = (HOD) resultMap.get("hod");

        System.out.println("Department: " + department);
        System.out.println("HOD: " + hod);
        
        
//		for(HOD s:departmentdao.listDepartmentandHOD(1)) {
//			System.out.println(s);
//		}
		//create department
//		System.out.println("Inserting the values");
//		Department department=new Department(3,"IT",80,4);
//		departmentdao.CreateDepartment(department);
//		
//		for(Department s:departmentdao.listDepartment()) {
//			System.out.println(s);
//		}
//		
//		System.out.println(" \n List of Departments and Hod");
//		System.out.println(departmentdao.listDepartmentandHOD(3));
		
		//create hod
//		System.out.println("Inserting the values");
//		HOD hod2=new HOD(3,"Vijay",12,2016,3);
//		departmentdao.CreateHod(hod2);
//		
		System.out.println(" \nList of Department and HOD");
        Map<String, Object> resultMap1 = (Map<String, Object>) departmentdao.listDepartmentandHOD(3);
        Department department1 = (Department) resultMap1.get("department");
        HOD hod1 = (HOD) resultMap1.get("hod");

        System.out.println("Department: " + department1);
        System.out.println("HOD: " + hod1);
		
		
	}
	
}
