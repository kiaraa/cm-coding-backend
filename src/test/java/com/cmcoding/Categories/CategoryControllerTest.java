package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    @Test
    public void testGetCategoryReturnsCategory(){
        CategoryController categoryController = new CategoryController();

        TipCategory category = categoryController.getCategoryById(1);

        Assertions.assertThat(category).isExactlyInstanceOf(TipCategory.class);
    }

    @Test
    public void testGetCategoryReturnsDifferentCategories(){
        CategoryController categoryController = new CategoryController();

        TipCategory category1 = categoryController.getCategoryById(1);
        TipCategory category2 = categoryController.getCategoryById(2);

        Assertions.assertThat(category1.getId()).isNotEqualTo(category2.getId());
    }

    @Test
    public void testGetCategoryReturnsGoodStubs() {
        CategoryController categoryController = new CategoryController();

        TipCategory cat1 = categoryController.getCategoryById(1);
        TipCategory cat2 = categoryController.getCategoryById(2);

        Assertions.assertThat(cat1.getId()).isEqualTo(1);
        Assertions.assertThat(cat1.getName()).isEqualTo("Test category 1");
        Assertions.assertThat(cat1.getTips().size()).isEqualTo(1);

        Assertions.assertThat(cat1.getTips().get(0).getId()).isEqualTo(4);
        Assertions.assertThat(cat1.getTips().get(0).getTip()).isEqualTo("This is altogether too many things in this line.");

        Assertions.assertThat(cat2.getId()).isEqualTo(2);
        Assertions.assertThat(cat2.getName()).isEqualTo("Test category 2");
        Assertions.assertThat(cat2.getTips().size()).isEqualTo(2);

        Assertions.assertThat(cat2.getTips().get(0).getId()).isEqualTo(3);
        Assertions.assertThat(cat2.getTips().get(0).getTip()).isEqualTo("This is altogether too many things in this other line.");

        Assertions.assertThat(cat2.getTips().get(1).getId()).isEqualTo(5);
        Assertions.assertThat(cat2.getTips().get(1).getTip()).isEqualTo("You absolute pedant.");
    }

    @Test
    public void testGetTipsFromCategory(){
        CategoryController categoryController = new CategoryController();

        List<Tip> category1Tips = categoryController.getCategoryTips(1);
        List<Tip> category2Tips = categoryController.getCategoryTips(2);

        Assertions.assertThat(category1Tips.size()).isEqualTo(1);
        Assertions.assertThat(category1Tips.get(0).getId()).isEqualTo(4);
        Assertions.assertThat(category1Tips.get(0).getTip()).isEqualTo("This is altogether too many things in this line.");

        Assertions.assertThat(category2Tips.size()).isEqualTo(2);

        Assertions.assertThat(category2Tips.get(0).getId()).isEqualTo(3);
        Assertions.assertThat(category2Tips.get(0).getTip()).isEqualTo("This is altogether too many things in this other line.");

        Assertions.assertThat(category2Tips.get(1).getId()).isEqualTo(5);
        Assertions.assertThat(category2Tips.get(1).getTip()).isEqualTo("You absolute pedant.");

    }

    @Test
    public void testGetCategories(){
        CategoryController categoryController = new CategoryController();

        List<TipCategory> categories = categoryController.getAllCategories();

        TipCategory example1 = new TipCategory(1, "General health", Arrays.asList(new Tip(1, "Eat vegetables"), new Tip(2, "Eat fruits")));
        TipCategory example2 = new TipCategory(2, "Bones", Arrays.asList(new Tip(3, "Drink milk"), new Tip(4, "Don't break em!"), new Tip(5, "Osteoperosis is a bitch")));
        Assertions.assertThat(categories).isEqualTo(Arrays.asList(example1, example2));


    }



}