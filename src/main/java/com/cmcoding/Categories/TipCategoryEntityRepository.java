package com.cmcoding.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipCategoryEntityRepository extends JpaRepository <TipCategoryEntity, Integer> {
}
