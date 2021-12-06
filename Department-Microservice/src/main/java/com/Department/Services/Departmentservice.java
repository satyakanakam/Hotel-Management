package com.Department.Services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Department.Models.Department;





@Service
public interface Departmentservice {

	Department addDepartment(Department dept);

	List<Department> getAllDepartments();

	Optional<Department> getDepartment(long parseLong);

	Department updateDepartment(Department dept);

	String deleteDepartment(long parseLong);
	
	

	
	
	

}
