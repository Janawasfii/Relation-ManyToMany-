package com.example.relationonetooneex.Controller;

import com.example.relationonetooneex.Model.Student;
import com.example.relationonetooneex.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
     public ResponseEntity getAllStudents() {
         return ResponseEntity.status(200).body(studentService.getAllStudents());
     }
     @PostMapping("/add")
     public ResponseEntity addStudent(@Valid @RequestBody Student student) {
         studentService.addStudent(student);
         return ResponseEntity.status(200).body("Student added successfully");
     }

     @PutMapping("/update/{id}")
     public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {
        studentService.updateStudent(student, id);
        return ResponseEntity.status(200).body("Student updated successfully");
     }
     @DeleteMapping("/delete/{id}")
     public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted successfully");
     }

     @PutMapping("/change/{studentId}/{major}")
     public ResponseEntity changeStudent(@PathVariable Integer studentId, @PathVariable String major) {
        return ResponseEntity.status(200).body("Student updated successfully");
     }

     @GetMapping("/get-Student/{courseId}")
    public ResponseEntity findStudentByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.status(200).body(studentService.findStudentByCourseId(courseId));
     }

}
