/**
 * 
 */
package com.school.management.service;

import java.util.List;

import com.school.management.bean.Student;

/**
 * @author nitin
 *
 */
public interface StudentService {

	public List<Student> getAllStudents();
	
	public Student saveStudent( Student student);
	
	public Student getStudent( Integer studentId );

	public List<Student> deleteStudentById( Integer studentId );

}