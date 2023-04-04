package com.example.StudentRESTAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentRESTAPI.Model.Student;
import com.example.StudentRESTAPI.rRepository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	StudentRepository studentRepositroy;

	@PostMapping("/Student")
	public String createNewStudent(@RequestBody Student student) {
		studentRepositroy.save(student);
		return "student Data Store";
	}

	 @GetMapping("/Student_Info")
	 public ResponseEntity<java.util.List<Student>> getAllStudent(){
	 List<Student> studList=new ArrayList<>();
	 studentRepositroy.findAll().forEach(studList::add);
	 return new ResponseEntity<List<Student>>(studList,HttpStatus.OK);
	 }

	 @GetMapping("/Student/{student_Id}")
	 public ResponseEntity<Student> getStduentById(@PathVariable int student_Id)
	 {
		 Optional<Student> stud=studentRepositroy.findById(student_Id);
		 if(stud.isPresent()) {
		 return new ResponseEntity<Student>(stud.get(),HttpStatus.FOUND);
		 }else {
			 return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	   }
	 }
	 
	 @PutMapping("/Student")
	 public void updateStudentById(@RequestBody Student student )
	 {
		 /*Optional<Student> stud=studentRepositroy.findById(student_Id);
		 if(stud.isPresent())
		 {
			 Student existStud=stud.get();
			 existStud.setStudent_Name(student.getStudent_Name());
			 existStud.setStudent_City(student.getStudent_City());
		
			 studentRepositroy.save(existStud);
			 
			 return "Employee Details against ID"+ student_Id +"Update";
		 }else {
			 return "Student Details does not exist for studentID"+student_Id;
		 }
			 
		 }*/
		 studentRepositroy.save(student);
	 }  
}	 

