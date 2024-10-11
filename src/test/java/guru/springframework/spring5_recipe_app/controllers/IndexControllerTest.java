package guru.springframework.spring5_recipe_app.controllers;

import aj.org.objectweb.asm.ByteVector;
import guru.springframework.spring5_recipe_app.Repository.RecipeRepository;
import guru.springframework.spring5_recipe_app.Service.RecipeService;
import guru.springframework.spring5_recipe_app.bootstrap.RecipeBootstrap;
import guru.springframework.spring5_recipe_app.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.test.web.reactive.server.WebTestClient;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception{
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();



        webTestClient.get()
                .uri("/")
                .exchange() // Execute the request
                .expectStatus().isOk() // Check if the response status is 200 OK
                .expectBody(String.class).isEqualTo("index"); // Check if the body is "Hello World"
    }

    @Test
    void getIndexPage() {

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        recipes.add(recipe);

       when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);


        String viewName = controller.getIndexPage(model);

        assertEquals("index", viewName);
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();

        assertEquals(2, setInController.size());

    }
}