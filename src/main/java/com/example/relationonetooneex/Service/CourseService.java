package com.example.relationonetooneex.Service;

import com.example.relationonetooneex.API.APIException;
import com.example.relationonetooneex.Model.Course;
import com.example.relationonetooneex.Model.Student;
import com.example.relationonetooneex.Model.Teacher;
import com.example.relationonetooneex.Repository.CourseRepository;
import com.example.relationonetooneex.Repository.StudentRepository;
import com.example.relationonetooneex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course, Integer id) {
       Course c = courseRepository.findCourseById(id);
        if (c == null) {
            throw new APIException("Teacher not found");
        }
        course.setName(course.getName());
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new APIException("Course not found");
        }
        courseRepository.delete(course);
        }


    public void assignTeacherToCourses(Integer course_id, Integer teacher_id){
        Course c = courseRepository.findCourseById(course_id);
        Teacher t = teacherRepository.findTeacherById(teacher_id);
        if (c == null || t == null) {
            throw new APIException("Course not found");
        }
        c.setTeacher(t);
        courseRepository.save(c);
    }

    public String findTeacherByCourseId(Integer id) {
        Course c = courseRepository.findCourseById(id);
        if (c == null || c.getTeacher() == null) {
            throw new APIException("Course not found");
        }
        return c.getTeacher().getName();
    }

    public void assignCourseAndStudent(Integer course_id, Integer student_id){
        Course c = courseRepository.findCourseById(course_id);
        Student s = studentRepository.findStudentById(student_id);
        if(c==null || s==null){
            throw new APIException("Course or Student not found");
        }
        c.getStudents().add(s);
        s.getCourse().add(c);
        studentRepository.save(s);
        courseRepository.save(c);
    }





    }

