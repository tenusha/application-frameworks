package com.sliit.af.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sliit.af.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
