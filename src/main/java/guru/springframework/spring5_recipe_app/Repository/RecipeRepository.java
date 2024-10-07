package guru.springframework.spring5_recipe_app.Repository;

import guru.springframework.spring5_recipe_app.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
