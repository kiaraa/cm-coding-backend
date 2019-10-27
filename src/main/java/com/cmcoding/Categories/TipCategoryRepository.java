package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import com.cmcoding.Categories.Tip.TipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class TipCategoryRepository {

    @Autowired
    TipCategoryEntityRepository tipCategoryEntityRepository;

    public TipCategory save(String categoryName) {
        TipCategoryEntity savedTipCategoryEntity = tipCategoryEntityRepository.save(new TipCategoryEntity(categoryName));
        return new TipCategory(savedTipCategoryEntity.getId(), savedTipCategoryEntity.getName(), new ArrayList<Tip>());
    }

    public TipCategory retrieveById(Integer id) {
        try {
            TipCategoryEntity categoryEntity = tipCategoryEntityRepository.findById(id).get();
            List<TipEntity> tipEntities = categoryEntity.getTips();
            List<Tip> tips = new ArrayList<>();

            for (TipEntity entity : tipEntities) {
                tips.add(new Tip(entity.getId(), entity.getTip(), entity.getCategory().getId()));
            }

            return new TipCategory(categoryEntity.getId(), categoryEntity.getName(), tips);
        } catch (NoSuchElementException e){
            return null;
        }
    }

    public TipCategory editName(int id, String name) {
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

    public List<TipCategory> findAll() {
        List<TipCategoryEntity> categoryEntities = tipCategoryEntityRepository.findAll();
        List<TipCategory> categoryList = new ArrayList<>();
        for (TipCategoryEntity entity : categoryEntities) {
            List<TipEntity> tipEntities = entity.getTips();
            List<Tip> tips = new ArrayList<>();
            for (TipEntity tipEntity : tipEntities) {
                tips.add(new Tip(tipEntity.getId(), tipEntity.getTip(), tipEntity.getCategory().getId()));
            }
            TipCategory tipCategory = new TipCategory(entity.getId(), entity.getName(), tips);
            categoryList.add(tipCategory);
        }
        return categoryList;
    }

//    public TipCategory addTip(TipEntity newTipEntity) {
//        TipCategoryEntity category = newTipEntity.getCategory();
//        category.getTips().add(newTipEntity);
//        TipCategoryEntity savedCategoryEntity = tipCategoryEntityRepository.save(category);
//        List<Tip> tips = new ArrayList<>();
//        for (TipEntity entity : savedCategoryEntity.getTips()) {
//            tips.add(new Tip(entity.getId(), entity.getTip(), entity.getCategory().getId()));
//        }
//        return new TipCategory(savedCategoryEntity.getId(), savedCategoryEntity.getName(), tips);
//    }
}
