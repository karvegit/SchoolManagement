package com.school.management.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.school.management.bean.Student;
import com.school.management.bean.Subject;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryIntegrationTest {

	@Autowired
	private StudentRepository repository;

	@Test
	public void whenFindByRegistrationDate_thenStudent1Returned() throws ParseException {
		List<Subject> subjectList = new ArrayList<>();
		Subject subject1 = new Subject(101, "Maths", "Maths Subject");
		Subject subject2 = new Subject(102, "Maths", "Maths Subject");
		subjectList.add(subject1);
		subjectList.add(subject2);

		Student student = new Student(1, "Gavin", "Bpl", "MCA", "2010", new Date(), new Date(), new Date(),
				subjectList);

		repository.save(student);

		List<Student> result = repository
				.findAllByRegistrationDate(new SimpleDateFormat("dd-MM-yyyy").parse("14-07-2020"));

		assertEquals(1, result.size());
	}

}
