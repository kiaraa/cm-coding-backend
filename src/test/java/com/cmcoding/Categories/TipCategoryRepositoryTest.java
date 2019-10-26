package com.cmcoding.Categories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TipCategoryRepositoryTest {

    @Autowired
    private TipCategoryRepository tipCategoryRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void canSaveCategoryAndRetrieveIt() {
        String categoryName = "General Advice";

        TipCategory savedTipCategory = tipCategoryRepository.save(categoryName);

        assertThat(savedTipCategory.getName()).isEqualTo(categoryName);
        assertThat(savedTipCategory.getId()).isNotNull();
    }

    @Test
    public void canGetSavedCategories() {
        String categoryName = "Health Advice";

        TipCategory savedTipCategory = tipCategoryRepository.save(categoryName);

        entityManager.clear();

        TipCategory retrievedTipCategory = tipCategoryRepository.retrieveById(savedTipCategory.getId());

        assertThat(retrievedTipCategory).isEqualTo(savedTipCategory);
    }

    @Test
    public void canEditSavedCategories() {
        String initialTipName = "Oops I made a typo";

        String correctName = "Here is the correct version.";
        TipCategory savedCategory = tipCategoryRepository.save(initialTipName);
        int categoryId = savedCategory.getId();
        TipCategory editedCategory = tipCategoryRepository.edit(categoryId, correctName);
        TipCategory categoryWithSameId = tipCategoryRepository.retrieveById(categoryId);

        assertThat(editedCategory.getName()).isEqualTo(categoryWithSameId.getName());
        assertThat(editedCategory.getName()).isEqualTo(correctName);
    }

    @Test
    public void canDeleteCategories() {
        TipCategory categoryToDelete = tipCategoryRepository.save("Delete this category.");

        int categoryId = categoryToDelete.getId();
        TipCategory deletedCategory = tipCategoryRepository.delete(categoryId);

        assertThat(tipCategoryRepository.retrieveById(categoryId)).isNull();
    }

}