package com.cmcoding.Categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class TipCategoryRepository {

    @Autowired
    TipCategoryEntityRepository tipCategoryEntityRepository;

    public TipCategory save(String categoryName) {
        TipCategoryEntity tipCategoryEntity = new TipCategoryEntity(categoryName);
        TipCategoryEntity savedTipCategoryEntity = tipCategoryEntityRepository.save(tipCategoryEntity);
        return new TipCategory(savedTipCategoryEntity.getId(), savedTipCategoryEntity.getName());
    }

    public TipCategory retrieveById(Integer id) {
        try {
            TipCategoryEntity categoryEntity = tipCategoryEntityRepository.findById(id).get();
            return new TipCategory(categoryEntity.getId(), categoryEntity.getName());
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public TipCategory edit(int id, String name) {
        TipCategoryEntity savedCategory = tipCategoryEntityRepository.findById(id).get();
        savedCategory.setName(name);
        tipCategoryEntityRepository.save(savedCategory);
        return new TipCategory(savedCategory.getId(), savedCategory.getName());
    }

    public TipCategory delete(int id) {
        TipCategoryEntity categoryToDelete = tipCategoryEntityRepository.findById(id).get();
        tipCategoryEntityRepository.delete(categoryToDelete);
        return new TipCategory(categoryToDelete.getId(), categoryToDelete.getName());
    }
}
