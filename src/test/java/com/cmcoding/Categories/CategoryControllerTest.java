package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;


@RunWith(JUnit4.class)
public class CategoryControllerTest {

    @Test
    public void testGetTip(){
        CategoryController categoryController = new CategoryController();

        Tip tip = categoryController.getSingleTipById(1,2);

        Assertions.assertThat(tip.getId()).isEqualTo(2);
        Assertions.assertThat(tip.getTip().equals("Don't break em!"));
    }

    @Test
    public void testGetTipDifferentId(){
        CategoryController categoryController = new CategoryController();

        Tip tip = categoryController.getSingleTipById(1,3);

        Assertions.assertThat(tip.getId()).isEqualTo(3);
        Assertions.assertThat(tip.getTip()).isEqualTo("Osteoperosis is a bitch");
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
        Assertions.assertThat(cat1.getName()).isEqualTo("Bones");
        Assertions.assertThat(cat1.getTips().size()).isEqualTo(3);

        Assertions.assertThat(cat1.getTips().get(0).getId()).isEqualTo(1);
        Assertions.assertThat(cat1.getTips().get(0).getTip()).isEqualTo("Drink milk");

        Assertions.assertThat(cat2.getId()).isEqualTo(2);
        Assertions.assertThat(cat2.getName()).isEqualTo("General Health");
        Assertions.assertThat(cat2.getTips().size()).isEqualTo(2);

        Assertions.assertThat(cat2.getTips().get(0).getId()).isEqualTo(4);
        Assertions.assertThat(cat2.getTips().get(0).getTip()).isEqualTo("Eat vegetables");

        Assertions.assertThat(cat2.getTips().get(1).getId()).isEqualTo(5);
        Assertions.assertThat(cat2.getTips().get(1).getTip()).isEqualTo("Eat fruits");
    }

    @Test
    public void testGetTipsFromCategory(){
        CategoryController categoryController = new CategoryController();

        List<Tip> category1Tips = categoryController.getCategoryTips(1);
        List<Tip> category2Tips = categoryController.getCategoryTips(2);

        Assertions.assertThat(category1Tips.size()).isEqualTo(3);
        Assertions.assertThat(category1Tips.get(0).getId()).isEqualTo(1);
        Assertions.assertThat(category1Tips.get(0).getTip()).isEqualTo("Drink milk");

        Assertions.assertThat(category2Tips.size()).isEqualTo(2);

        Assertions.assertThat(category2Tips.get(0).getId()).isEqualTo(4);
        Assertions.assertThat(category2Tips.get(0).getTip()).isEqualTo("Eat vegetables");

        Assertions.assertThat(category2Tips.get(1).getId()).isEqualTo(5);
        Assertions.assertThat(category2Tips.get(1).getTip()).isEqualTo("Eat fruits");

    }

    @Test
    public void testGetCategories(){
        CategoryController categoryController = new CategoryController();

        List<TipCategory> categories = categoryController.getAllCategories();

        TipCategory example1 = new TipCategory(1, "Bones", Arrays.asList(new Tip(1, "Drink milk"), new Tip(2, "Don't break em!"), new Tip(3, "Osteoperosis is a bitch")));
        TipCategory example2 = new TipCategory(2, "General Health", Arrays.asList(new Tip(4, "Eat vegetables"), new Tip(5, "Eat fruits")));

        Assertions.assertThat(categories).isEqualTo(Arrays.asList(example1, example2));


    }



}