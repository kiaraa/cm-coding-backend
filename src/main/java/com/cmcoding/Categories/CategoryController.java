package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryController {

    TipCategory cat1 = new TipCategory(1, "Bones", Arrays.asList(new Tip(1, "Drink milk"), new Tip(2, "Don't break em!"), new Tip(3, "Osteoperosis is a bitch")));
    TipCategory cat2 = new TipCategory(2, "General Health", Arrays.asList(new Tip(4, "Eat vegetables"), new Tip(5, "Eat fruits")));

    @GetMapping("/categories/{catId}/tips/{tipId}")
    public Tip getSingleTipById(@PathVariable("catId") int catId, @PathVariable("tipId") int tipId) {
        List<TipCategory> allCategories = getAllCategories();
        for (TipCategory category : allCategories) {
            for (Tip tip : category.getTips()) {
                if (tip.getId() == tipId) {
                    return tip;
                }
            }
        }
        return null;
    }

    @GetMapping(value = "/categories/{id}")
    public TipCategory getCategoryById(@PathVariable("id") int catId) {
        List<TipCategory> allCategories = getAllCategories();
        for (TipCategory category : allCategories) {
            if (category.getId() == catId) {
                return category;
            }
        }
        return null;
    }

    @GetMapping(value = "/categories/{id}/tips")
    public List<Tip> getCategoryTips(@PathVariable("id") int catId) {
        TipCategory category = getCategoryById(catId);
        return category.getTips();
    }

    @GetMapping("/categories")
    public List<TipCategory> getAllCategories() {
        List<TipCategory> allCategories = new ArrayList<>();
        allCategories.add(cat1);
        allCategories.add(cat2);
        return allCategories;
    }
}
