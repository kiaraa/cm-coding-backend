package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import com.cmcoding.Categories.Tip.TipRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/categories/{catId}/tips/{tipId}")
    public Tip editTip(@PathVariable("tipId") Integer id, @RequestBody Tip newTipEdit) throws IdentityMismatchException {
        if (!id.equals(newTipEdit.getId())) {
            throw new IdentityMismatchException("The id in the url and the id of the tip do not match.");
        }
        Tip editedTip = tipRepository.edit(newTipEdit.getId(), newTipEdit.getTip());
        return editedTip;
    }

    public static class IdentityMismatchException extends RuntimeException {

        public IdentityMismatchException(String message) {
            super(message);
        }
    }
}
