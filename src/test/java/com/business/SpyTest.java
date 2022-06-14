package com.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void creatingASpyOnArrayList() {
		
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Test");
		verify(listSpy).add("Test");
	}
	
	@Test
	public void creatingAMockOnArrayList() {
		
		List<String> listMock = mock(ArrayList.class);
		listMock.add("Test");
		verify(listMock).add("Test");
		
//		Asagidakiler hata veriyor
//		stub(listMock.get(0)).toReturn("Test");
//		when(listMock.get(0)).thenReturn("Test");
//		assertEquals(1, listMock.size());
	}

	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");

		stub(listSpy.size()).toReturn(-1);

		assertEquals(-1, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));

		// @Spy Annotation
	}
	
	@Test
	public void creatingAMockOnArrayList_overridingSpecificMethods() {
		List<String> listMock = mock(ArrayList.class);
		listMock.add("Ranga");
		listMock.add("in28Minutes");

		stub(listMock.size()).toReturn(-1);

		stub(listMock.get(0)).toReturn("Sila");
		assertEquals(-1, listMock.size());
		assertEquals("Sila", listMock.get(0));

		// @Spy Annotation
	}

}
