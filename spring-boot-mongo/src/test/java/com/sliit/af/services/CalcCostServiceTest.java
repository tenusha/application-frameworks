package com.sliit.af.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sliit.af.model.Course;
import com.sliit.af.model.Subject;
import com.sliit.af.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalcCostServiceTest {

	@Autowired
	CalcCostService calcCostService;
	@MockBean
	CourseRepository courseRepository;
@Before
public void setup() {
	Optional<Subject> s1 = Optional.of(new Subject("sname", "des", 40));
	List<Subject> l = new ArrayList();
	boolean add = l.add(s1.get());
	Optional<Course> c1 = Optional.of(new Course("name", "", 0, "lec",l ));
	
	Mockito.when(courseRepository.findById("1")).thenReturn(c1);
	System.out.println(c1);
}
	@Test
	public void calcCostTest() {

		// put a valid id here
		String crsId = "1";
		//Course course = courseRepository.findById(crsId).get();
		//assertThat(course).isNotNull();
		double expected = 40;
		double actual = calcCostService.calcCost(crsId);

		assertEquals(expected, actual, 0.1);
	}

}
