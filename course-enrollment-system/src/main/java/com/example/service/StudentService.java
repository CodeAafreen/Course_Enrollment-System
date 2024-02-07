package com.example.service;

import com.example.dto.CourseDto;
import com.example.dto.StudentDto;
import com.example.dto.TeacherDto;
import com.example.entity.StudentEntity;
import com.example.jpa.StudentRepo;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Resource
    private StudentRepo studentRepo;

    private final ModelMapper mapper = new ModelMapper();

    public List<CourseDto> findCourseByStudent(Long studentId){
        StudentEntity studentEntity = studentRepo.findById(studentId).orElse(null);
        if (studentEntity != null) {
            return studentEntity.getCourseEntityList().stream().
                    map(courseEntity -> mapper.map(courseEntity, CourseDto.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public Integer findCourseCount(Long studentId){
        StudentEntity studentEntity = studentRepo.findById(studentId).orElse(null);
        if (studentEntity != null) {
            return studentEntity.getCourseEntityList().size();
        }
        return null;
    }

    public List<StudentDto> findAll(){
//         return this.courseRepository.findAll();
        return this.studentRepo.findAll().stream().map(entity -> mapper.map(entity, StudentDto.class))
                .collect(Collectors.toList());
    }

    public StudentDto findById(Long studentId){
        StudentEntity studentEntity = this.studentRepo.findById(studentId).orElse(null);
        if(studentEntity != null) {
            return mapper.map(studentEntity, StudentDto.class);
        }
        return null;
    }

    public void addStudent(StudentDto studentDto){
        StudentEntity entity = mapper.map(studentDto, StudentEntity.class);
        studentRepo.save(entity);
    }


    public void save(StudentEntity studentEntity) {
        studentRepo.save(studentEntity);
    }
}
