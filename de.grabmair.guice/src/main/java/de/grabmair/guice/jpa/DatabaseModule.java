package de.grabmair.guice.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.grabmair.guice.jpa.entitymanager.EntityManagerFactoryProvider;
import de.grabmair.guice.jpa.entitymanager.EntityManagerProvider;

public class DatabaseModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(EntityManagerFactory.class).toProvider(EntityManagerFactoryProvider.class).in(Singleton.class);
		bind(EntityManager.class).toProvider(EntityManagerProvider.class);
	}
}
