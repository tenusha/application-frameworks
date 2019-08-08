package com.sliit.af.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sliit.af.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
