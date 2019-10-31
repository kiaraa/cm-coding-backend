package com.cmcoding.Categories.Tip;

import com.cmcoding.Categories.TipCategoryEntity;
import com.cmcoding.Categories.TipCategoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class TipRepository {

    @Autowired
    private TipEntityRepository tipEntityRepository;

    @Autowired
    private TipCategoryEntityRepository tipCategoryEntityRepository;

    public Tip save(String tipMessage, int categoryId) {
        TipCategoryEntity tipCategoryEntity = tipCategoryEntityRepository.findById(categoryId).get();
        TipEntity tipEntity = new TipEntity(tipMessage, tipCategoryEntity);
        TipEntity savedTipEntity = tipEntityRepository.save(tipEntity);
       // tipCategoryRepository.addTip(savedTipEntity);
        return new Tip(savedTipEntity.getId(), savedTipEntity.getTip(), savedTipEntity.getCategory().getId());
    }

    public Tip retreiveById(Integer id) {
        try {
            TipEntity retreivedTipEntity = tipEntityRepository.findById(id).get();
            return new Tip(retreivedTipEntity.getId(), retreivedTipEntity.getTip(), retreivedTipEntity.getCategory().getId());
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    public Tip edit(Integer id, String newTip) {
        TipEntity initialTipEntity = tipEntityRepository.findById(id).get();
        initialTipEntity.setTip(newTip);
        TipEntity editedTip = tipEntityRepository.save(initialTipEntity);
        return new Tip(editedTip.getId(), editedTip.getTip());
    }

    public Tip delete(int tipId) {
        TipEntity tipToDelete = tipEntityRepository.findById(tipId).get();
        tipEntityRepository.delete(tipToDelete);
        return new Tip(tipToDelete.getId(), tipToDelete.getTip());
    }
}
