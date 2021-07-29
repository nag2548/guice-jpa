package de.grabmair.guice.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.grabmair.guice.jpa.DatabaseModule;
import de.grabmair.guice.jpa.model.UsStates;

public class UsStatesRepositoryTests {
	@Test
	void test() {
		Injector injector = Guice.createInjector(new DatabaseModule());
		UsStatesRepository repo = injector.getInstance(UsStatesRepository.class);
		EntityManager entityManager = injector.getInstance(EntityManager.class);

		UsStates state = new UsStates();
		state.setStateName("Alabama");
		state.setStateAbbr("AL");
		state.setStateRegion("US");

		repo.save(state);

		List<UsStates> resultList = entityManager.createQuery("select s from UsStates s", UsStates.class)
				.getResultList();

		assertThat(resultList).extracting("stateName", "stateRegion").contains(Assertions.tuple("Alabama", "US"));
	}
}
