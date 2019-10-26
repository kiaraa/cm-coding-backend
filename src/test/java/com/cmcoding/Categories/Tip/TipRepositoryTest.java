package com.cmcoding.Categories.Tip;

import com.cmcoding.Categories.TipCategory;
import com.cmcoding.Categories.TipCategoryRepository;
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

    @Autowired
    private TipCategoryRepository tipCategoryRepository;

    @Test
    public void saveATipAndRetrieveIt() {
        TipCategory category = tipCategoryRepository.save("General Health");
        int categoryId = category.getId();
        String tipMessage = "Eat a lot of veggies.";

        Tip savedTip = tipRepository.save(tipMessage, categoryId);

        assertThat(savedTip.getTip()).isEqualTo(tipMessage);
        assertThat(savedTip.getId()).isNotNull();
    }

    @Test
    public void canGetSavedTips() {
        TipCategory category = tipCategoryRepository.save("General Health");
        int categoryId = category.getId();

        String tipMessage = "Eat a lot of veggies.";

        Tip savedTip = tipRepository.save(tipMessage, categoryId);

        Tip retrievedTip = tipRepository.retreiveById(savedTip.getId());

        assertThat(retrievedTip).isEqualTo(savedTip);
    }

    @Test
    public void canEditSavedTips() {
        TipCategory category = tipCategoryRepository.save("General Health");
        int categoryId = category.getId();
        String initialTipMessage = "Don't bother looking before crossing the street.";

        String correctString = "Always look both ways before crossing the street.";
        Tip savedTip = tipRepository.save(initialTipMessage, categoryId);
        int tipId = savedTip.getId();
        Tip editedTip = tipRepository.edit(tipId, correctString);
        Tip tipWithSameId = tipRepository.retreiveById(tipId);

        assertThat(editedTip.getTip()).isEqualTo(tipWithSameId.getTip());
        assertThat(editedTip.getTip()).isEqualTo(correctString);
    }

    @Test
    public void canDeleteTips() {
        TipCategory category = tipCategoryRepository.save("General Health");
        int categoryId = category.getId();
        Tip tipToDelete = tipRepository.save("Delete this tip.", categoryId);

        int tipId = tipToDelete.getId();
        Tip deletedTip = tipRepository.delete(tipId);

        assertThat(tipRepository.retreiveById(tipId)).isNull();
        assertThat(tipCategoryRepository.retrieveById(categoryId).getTips().size()).isEqualTo(0);
    }
}