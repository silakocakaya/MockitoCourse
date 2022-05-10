package com.business;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.util.ArrayList;
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
		
		assertThat("", isEmptyString());
		
		Integer[] marks = {1,2,3};
		assertThat(marks, arrayWithSize(3));
	
	}

}
