package guru.springframework.domain;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.Category;

public class CategoryTest {
	
	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() {
		Long idValue = 4l;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}
	
	@Test
	public void getDescription() {
		
	}
	
	@Test
	public void getRecipes() {
		
	}
}
