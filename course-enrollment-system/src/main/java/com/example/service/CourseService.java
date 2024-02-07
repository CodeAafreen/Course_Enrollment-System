package com.example.service;

import com.example.dto.CourseDto;
import com.example.dto.StudentDto;
import com.example.dto.TeacherDto;
import com.example.entity.CourseEntity;
import com.example.entity.StudentEntity;
import com.example.entity.TeacherEntity;
import com.example.jpa.CourseRepo;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {
     @Resource
     private CourseRepo courseRepo;

     @Resource
     private StudentService studentService;

     @Resource
     private TeacherService teacherService;

     private final ModelMapper mapper = new ModelMapper();

     public List<CourseDto> findAll(){
//         return this.courseRepository.findAll();
         return this.courseRepo.findAll().stream().map(entity -> mapper.map(entity, CourseDto.class))
                 .collect(Collectors.toList());
     }

     public CourseDto findByid(Long courseId){
          CourseEntity byId = this.courseRepo.findById(courseId).orElse(null);

          if(byId != null){
               CourseDto dto = mapper.map(byId, CourseDto.class);
               List<StudentDto> students = byId.getStudentEntities().stream().map(entity -> mapper.map(entity, StudentDto.class)).toList();
               List<TeacherDto> teachers = byId.getTeacherEntityList().stream().map(entity -> mapper.map(entity, TeacherDto.class)).toList();
               dto.setStudentDtoList(students);
               dto.setTeacherDtolist(teachers);
               return dto;
         }
          return null;
     }

     public void removeStudent(Long studentId, Long courseId){
          CourseEntity courseEntity = courseRepo.findById(courseId).orElse(null);
          StudentEntity byId = mapper.map(studentService.findById(studentId), StudentEntity.class);

          if(byId != null &&  courseEntity != null){
               courseEntity.getStudentEntities().remove(byId);
               courseRepo.save(courseEntity);
          }
     }

     public void removeTeacher(Long teacherId, Long courseId){
          CourseEntity courseEntity = courseRepo.findById(courseId).orElse(null);
          TeacherEntity teacher = mapper.map(teacherService.findById(teacherId), TeacherEntity.class);

          if(teacher != null &&  courseEntity != null){
               courseEntity.getTeacherEntityList().remove(teacher);
               courseRepo.save(courseEntity);
          }
     }

     public void addCourse(CourseDto courseDto){
          CourseEntity entity = mapper.map(courseDto, CourseEntity.class);
          courseRepo.save(entity);
     }
}
