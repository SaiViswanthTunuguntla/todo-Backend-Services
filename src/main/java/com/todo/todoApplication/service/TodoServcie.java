package com.todo.todoApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todoApplication.dto.TodoBean;
import com.todo.todoApplication.repository.TodoRepository;

@Service
public class TodoServcie {

	@Autowired
	TodoRepository todoRepo;
	public List<TodoBean> getAllTodos() {
		
		return todoRepo.getAllTodos();
	}
	public TodoBean createTodo(TodoBean todo) {
		TodoBean todoCreated = null;
		if(todo!=null) 
		{
		 todoCreated = todoRepo.Save(todo);
		}
		
		return todoCreated;
	}
	public TodoBean getTodo(int id) {
			return todoRepo.getTodo(id);
			
	}
	public TodoBean updateTodo(int id, TodoBean todo2) {

		return todoRepo.update(todo2,id);
	}
	public TodoBean deleteTodo(int id) {
		TodoBean isdeleted = todoRepo.deleteTodo(id);
		return isdeleted;
	}

}
