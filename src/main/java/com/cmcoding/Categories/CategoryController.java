package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;

import java.util.Arrays;
import java.util.List;

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

}
