package de.grabmair.guice.jpa;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.grabmair.guice.jpa.model.UsStates;
import de.grabmair.guice.jpa.repository.UsStatesRepository;

public class Main {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new DatabaseModule());
		UsStatesRepository repo = injector.getInstance(UsStatesRepository.class);

		UsStates states = repo.save(new UsStates("Texas", "TX", "1"));
		UsStates states2 = repo.save(new UsStates("New York", "NY", "2"));

		System.out.println("");
	}
}
