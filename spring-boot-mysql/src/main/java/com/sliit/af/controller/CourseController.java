package com.sliit.af.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliit.af.model.Course;
import com.sliit.af.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	CourseRepository courseRepository;

	@PostMapping
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		Course crs = courseRepository.save(course);
		return ResponseEntity.ok().body(crs);

	}

	@GetMapping
	public ResponseEntity<List<Course>> protectedData() {
		return ResponseEntity.ok().body(courseRepository.findAll());
	}
}
