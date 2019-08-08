package com.sliit.af.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliit.af.model.Course;
import com.sliit.af.model.Subject;
import com.sliit.af.repository.CourseRepository;

@Service
public class CalcCostService {

	@Autowired
	CourseRepository courseRepository;

	public double calcCost(String cid) {
		try {
			Course course = courseRepository.findById(cid).get();
			List<Subject> subjects = course.getSubjects();

			double cost = 0.0;
			for (Subject subject : subjects) {
				cost += subject.getAmount();
			}
			return cost;
		} catch (Exception e) {
			return -1;
		}
	}

}
