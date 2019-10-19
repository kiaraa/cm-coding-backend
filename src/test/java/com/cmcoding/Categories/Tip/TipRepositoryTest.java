package com.cmcoding.Categories.Tip;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TipRepositoryTest {

    @Autowired
    private TipRepository tipRepository;

    @Test
    public void saveATipAndRetrieveIt() {
        Tip tip = new Tip("Eat a lot of veggies.");

        Tip savedTip = tipRepository.save(tip);

        Assertions.assertThat(savedTip.getTip()).isEqualTo(tip.getTip());
        Assertions.assertThat(savedTip.getId()).isNotNull();
    }

    @Test
    public void canGetSavedTips() {
        Tip tip = new Tip("Eat a lot of veggies.");

        Tip savedTip = tipRepository.save(tip);

        Tip retrievedTip = tipRepository.retreiveById(savedTip.getId());

        Assertions.assertThat(retrievedTip).isEqualTo(savedTip);
    }
}