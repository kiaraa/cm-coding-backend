package com.cmcoding.Categories.Tip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipEntityRepository extends JpaRepository<TipEntity, Integer> {
}
