package com.school.management.dao;

import java.util.List;

import com.school.management.bean.Student;

public interface StudentDAO {

	public List<Student> getAllStudents();

	public Student saveStudent(Student student);

	public Student getStudent(Integer studentId);

	public Student deleteStudentById(Integer studentId);

}
