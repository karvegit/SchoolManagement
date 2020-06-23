package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.school.management.bean.Student;

@Service
public class StudentService {
	
	private static int studentCount = 5;
	private static List<Student> studentsList = new ArrayList<>();

	static {
		studentsList.add(new Student(1, "Nitin Karve1", "Pune", "MCA", "I"));
		studentsList.add(new Student(2, "Nitin Karve2", "Bpl", "BCA", "II"));
		studentsList.add(new Student(3, "Nitin Karve3", "Nashik", "MBA", "III"));
		studentsList.add(new Student(4, "Nitin Karve4", "Akola", "CA", "IV"));
		studentsList.add(new Student(5, "Nitin Karve5", "Nagpur", "BBA", "II"));
	}

	public List<Student> getAllStudents(){
		return studentsList;
	}
	
	public Student saveStudent( Student student) {
		
		if(student.getStudentId() == null) {
			studentCount++;
			student.setStudentId(studentCount);
		}
		studentsList.add(student);
		return student;

	}
	
	public Student getStudent( Integer studentId ) {
		
		for(Student student : studentsList) {
			if( student.getStudentId() == studentId )
				return student;
		}
		return null;
	}
	
}
