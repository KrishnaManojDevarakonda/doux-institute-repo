package com.doux.managementspringbootAzureSql.studentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doux.managementspringbootAzureSql.exeptions.ResourceNotFoundException;
import com.doux.managementspringbootAzureSql.model.Student;
import com.doux.managementspringbootAzureSql.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public Student getStudentById(Long id) throws ResourceNotFoundException {
		Student requiredStudent = studentRepo.findById(id).get();
		if(requiredStudent==null)
			throw new ResourceNotFoundException("Student with the mentioned id not exist");
		return requiredStudent;
	}
	
	public Student postStudentDetails(Student student) {
		try {
		Student admittedStudent = studentRepo.save(student);
		return admittedStudent;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Student changeStudentDetails(Long id, Student student) throws ResourceNotFoundException {
		Student storedStudent = getStudentById(id);
		Student updatedStudent;
			storedStudent.setStudentName(student.getStudentName());
			storedStudent.setContactNumber(student.getContactNumber());
			storedStudent.setMailId(student.getMailId());
			storedStudent.setLocation(student.getLocation());
			updatedStudent = studentRepo.save(storedStudent);
			return updatedStudent;
		}
		
	
	
	public String removeStudentById(Long id) {
		try {
		studentRepo.deleteById(id);
		return "Sucessfully deleted";
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
