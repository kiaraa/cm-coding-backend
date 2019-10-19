package com.cmcoding.Categories.Tip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TipRepository {

    @Autowired
    private TipEntityRepository tipEntityRepository;

    public Tip save(Tip tip) {
        TipEntity tipEntity = new TipEntity(tip.getTip());
        TipEntity savedTipEntity = tipEntityRepository.save(tipEntity);
        return new Tip(savedTipEntity.getId(), savedTipEntity.getTip());
    }

    public Tip retreiveById(Integer id) {
        TipEntity retreivedTipEntity = tipEntityRepository.findById(id).get();
        return new Tip(retreivedTipEntity.getId(), retreivedTipEntity.getTip());
    }
}
