/**
 * 
 */
package com.school.management.service;

import java.util.List;

import com.school.management.bean.Student;

/**
 * @author
 *
 */
public interface StudentService {

	public List<Student> getAllStudents();
	
	public Student saveStudent( Student student);
	
	public Student getStudentById( Integer studentId );

	public List<Student> deleteStudentById( Integer studentId );
	
	public List<Student> getStudentByName( String studentName);

	public List<Student> getStudentByIdGreaterThan( Integer studentId);
	
	//public List<Student> getByStudentNameOrdered( String name );

}