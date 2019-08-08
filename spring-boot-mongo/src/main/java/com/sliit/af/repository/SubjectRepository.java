package com.sliit.af.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sliit.af.model.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject,String>{

}
