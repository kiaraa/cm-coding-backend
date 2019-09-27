package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CategoryController {

    TipCategory cat1 = new TipCategory(1, "Test category 1", Arrays.asList(new Tip(4, "This is altogether too many things in this line.")));
    TipCategory cat2 = new TipCategory(2, "Test category 2", Arrays.asList(new Tip(3, "This is altogether too many things in this other line."), new Tip(5, "You absolute pedant.")));

    public Tip getSingleTipById(int catId, int tipId) {
        if (tipId == 2) {
            return new Tip(tipId, "test tip");
        }
        else {
            return new Tip(3, "test tip 2");
        }
    }

    public TipCategory getCategoryById(int catId) {
        if (catId == 1) {
            return cat1;
        }
        else {
            return cat2;
        }
    }

    public List<Tip> getCategoryTips(int catId) {
        if (catId == 1) {
            return cat1.getTips();
        }
        else {
            return cat2.getTips();
        }
    }

    @GetMapping("/categories")
    public List<TipCategory> getAllCategories() {
        TipCategory example1 = new TipCategory(1, "General health", Arrays.asList(new Tip(1, "Eat vegetables"), new Tip(2, "Eat fruits")));
        TipCategory example2 = new TipCategory(2, "Bones", Arrays.asList(new Tip(3, "Drink milk"), new Tip(4, "Don't break em!"), new Tip(5, "Osteoperosis is a bitch")));
        List<TipCategory> allCategories = new ArrayList<>();
        allCategories.add(example1);
        allCategories.add(example2);
        return allCategories;
    }
}
