package com.data.api;

import java.util.List;

//External Service - Lets say this comes from WunderList
public interface TodoService {
	public List<String> retrieveTodos(String user);
	public String getTodo(String todoId);
	public void deleteTodo(String todo);
}
