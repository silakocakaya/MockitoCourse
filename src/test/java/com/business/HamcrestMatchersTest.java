package com.business;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void testHamcrest() {
		
		List<Integer> scores = Arrays.asList(10,20,30,40);
		
		assertThat(scores, hasSize(4));
		assertThat(scores, contains(10,20,30,40));
		assertThat(scores, everyItem(greaterThan(5)));
		assertThat(scores, everyItem(lessThan(50)));
		
		assertThat(10, is(greaterThan(5)));

		assertThat(5, greaterThan(4));
		assertThat("", isEmptyString());
		
		Integer[] marks = {1,2,3};
		assertThat(marks, arrayWithSize(3));
	
	}

}

