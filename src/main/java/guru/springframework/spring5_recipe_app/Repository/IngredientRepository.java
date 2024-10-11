package guru.springframework.spring5_recipe_app.Repository;

import guru.springframework.spring5_recipe_app.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
