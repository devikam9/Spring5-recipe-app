package guru.springframework.spring5_recipe_app.Repository;

import guru.springframework.spring5_recipe_app.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
