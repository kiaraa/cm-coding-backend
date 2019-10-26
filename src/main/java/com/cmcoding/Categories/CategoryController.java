package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import com.cmcoding.Categories.Tip.TipRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
public class CategoryController {

    private final TipCategoryRepository tipCategoryRepository;
    private final TipRepository tipRepository;

    public CategoryController(TipCategoryRepository tipCategoryRepository, TipRepository tipRepository) {
        this.tipCategoryRepository = tipCategoryRepository;
        this.tipRepository = tipRepository;
    }

    @GetMapping("/categories/{catId}/tips/{tipId}")
    public Tip getSingleTipById(@PathVariable("catId") Integer catId, @PathVariable("tipId") Integer tipId) {
        Tip tip = tipRepository.retreiveById(tipId);

        throwExceptionIfNotFound(tip, catId);

        return tip;
    }

    @GetMapping(value = "/categories/{id}")
    public TipCategory getCategoryById(@PathVariable("id") int catId) {
        TipCategory tipCategory = tipCategoryRepository.retrieveById(catId);
        return tipCategory;
    }

    @GetMapping(value = "/categories/{id}/tips")
    public List<Tip> getCategoryTips(@PathVariable("id") int catId) {
        TipCategory tipCategory = tipCategoryRepository.retrieveById(catId);
        return tipCategory.getTips();
    }

    @GetMapping("/categories")
    public List<TipCategory> getAllCategories() {
        return tipCategoryRepository.findAll();
    }

    private void throwExceptionIfNotFound(Tip tip, Integer catId) {
        if (tip == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No tip with that ID exists.");
        }
        if (!tip.getCategoryId().equals(catId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No tip with that ID exists within that category.");
        }
    }
}
