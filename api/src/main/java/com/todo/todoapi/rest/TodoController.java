package com.todo.todoapi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.todo.todoapi.model.Todo;
import com.todo.todoapi.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoRepository repository;
	
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return repository.save(todo);
	}
	
	
	@GetMapping
	public List<Todo> getAll(){
		return repository.findAll();
	}
	
	
	@GetMapping("{id}")
	public Todo getById(Long id) {
		return repository
				.findById(id)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
