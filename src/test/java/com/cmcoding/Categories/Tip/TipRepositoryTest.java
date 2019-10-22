package com.cmcoding.Categories.Tip;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TipRepositoryTest {

    @Autowired
    private TipRepository tipRepository;

    @Test
    public void saveATipAndRetrieveIt() {
        String tipMessage = "Eat a lot of veggies.";

        Tip savedTip = tipRepository.save(tipMessage);

        assertThat(savedTip.getTip()).isEqualTo(tipMessage);
        assertThat(savedTip.getId()).isNotNull();
    }

    @Test
    public void canGetSavedTips() {
        String tipMessage = "Eat a lot of veggies.";

        Tip savedTip = tipRepository.save(tipMessage);

        Tip retrievedTip = tipRepository.retreiveById(savedTip.getId());

        assertThat(retrievedTip).isEqualTo(savedTip);
    }

    @Test
    public void canEditSavedTips() {
        String initialTipMessage = "Don't bother looking before crossing the street.";

        String correctString = "Always look both ways before crossing the street.";
        Tip savedTip = tipRepository.save(initialTipMessage);
        int tipId = savedTip.getId();
        Tip editedTip = tipRepository.edit(tipId, correctString);
        Tip tipWithSameId = tipRepository.retreiveById(tipId);

        assertThat(editedTip.getTip()).isEqualTo(tipWithSameId.getTip());
        assertThat(editedTip.getTip()).isEqualTo(correctString);
    }

    @Test
    public void canDeleteTips() {
        Tip tipToDelete = tipRepository.save("Delete this tip.");

        int tipId = tipToDelete.getId();
        Tip deletedTip = tipRepository.delete(tipId);

        assertThat(tipRepository.retreiveById(tipId)).isNull();
    }
}