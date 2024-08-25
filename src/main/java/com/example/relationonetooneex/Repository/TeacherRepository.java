package com.example.relationonetooneex.Repository;

import com.example.relationonetooneex.Model.Course;
import com.example.relationonetooneex.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherById(Integer id);





}
