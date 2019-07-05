package guru.springframework.services;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.databind.Module.SetupContext;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeServiceImpl;

public class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Before
	public void SetupContext() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void getRecipes() throws Exception {
		Recipe recipe = new Recipe();
		HashSet recipesData = new HashSet();
		recipesData.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(recipesData);
		
		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}
}
