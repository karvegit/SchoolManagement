package com.school.management.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.bean.Student;
import com.school.management.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	public Student saveStudent(Student student) {

		return studentDAO.saveStudent(student);
	}

	public Student getStudent(Integer studentId) {

		return studentDAO.getStudent(studentId);
	}

	public List<Student> deleteStudentById(Integer studentId) {

		studentDAO.deleteStudentById(studentId);
		return studentDAO.getAllStudents();
		
	}

}
