package com.cmcoding.users;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserRepositoryTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void injectedComponentsAreNotNull(){
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
		assertThat(userRepository).isNotNull();
	}

	@Test
	public void saveAddsNumericIdsInInsertOrder() {
		UserEntity billy = this.userRepository.save(new UserEntity("Billy", "billy@gmail.com"));
		UserEntity mandy = this.userRepository.save(new UserEntity("Mandy", "mandy@gmail.com"));

		Long billyId = billy.getId();
		Long mandyId = mandy.getId();
		assertThat(billyId + 1).isEqualTo(mandyId);
	}

	@Test
	public void saveReturnsTheSameObjectButWithIdPopulated() {
		UserEntity grim = this.userRepository.save(new UserEntity("Grim", "grim@gmail.com"));

		assertThat(grim.getId()).isNotNull();
		assertThat(grim.getEmail()).isEqualTo("grim@gmail.com");
		assertThat(grim.getName()).isEqualTo("Grim");
	}
}