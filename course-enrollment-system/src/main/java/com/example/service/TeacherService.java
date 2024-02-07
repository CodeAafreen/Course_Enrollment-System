package com.example.service;

import com.example.dto.CourseDto;
import com.example.dto.StudentDto;
import com.example.dto.TeacherDto;
import com.example.entity.StudentEntity;
import com.example.entity.TeacherEntity;
import com.example.jpa.TeacherRepo;
import com.example.repository.TeacherRepoImpl;
import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Resource
    private TeacherRepo teacherRepo;

    private final ModelMapper modelMapper = new ModelMapper();
    public List<CourseDto> findCourseByStudent(Long teacherId){
        TeacherEntity teacherEntity = teacherRepo.findById(teacherId).orElse(null);
        if (teacherEntity != null) {
            return teacherEntity.getCourseEntityList().stream().
                    map(courseEntity -> modelMapper.map(courseEntity, CourseDto.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public Integer findCourseCount(Long teacherId){
        TeacherEntity teacherEntity = teacherRepo.findById(teacherId).orElse(null);
        if (teacherEntity != null) {
            return teacherEntity.getCourseEntityList().size();
        }
        return null;
    }

    public List<TeacherDto> findAll(){
//         return this.courseRepository.findAll();
        return this.teacherRepo.findAll().stream().map(entity -> modelMapper.map(entity, TeacherDto.class))
                .collect(Collectors.toList());
    }

    public void addTeacher(TeacherDto teacherDto){
        TeacherEntity entity = modelMapper.map(teacherDto, TeacherEntity.class);
        teacherRepo.save(entity);
    }

    public TeacherDto findById(Long teacherID){
        TeacherEntity teacherEntity = this.teacherRepo.findById(teacherID).orElse(null);
        if(teacherEntity != null) {
            return modelMapper.map(teacherEntity, TeacherDto.class);
        }
        return null;
    }

    public void save(TeacherEntity teacherEntity) {
        teacherRepo.save(teacherEntity);
    }
}
