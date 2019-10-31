CREATE TABLE tip_category_entity
(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE tip_entity
(
	id BIGINT NOT NULL AUTO_INCREMENT,
    tip VARCHAR(255) NOT NULL,
    category BIGINT NULL,

    PRIMARY KEY (id)
);