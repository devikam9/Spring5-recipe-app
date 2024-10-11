package guru.springframework.spring5_recipe_app.Service;

import guru.springframework.spring5_recipe_app.Repository.RecipeRepository;
import guru.springframework.spring5_recipe_app.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface RecipeService  {

   Set<Recipe> getRecipes();
}
