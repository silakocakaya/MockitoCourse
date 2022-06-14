package com.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		
		List mockList = mock(List.class);
		
		when(mockList.size()).thenReturn(2);
		assertEquals(2, mockList.size());
	}
	
	@Test
	public void letsMockListSizeMethod_MultipleReturns() {
		
		List mockList = mock(List.class);
		
		when(mockList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, mockList.size());
		assertEquals(3, mockList.size());
		
		assertThat(mockList.size(), is(3));
	}
	
	@Test
	public void letsMockListValueMethod() {
		
		List mockList = mock(List.class);
		
		when(mockList.get(0)).thenReturn("Test");
		assertEquals("Test", mockList.get(0));
		
		when(mockList.get(anyInt())).thenReturn("Test2");
		assertEquals("Test2", mockList.get(5));
	}
	
	@Test(expected = NullPointerException.class)
	public void letsMockListExceptionMethod() {
		
		List mockList = mock(List.class);
		when(mockList.get(anyInt())).thenThrow(NullPointerException.class);
		mockList.get(0);
	}
	
	@Test
	public void letsMockListValueMethod_BDD() {
		
		List<String> mockList = mock(List.class);
		
		//given  - setup part  
		given(mockList.get(0)).willReturn("Test_BDD");
		
		//when - invocation   
		String value = mockList.get(0);
		
		//then - readable assert  
		//assertEquals("Test_BDD", value);
		assertThat(value, is("Test_BDD"));
		assertThat(value, is("Test_BDD"));
	}

}
