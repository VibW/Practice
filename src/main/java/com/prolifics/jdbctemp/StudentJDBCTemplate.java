package com.prolifics.jdbctemp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

	@Override
	public void create(String name, int age) {
		String sql = "insert into Student(name,age) values (?,?)";
		jdbcTemplateObject.update(sql, name, age);
		System.out.println("created record Name " + name + " Age " + age);

	}

	@Override
	public Student getStudent(int id) {
		String sql = "select * from Student where id = ?";
		Student student = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new StudentMapper());
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		String sql = "select * from  Student";
		List<Student> students = jdbcTemplateObject.query(sql, new StudentMapper());
		return students;
	}

	@Override
	public void delete(int id) {
		String sql = "delete from Student where id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Deleted record with ID " + id);

	}

	@Override
	public void update(int id, int age) {
		String sql = "update Student set age = ? where id = ?";
		jdbcTemplateObject.update(sql, age, id);

	}

}
