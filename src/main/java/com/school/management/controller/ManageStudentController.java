package com.school.management.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.school.management.Exception.StudentNotFoundException;
import com.school.management.bean.Student;
import com.school.management.service.StudentService;

@RestController
public class ManageStudentController {
	
	@Autowired
	private StudentService studentService;

	//@RequestMapping(method = RequestMethod.GET , path = "/students")
	/*
	 * @GetMapping(path = "/students") public String getStudents() {
	 * 
	 * return "Nitin Karve";
	 * 
	 * }
	 * 
	 * @GetMapping(path = "/students1") public Student getStudents1() {
	 * 
	 * return new Student("Nitin Karve","Pune","MCA", "III");
	 * 
	 * }
	 * 
	 * 
	 * @GetMapping(path = "/students/{id}") 
	 * public String getStudentByID( @PathVariable String id) {
	 * 
	 * return "Nitin Karve: "+ id;
	 * 
	 * }
	 */

	 @GetMapping(path = "/students") 
	 public List<Student> getStudents() {

		 return studentService.getAllStudents();

	 }

	 @GetMapping(path = "/students/{studentId}") 
	 public Student getStudentByID( @PathVariable Integer studentId) {

		 Student student = studentService.getStudent( studentId );
		 if( student == null )
			 throw new StudentNotFoundException("Student not found:"+studentId);
		 
		 return student;

	 }

	 @PostMapping(path = "/students")
	 public ResponseEntity<Student> createStudent( @RequestBody Student student ) {

		 Student newStudent = studentService.saveStudent( student );
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentId}").buildAndExpand(newStudent.getStudentId()).toUri();
		 
		 return ResponseEntity.created(location).build();
		 
		 //return ResponseEntity.created(location).body(newStudent);
		 
		 //HttpHeaders headers = new HttpHeaders();
		 
		 //headers.setLocation(location);
		 //headers.add("custom-header", "Test");

		 //return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newStudent);
		 
	 }



}
