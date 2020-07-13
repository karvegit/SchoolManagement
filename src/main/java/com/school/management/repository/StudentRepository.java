package com.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.management.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByName(String name);
	
	List<Student> findByStudentIdGreaterThan(Integer studentId);
	
	@Query("from Student where name=?1")
	List<Student> findByStudentNameOrdered(String name);

}
