/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Message;
import com.example.demo.service.MessageService;

/**
 * @author it16166752
 *
 */
@RestController
@RequestMapping(value = "/messages")
public class MessageController {

	@Autowired
	MessageService messageService;

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@PostMapping("")
	public boolean add(@RequestBody Message message) {
		boolean result = false;
		try {
			result = messageService.addMessage(message);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> get(@PathVariable("id") String id) {
		ResponseEntity<Message> responseEntity = null;
		try {
			responseEntity = new ResponseEntity<Message>(messageService.getMessageById(id), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		return responseEntity;
	}
}
