package guru.springframework.spring5_recipe_app.controllers;


import guru.springframework.spring5_recipe_app.Repository.RecipeRepository;
import guru.springframework.spring5_recipe_app.Service.RecipeService;

import guru.springframework.spring5_recipe_app.bootstrap.RecipeBootstrap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

//    private final RecipeRepository recipeRepository;
//    private final RecipeBootstrap recipeBootstrap;

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
//        this.recipeRepository = recipeRepository;
//        this.recipeBootstrap = recipeBootstrap;
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(Model model){

        log.debug("Getting Index page");
//        recipeRepository.saveAll(recipeBootstrap.getRecipes());

        model.addAttribute("recipes",recipeService.getRecipes());

        return "index";
    }
}
