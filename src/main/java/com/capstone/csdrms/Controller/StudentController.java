package com.capstone.csdrms.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.csdrms.Entity.StudentEntity;
import com.capstone.csdrms.Service.StudentService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
		@PostMapping("/insertStudent")
		public StudentEntity insertStudent(@RequestBody StudentEntity student) {
			return studentService.insertStudent(student);
		}
		
		@GetMapping("/getAllStudents")
		public List<StudentEntity> getAllStudents(){
			return studentService.getAllStudents();
		}
		
		@GetMapping("/getAllCurrentStudents")
		public List<StudentEntity> getCurrentStudents(){
			return studentService.getCurrentStudents();
		}
		
		@PutMapping("/update/{id}")
	    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentDetails) {
	        
	        // Call the service method to update the student
	        StudentEntity updatedStudent = studentService.updateStudent(id, studentDetails);
	        
	        return ResponseEntity.ok(updatedStudent);
	    }
		
		@DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteLatestAndSetPreviousAsCurrent(@PathVariable Long id) {
	        try {
	            studentService.deleteLatestAndSetPreviousAsCurrent(id);
	            return new ResponseEntity<>("Successfully deleted the latest student and updated the previous record.", HttpStatus.OK);
	        } catch (RuntimeException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>("An error occurred while processing the request.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
		
		
		  
//		@PutMapping("/updateStudent")
//		public StudentEntity updateStudent(@RequestParam String sid,@RequestBody StudentEntity newStudentDetails){
//			return sserv.updateStudent(sid, newStudentDetails);
//		}
		
//		@DeleteMapping("/deleteStudent/{sid}")
//		public String deleteStudent(@PathVariable String sid) {
//			return sserv.deleteStudent(sid);
//		}
		
		@GetMapping("/getCurrentStudent/{id}")
		public Optional<StudentEntity> getCurrentStudentById(@PathVariable Long id) {
			return studentService.getCurrentStudentById(id);
		}
		  
		 @GetMapping("/getAllStudentsByAdviser")
		 public List<StudentEntity> getStudentsByAdviser(@RequestParam int grade, @RequestParam String section,@RequestParam String schoolYear) {
			return studentService.getStudentsByAdviser(grade, section, schoolYear); 
		} 
		
		 
		 @GetMapping("/getStudentById/{id}")
		 public Optional<StudentEntity> getStudentById(@PathVariable Long id){
			 return studentService.getStudentById(id);
		 }
		 
		 @PostMapping("/import")
		    public ResponseEntity<?> importStudentData(@RequestParam("file") MultipartFile file, @RequestParam String schoolYear) {
		        try {
		        	studentService.importStudentData(file,schoolYear);  // Call service to process the Excel file
		            return ResponseEntity.ok("File uploaded and students imported successfully");
		        } catch (Exception e) {
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
		        } 
		    }
	
}