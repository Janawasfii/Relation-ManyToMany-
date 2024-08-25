package com.example.relationonetooneex.Controller;

import com.example.relationonetooneex.Model.Course;
import com.example.relationonetooneex.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/course")

public class CourseController {
private final CourseService courseService;


@GetMapping("/get")
public ResponseEntity getAllCourses() {
    return ResponseEntity.ok(courseService.getAllCourses());
}

@PostMapping("/add")
    public ResponseEntity addCourse( @Valid @RequestBody Course course) {
    courseService.addCourse(course);
    return ResponseEntity.status(200).body("Successfully added course");
}

@PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course) {
    courseService.updateCourse(course, id);
    return ResponseEntity.status(200).body("Successfully updated course");
}

@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
    courseService.deleteCourse(id);
    return ResponseEntity.status(200).body("Successfully deleted course");

}

@PutMapping("/{teacher_id}/assign/{course_id}")
public ResponseEntity assignTeacherToCourses(@PathVariable Integer teacher_id, @PathVariable Integer course_id) {
    courseService.assignTeacherToCourses(teacher_id,course_id);
    return ResponseEntity.status(200).body("Successfully assigned teacher to course");

}

@GetMapping("/get-course/{id}")
    public ResponseEntity findTeacherByCourseId(@PathVariable Integer id) {
    return ResponseEntity.status(200).body(courseService.findTeacherByCourseId(id));
}
@PutMapping("{student_id}/assigns/{course_id}")
public ResponseEntity assignCourseAndStudent(@PathVariable Integer student_id, @PathVariable Integer course_id) {
    courseService.assignCourseAndStudent(student_id,course_id);
    return ResponseEntity.status(200).body("Successfully assigned course and Student");
}

}
