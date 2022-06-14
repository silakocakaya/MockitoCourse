package com.data.api;

import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos(String user);
	public String getTodo(String todoId);
	public void deleteTodo(String todo);
}
