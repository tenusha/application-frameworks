/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Message;

/**
 * @author it16166752
 *
 */
@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
	Message findByIdAndDeletedFalse(String id);
}
