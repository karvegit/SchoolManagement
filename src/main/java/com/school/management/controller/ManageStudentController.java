package com.school.management.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.school.management.Exception.StudentNotFoundException;
import com.school.management.bean.Student;
import com.school.management.bean.Subject;
import com.school.management.service.StudentServiceImpl;

@RestController
public class ManageStudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@Autowired
	private MessageSource messageSource;
	
	//@RequestMapping(method = RequestMethod.GET , path = "/students")
	/*
	 * @GetMapping(path = "/students") public String getStudents() {
	 * 
	 * return "Test";
	 * 
	 * }
	 * 
	 * @GetMapping(path = "/students1") public Student getStudents1() {
	 * 
	 * return new Student("Test1","Pune","MCA", "III");
	 * 
	 * }
	 * 
	 * 
	 * @GetMapping(path = "/students/{id}") 
	 * public String getStudentByID( @PathVariable String id) {
	 * 
	 * return "Test1: "+ id;
	 * 
	 * }
	 */

	 @GetMapping(path = "/students") 
	 public List<Student> getStudents() {

		 return studentService.getAllStudents();

	 }

	 @GetMapping(path = "/students/{studentId}") 
	 public EntityModel<Student> getStudentByID( @PathVariable Integer studentId) {

		 Student student = studentService.getStudentById( studentId );

		 if( student == null )
			 throw new StudentNotFoundException("Student not found:"+studentId);
		 
		 EntityModel<Student> resource = EntityModel.of(student);
		 
		 WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getStudents());
		 
		 resource.add(linkTo.withRel("all-students"));
		 
		 return resource;

	 }

	 @DeleteMapping(path = "/students/{studentId}") 
	 public ResponseEntity<List<Student>> deleteStudentByID( @PathVariable Integer studentId) {

		 List<Student> student = studentService.deleteStudentById( studentId );
		 if( student == null )
			 throw new StudentNotFoundException("Student not found:"+studentId);

		 URI location = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
		 HttpHeaders headers = new HttpHeaders();

		 headers.setLocation(location);
		 headers.add("custom-header", "Test");

		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(student);		 

	 }

	 @PostMapping(path = "/students")
	 public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student ) {

		 Student newStudent = studentService.saveStudent( student );
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentId}").buildAndExpand(newStudent.getStudentId()).toUri();
		 
		 return ResponseEntity.created(location).build();
		 
		 //return ResponseEntity.created(location).body(newStudent);
		 
		 //HttpHeaders headers = new HttpHeaders();
		 
		 //headers.setLocation(location);
		 //headers.add("custom-header", "Test");

		 //return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newStudent);

	 }

	 //This is an example of internationalization i18n
	 @GetMapping(path = "/locale")
	 public String getI18nExample(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {

		 return messageSource.getMessage("good.morning.message", null, locale);

	 }

	 @GetMapping(path = "/students/name/{studentName}") 
	 public CollectionModel<Student> getStudentByName( @PathVariable String studentName) {

		 List<Student> studentList = studentService.getStudentByName(studentName);
		 if( studentList == null )
			 throw new StudentNotFoundException("Student not found:"+studentName);

		 CollectionModel<Student> resource = CollectionModel.of(studentList);
		 
		 WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getStudents());
		 
		 resource.add(linkTo.withRel("all-students"));
		 
		 return resource;

	 }
	 
	 @GetMapping(path = "/students/greater/{studentId}") 
	 public CollectionModel<Student> getStudentByIdGreaterThan( @PathVariable Integer studentId) {

		 List<Student> studentList = studentService.getStudentByIdGreaterThan(studentId);
		 if( studentList == null )
			 throw new StudentNotFoundException("Student not found:"+studentId );

		 CollectionModel<Student> resource = CollectionModel.of(studentList);
		 
		 WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getStudents());
		 
		 resource.add(linkTo.withRel("all-students"));
		 
		 return resource;

	 }
	 
		/*
		 * @GetMapping(path = "/students/ordered/{direction}") public
		 * CollectionModel<Student> getByStudentNameOrdered( @PathVariable String
		 * direction) {
		 * 
		 * List<Student> studentList =
		 * studentService.getByStudentNameOrdered(direction); if( studentList == null )
		 * throw new StudentNotFoundException("Student not found:"+direction );
		 * 
		 * CollectionModel<Student> resource = CollectionModel.of(studentList);
		 * 
		 * WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getStudents());
		 * 
		 * resource.add(linkTo.withRel("all-students"));
		 * 
		 * return resource;
		 * 
		 * }
		 */	 
	 @GetMapping(path = "/students/{studentId}/subjects") 
	 public List<Subject> getStudentsSubjects( @PathVariable Integer studentId) {

		 Optional<Student> student = studentService.getStudentsSubjects( studentId );
		 if( !student.isPresent() )
			 throw new StudentNotFoundException("Student not found:"+studentId);
		 
		 return student.get().getSubjects();

	 }
	 
}
