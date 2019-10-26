package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import com.cmcoding.Categories.Tip.TipRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;


@RunWith(JUnit4.class)
public class CategoryControllerTest {

    private CategoryController categoryController;

    private TipCategoryRepository tipCategoryRepository;
    private TipRepository tipRepository;

    @Before
    public void setUp() throws Exception {
        tipCategoryRepository = Mockito.mock(TipCategoryRepository.class);
        tipRepository = Mockito.mock(TipRepository.class);

        categoryController = new CategoryController(tipCategoryRepository, tipRepository);
    }

    @Test
    public void testGetTip(){
        Tip tip = new Tip(2, "AH!", 1);
        Mockito.when(tipRepository.retreiveById(2)).thenReturn(tip);

        Tip response = categoryController.getSingleTipById(1,2);

        Assertions.assertThat(response.getId()).isEqualTo(2);
        Assertions.assertThat(response.getCategoryId()).isEqualTo(1);
        Assertions.assertThat(response.getTip()).isEqualTo("AH!");
    }

    @Test
    public void testGetTipThrowsExceptionIfTheTipDoesntExist() {
        Mockito.when(tipRepository.retreiveById(2)).thenReturn(null);

        try {
            Tip response = categoryController.getSingleTipById(1,2);
            Assertions.fail("Expecting exception");
        } catch (ResponseStatusException e) {
            Assertions.assertThat(e.getMessage()).contains("No tip with that ID exists.");
            Assertions.assertThat(e.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetTipThrowsExceptionIfCategoryIdDoesNotMatch(){
        Tip tip = new Tip(2, "AH!", 3);
        Mockito.when(tipRepository.retreiveById(2)).thenReturn(tip);

        try {
            Tip response = categoryController.getSingleTipById(1,2);
            Assertions.fail("Expecting exception");
        } catch (ResponseStatusException e) {
            Assertions.assertThat(e.getMessage()).contains("No tip with that ID exists within that category.");
            Assertions.assertThat(e.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetTipDifferentId(){
        Tip tip = new Tip(3, "EEP!", 2);
        Mockito.when(tipRepository.retreiveById(3)).thenReturn(tip);

        Tip response = categoryController.getSingleTipById(2,3);

        Assertions.assertThat(response.getId()).isEqualTo(3);
        Assertions.assertThat(response.getCategoryId()).isEqualTo(2);
        Assertions.assertThat(response.getTip()).isEqualTo("EEP!");
    }

    @Test
    public void testGetCategoryReturnsCategory(){
        List<Tip> tips = Arrays.asList(new Tip(1,"Pet every day", 1), new Tip(2, "Give them bread sometimes", 1),  new Tip(3, "Kiss kiss", 1));
        TipCategory category = new TipCategory(1, "Cat Care", tips);
        Mockito.when(tipCategoryRepository.retrieveById(1)).thenReturn(category);

        TipCategory response = categoryController.getCategoryById(1);

        Assertions.assertThat(response.getId()).isEqualTo(category.getId());
        Assertions.assertThat(response.getTips()).isEqualTo(category.getTips());
        Assertions.assertThat(response.getName()).isEqualTo(category.getName());
    }

    @Test
    public void testGetCategoryReturnsDifferentCategories(){
        List<Tip> tips = Arrays.asList(new Tip(1,"Pet every day", 1), new Tip(2, "Give them bread sometimes", 1),  new Tip(3, "Kiss kiss", 1));
        TipCategory category = new TipCategory(1, "Cat Care", tips);
        Mockito.when(tipCategoryRepository.retrieveById(1)).thenReturn(category);

        List<Tip> otherTips = Arrays.asList(new Tip(4, "Drink a lot of water.", 2));
        TipCategory otherCategory = new TipCategory(2, "Health", otherTips);
        Mockito.when(tipCategoryRepository.retrieveById(2)).thenReturn(otherCategory);

        Assertions.assertThat(category.getId()).isNotEqualTo(otherCategory.getId());
    }

    @Test
    public void testGetTipsFromCategory(){
        List<Tip> tips = Arrays.asList(new Tip(1, "Practice", 1), new Tip(2, "Use Google", 1));
        TipCategory tipCategory = new TipCategory(1, "Coding Advice", tips);
        Mockito.when(tipCategoryRepository.retrieveById(1)).thenReturn(tipCategory);

        List<Tip> response = categoryController.getCategoryTips(1);

        Assertions.assertThat(response).isEqualTo(tipCategory.getTips());
    }

    @Test
    public void testGetCategories(){
        TipCategory tipCategory1 = new TipCategory(1, "Cooking", Arrays.asList(new Tip(1, "Be creative", 1), new Tip(2, "Use spices", 1)));
        TipCategory tipCategory2 = new TipCategory(2, "Baking", Arrays.asList(new Tip(3, "Use margarine", 2), new Tip(4, "Let ingredients come to room temperature", 2)));
        Mockito.when(tipCategoryRepository.findAll()).thenReturn(Arrays.asList(tipCategory1, tipCategory2));

        List<TipCategory> response = categoryController.getAllCategories();

        Assertions.assertThat(response).containsExactlyInAnyOrder(tipCategory1, tipCategory2);
    }
}