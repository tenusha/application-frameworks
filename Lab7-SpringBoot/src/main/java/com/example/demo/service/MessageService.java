/**
 * 
 */
package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Message;
import com.example.demo.repository.MessageRepository;

/**
 * @author it16166752
 *
 */
@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;

	public boolean addMessage(Message message) {
		return (Objects.nonNull(messageRepository.save(message))) ? true : false;
	}
	
	public Message getMessageById(String id) {
		return messageRepository.findById(id).orElse(null);
	}
	
}
