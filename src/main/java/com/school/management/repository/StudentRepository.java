package com.school.management.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.management.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByName(String name);
	
	List<Student> findByStudentIdGreaterThan(Integer studentId);
	
	/*
	 * @Query("from Student where name=?1") List<Student>
	 * findByStudentNameOrdered(String name);
	 */
	List<Student> findAllByRegistrationDate(Date registrationDate);
	 
    List<Student> findAllByRegistrationTimeBetween(Date registrationTimeStart,Date registrationTimeEnd);
 
    @Query("select s from STUDENTDETAILS s where s.sessionStartDateTime <= :sessionStartDateTime")
    List<Student> findAllWithCreationDateTimeBefore(@Param("sessionStartDateTime") Date sessionStartDateTime);	

}
