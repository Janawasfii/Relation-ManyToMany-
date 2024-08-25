package com.example.relationonetooneex.Controller;

import com.example.relationonetooneex.Model.Teacher;
import com.example.relationonetooneex.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/teacher")

public class TeacherController {

    private TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getTeacher(){

        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Successfully added teacher");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("Successfully updated teacher");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Successfully deleted teacher");
    }

    @GetMapping("/gets/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){

        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }


}
