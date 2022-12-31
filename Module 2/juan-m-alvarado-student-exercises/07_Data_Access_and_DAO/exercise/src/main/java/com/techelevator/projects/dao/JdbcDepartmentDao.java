package com.techelevator.projects.dao;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long id) {
		Department department = null;
		String sql = "SELECT department_id, name FROM department " +
				"WHERE department_id =?; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		if (results.next()) {
			department = mapRowToDepartment(results);
		}
		return department;
	}
	@Override
	public List<Department> getAllDepartments() {
		List<Department> department = new ArrayList();
		String sql = "SELECT department_id, name FROM department;";
		SqlRowSet values = jdbcTemplate.queryForRowSet(sql);
		while(values.next()){
			department.add(mapRowToDepartment(values));
		}
		return department;
	}
	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department " +
				"SET  name = ? " +
				"WHERE department_id = 1;";
		jdbcTemplate.update(sql, updatedDepartment.getName());
	}

	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department department = new Department();
		department.setName(rowSet.getString("name"));
		department.setId(rowSet.getLong("department_id"));

		return department;
	}

}
