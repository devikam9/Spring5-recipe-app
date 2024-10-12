package guru.springframework.spring5_recipe_app.Service;

import guru.springframework.spring5_recipe_app.Repository.RecipeRepository;
import guru.springframework.spring5_recipe_app.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        // It initialises Mock Recipe Repository
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);

    }

    @Test
    void getRecipes() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        Long id = 0L;
        for(Recipe r:recipes) {
           id = r.getId();
        }

        assertEquals(recipes.size(), 1);
        verify(recipeRepository,times(1)).findAll();
    }
}