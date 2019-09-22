package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class CategoryControllerTest {

    @Test
    public void testGetTip(){
        CategoryController categoryController = new CategoryController();

        Tip tip = categoryController.getSingleTipById(1,2);

        Assertions.assertThat(tip.getId()).isEqualTo(2);
        Assertions.assertThat(tip.getTip().equals("test tip"));
    }

    @Test
    public void testGetTipDifferentId(){
        CategoryController categoryController = new CategoryController();

        Tip tip = categoryController.getSingleTipById(1,3);

        Assertions.assertThat(tip.getId()).isEqualTo(3);
        Assertions.assertThat(tip.getTip()).isEqualTo("test tip 2");
    }
}