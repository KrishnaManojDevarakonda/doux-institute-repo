package com.doux.managementspringbootAzureSql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doux.managementspringbootAzureSql.exeptions.ResourceNotFoundException;
import com.doux.managementspringbootAzureSql.model.Student;
import com.doux.managementspringbootAzureSql.studentService.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> fetchAllStudentDetails(){
		List<Student> response = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/studentById/{id}")
	public ResponseEntity<Student> fetchStudentById(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		Student response = studentService.getStudentById(id);
		return new ResponseEntity<Student>(response, HttpStatus.OK);
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student response = studentService.postStudentDetails(student);
		return new ResponseEntity<Student>(response, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Long id, @RequestBody Student student) throws ResourceNotFoundException{
		Student response = studentService.changeStudentDetails(id, student);
		return new ResponseEntity<Student>(response, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("removeStudent/{id}")
	public String removeStudent(@PathVariable(value = "id") Long id) {
		return studentService.removeStudentById(id);
	}

}
