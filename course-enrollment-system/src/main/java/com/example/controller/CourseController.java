package com.example.controller;

import com.example.dto.AccountDto;
import com.example.dto.CourseDto;
import com.example.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    private final ModelMapper mapper = new ModelMapper();
    @PostMapping("/add")
    @CrossOrigin
    private ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto) {
        courseService.addCourse(courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    @CrossOrigin
    private ResponseEntity<CourseDto> getCourse(@RequestParam Long id ){
        return new ResponseEntity<>(courseService.findByid(id), HttpStatus.OK);

    }
}
