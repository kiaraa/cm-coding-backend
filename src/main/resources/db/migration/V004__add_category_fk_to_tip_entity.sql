ALTER TABLE tip_entity
ADD FOREIGN KEY (category) REFERENCES tip_category_entity(id)
    ON DELETE CASCADE;