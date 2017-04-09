package com.prolifics.jdbctemp;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {

	public void setDataSource(DataSource dataSource);

	public void create(String name, int age);

	public Student getStudent(int id);

	public List<Student> getAllStudents();

	public void delete(int id);

	public void update(int id, int age);

}
