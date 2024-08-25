package com.example.relationonetooneex.Service;

import com.example.relationonetooneex.API.APIException;
import com.example.relationonetooneex.Model.Teacher;
import com.example.relationonetooneex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

private final TeacherRepository teacherRepository;
    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null){
            throw new APIException("Teacher Not Found");
        }
        t.setEmail(teacher.getEmail());
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(teacher);
    }
    public void deleteTeacher(Integer id){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null){
            throw new APIException("Teacher Not Found");
        }
        teacherRepository.delete(t);
    }

    public Teacher getTeacherById(Integer id){
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null){
            throw new APIException("Teacher Not Found");
        }
        return t;
    }
}
