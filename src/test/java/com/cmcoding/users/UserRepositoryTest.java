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
	public void saveAddsNumericIdsFrom1() {
		this.userRepository.save(new UserEntity("Billy", "billy@gmail.com"));
		this.userRepository.save(new UserEntity("Mandy", "mandy@gmail.com"));

		Optional<UserEntity> user = this.userRepository.findById(2L);
		Assertions.assertThat(user.get()).isEqualTo(new UserEntity(2L, "Mandy", "mandy@gmail.com"));
	}
}