package com.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.data.api.TodoService;

public class TodoBusinessImplMockitoTest {

	@Test
	public void testSpring_UsingMockito() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance", "Test Spring");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(3, todos.size());
		
		
		List<String> todoList = todoService.retrieveTodos("Ranga");
		assertArrayEquals(allTodos.toArray(), todoList.toArray());
		
		when(todoService.getTodo("Id1")).thenReturn("Wake Up");
		assertEquals("Wake Up", todoService.getTodo("Id1"));
	}
	
	@Test
	public void testSpring_UsingBDD() {
		
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance", "Test Spring");
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		//when
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		
		//then
		assertThat(todos.size(), is(3));
	}
	
	@Test
	public void testDeleteSpring_UsingMockito() {
		
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance", "Test Spring");

		//given(todoService.retrieveTodos("Sila")).willReturn(allTodos);
		when(todoService.retrieveTodos("Sila")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Sila");
		
		//verify -> then ve should ile de yazilabiliyor
		verify(todoService).deleteTodo("Learn to Dance");
		then(todoService).should().deleteTodo("Learn to Dance");
		
		verify(todoService, Mockito.never()).deleteTodo("Test Spring");
		then(todoService).should(never()).deleteTodo("Test Spring");
		
		verify(todoService, Mockito.atLeastOnce()).deleteTodo("Learn to Dance");
		then(todoService).should(atLeastOnce()).deleteTodo("Learn to Dance");
		
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
	}
	
	@Test
	public void captureArgument() {
		
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		
		verify(todoService).deleteTodo(argumentCaptor.capture());
		
		assertEquals("Learn to Dance", argumentCaptor.getValue());
		
		assertThat(argumentCaptor.getValue(), is("Learn to Dance"));
	}
	
	@Test
	public void captureArgument_Multi() {
		
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		
		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance", "Learn XX");
		
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		
		verify(todoService, times(2)).deleteTodo(argumentCaptor.capture());
		
		assertThat(argumentCaptor.getAllValues().size(), is(2));
	}
	
	
}