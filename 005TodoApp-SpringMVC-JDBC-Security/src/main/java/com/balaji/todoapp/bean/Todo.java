package com.balaji.todoapp.bean;

public class Todo {
	private Integer id;
	private String name;
	private String category;

	public Todo(String name, String category) {
		super();
		this.name = name;
		this.category = category;
	}

	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public Todo(Integer id, String name, String category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", category=" + category + "]";
	}

}
