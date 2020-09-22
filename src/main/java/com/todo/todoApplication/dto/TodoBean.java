package com.todo.todoApplication.dto;

public class TodoBean {
	
	private int id;
	private String task;
	//	private Date date;
	private boolean isDone;
	
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
//	public List<Product> getProductList() {
//		return productList;
//	}
//	public void setProductList(List<Product> productList) {
//		this.productList = productList;
//	}
	public TodoBean(String task, boolean isDone,int id) {
		super();
		this.task = task;
		this.isDone = isDone;
		this.id= id;
	}
	@Override
	public String toString() {
		return "TodoBean [task=" + task +  ", isDone=" + isDone + "]";
	}
	
	
	
	
	
}
