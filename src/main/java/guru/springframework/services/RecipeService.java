package guru.springframework.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;

@Service
public interface RecipeService {
	Set<Recipe> getRecipes();
}
