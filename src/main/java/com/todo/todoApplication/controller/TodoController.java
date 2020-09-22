package com.todo.todoApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todoApplication.dto.TodoBean;
import com.todo.todoApplication.service.TodoServcie;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	private TodoServcie todoService;
	
	@GetMapping("/todo/{id}")
	public TodoBean getTodo(@PathVariable int id) {
		TodoBean todo = todoService.getTodo(id);
		return todo;
	}
	
	@GetMapping("/todo")
	public List<TodoBean> getAllTodos() {
		List<TodoBean> allTodos = todoService.getAllTodos();
		return allTodos;
	}
	
	
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<Void>  deleteTodo(@PathVariable int id) {
		TodoBean deletedTodo = todoService.deleteTodo(id);
		if(deletedTodo!=null) {
			return  new  ResponseEntity<>(HttpStatus.OK);
		}
		return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/todo/{id}")
	public ResponseEntity<TodoBean> updateTodo(@PathVariable int id,@RequestBody TodoBean todo) {
			TodoBean updatedTodo = todoService.updateTodo(id,todo);
				return new  ResponseEntity<TodoBean>(updatedTodo,HttpStatus.OK);
			
	}
	
	@PostMapping("/todo")
	public ResponseEntity<TodoBean> createTodo(@RequestBody TodoBean todo) {
		TodoBean todoadded = todoService.createTodo(todo);
			
		return new  ResponseEntity<TodoBean>(todoadded,HttpStatus.CREATED);
	}
	
	

	
	
	
	

}
