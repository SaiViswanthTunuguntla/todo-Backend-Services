package com.todo.todoApplication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.todo.todoApplication.dto.TodoBean;

@Repository
public class TodoRepository {
	
	private static List<TodoBean> todos= new ArrayList<>();
	private static int id=1;
	static {
		
		TodoBean todoBean1 = new TodoBean("Todo Application", false, id++);
		TodoBean todoBean2 = new TodoBean("BackEnd Spring ,Java", true, id++);
		TodoBean todoBean3 = new TodoBean("front end Angular", false, id++);
		TodoBean todoBean4 = new TodoBean("Todo Application2", false, id++);
		TodoBean todoBean5 = new TodoBean("Todo Application3", false, id++);
		todos.add(todoBean1);
		todos.add(todoBean2);
		todos.add(todoBean3);
		todos.add(todoBean4);
		todos.add(todoBean5);
	}
	public List<TodoBean> getAllTodos() {
		
		return todos;
		
	}
	public TodoBean Save(TodoBean todo) {
		todo.setId(id++);
		boolean isAdded = todos.add(todo);
		return isAdded? todo:null;
		
	}
	public TodoBean getTodo(int id2) {
		for(TodoBean todo1: todos)
		{
			if(todo1.getId()==id2)
			{
				return todo1;
			}
		}
		return null;
		
	}
	public TodoBean update(TodoBean todo2, int id2) {
		TodoBean deleteTodo = deleteTodo(id2);
		if(deleteTodo!=null)
		{
			todos.add(todo2);
			return todo2;
		}
		
		return null;
	}
	
	public TodoBean deleteTodo(int id2) {
		TodoBean todo= getTodo(id2);
		if(todo==null) return null;
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}

}
