package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import sun.util.logging.resources.logging;

@Slf4j
@Controller
public class RecipeController {

	RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping
	@RequestMapping("recipe/{id}/show")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(new Long(id)));
		
		return "recipe/show";
	}
	
	@GetMapping
	@RequestMapping("recipe/new")
	public String newRecipe (Model model) {
		model.addAttribute("recipe", new RecipeCommand());
		return "recipe/recipeform";
	}
	
	//@RequestMapping(name = "recipe", method = RequestMethod.POST)
	@PostMapping
	@RequestMapping("recipe")
	public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}
	
	@GetMapping
	@RequestMapping("recipe/{id}/update")
	public String updateRecipe(@PathVariable String id,  Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
		return "recipe/recipeform";
	}
	
	@GetMapping
	@RequestMapping("recipe/{id}/delete")
	public String deleteRecipe(@PathVariable String id, Model model) {
		log.debug("Deleting recipe id:" + id);
		
		recipeService.deleteById(Long.valueOf(id));
		return "redirect:/";
	}
	
}
