package com.school.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.bean.Student;
import com.school.management.dao.StudentDAO;
import com.school.management.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student saveStudent(Student student) {

		//return studentDAO.saveStudent(student);
		return studentRepository.save(student);
	}

	public Student getStudentById(Integer studentId) {

		//return studentDAO.getStudent(studentId);
		return studentRepository.getOne(studentId);
	}

	public List<Student> deleteStudentById(Integer studentId) {

		studentDAO.deleteStudentById(studentId);
		studentRepository.deleteById(studentId);
		return studentDAO.getAllStudents();		

	}

	public List<Student> getStudentByName( String studentName) {
		return studentRepository.findByName(studentName);
	}

	@Override
	public List<Student> getStudentByIdGreaterThan(Integer studentId) {
		return studentRepository.findByStudentIdGreaterThan( studentId );
	}

	/*
	 * @Override public List<Student> getByStudentNameOrdered(String name) { return
	 * studentRepository.findByStudentNameOrdered( name ); }
	 */
	public Optional<Student> getStudentsSubjects(Integer studentId) {

		//return studentDAO.getStudent(studentId);
		return studentRepository.findById(studentId);
	}

	
}
