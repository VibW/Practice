package com.prolifics.jdbctemp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) ctx.getBean("studentJDBCTemplate");

		System.out.println("------Records Creation--------");
		//studentJDBCTemplate.create("Vibhor", 11);
		/*studentJDBCTemplate.create("Niteesh", 2);
		studentJDBCTemplate.create("Sachin", 15);*/

		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.getAllStudents();

		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}

		System.out.println("----Updating Record with ID = 17 -----");
		studentJDBCTemplate.update(17, 20);
		
		Student student = studentJDBCTemplate.getStudent(17);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());
		
		studentJDBCTemplate.delete(17);

		/*System.out.println("----Listing Record with ID = 8 -----");
		Student student = studentJDBCTemplate.getStudent(8);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());*/
	}

}
