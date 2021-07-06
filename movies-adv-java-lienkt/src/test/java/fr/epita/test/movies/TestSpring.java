package fr.epita.test.movies;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test spring
 * @author LienKT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestSpring {
	
	
	@Inject
	@Named("firstQuery")
	String query;
	
	@Test
	public void firstTest() {
		Assert.assertTrue(query != null);
		System.out.println(query);
	}

}