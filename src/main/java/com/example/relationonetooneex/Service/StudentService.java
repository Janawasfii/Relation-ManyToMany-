package com.example.relationonetooneex.Service;

import com.example.relationonetooneex.API.APIException;
import com.example.relationonetooneex.Model.Course;
import com.example.relationonetooneex.Model.Student;
import com.example.relationonetooneex.Repository.CourseRepository;
import com.example.relationonetooneex.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.org.jline.utils.Colors.s;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public void addStudent(Student student) {

        studentRepository.save(student);
    }

    public void updateStudent(Student student,Integer id) {
        Student s = studentRepository.findStudentById(id);
        if(s==null){
            throw new APIException("Student not found");
        }
        s.setName(student.getName());
        s.setMajor(student.getMajor());
        s.setAge(student.getAge());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id) {
        Student s = studentRepository.findStudentById(id);
        if(s==null){
            throw new APIException("Student not found");
        }
        studentRepository.delete(s);
    }

    public void changeStudentMajor(Integer studentId, String major){
        Student s = studentRepository.findStudentById(studentId);
        if(s==null){
            throw new APIException("Student not found");
        }
        s.setMajor(major);
       for(Course c: s.getCourse()){
           c.getStudents().remove(s);
           courseRepository.save(c);
       }
       s.setCourse(null);
       studentRepository.save(s);
    }

    public List<Student> findStudentByCourseId(Integer courseId) {
        List<Student> students = studentRepository.findStudentsByCourseId(courseId);
        if(students.isEmpty()){
            throw new APIException("Student not found");
        }
        return students;
    }




}
