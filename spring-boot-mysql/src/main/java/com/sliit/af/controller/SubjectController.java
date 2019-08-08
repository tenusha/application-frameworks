package com.sliit.af.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliit.af.model.Subject;
import com.sliit.af.repository.SubjectRepository;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	SubjectRepository subjectRepository;

	@PostMapping
	public ResponseEntity<Subject> saveCourse(@RequestBody Subject subject) {
		Subject sub = subjectRepository.save(subject);
		return ResponseEntity.ok().body(sub);

	}

	@GetMapping
	public ResponseEntity<List<Subject>> protectedData() {
		return ResponseEntity.ok().body(subjectRepository.findAll());
	}
}
