package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;

public class CategoryController {

    public Tip getSingleTipById(int catId, int tipId) {
        if (tipId == 2) {
            return new Tip(tipId, "test tip");
        }
        else {
            return new Tip(3, "test tip 2");
        }
    }

}
