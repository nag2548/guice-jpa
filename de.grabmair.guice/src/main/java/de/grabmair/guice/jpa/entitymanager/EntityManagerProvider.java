package de.grabmair.guice.jpa.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class EntityManagerProvider implements Provider<EntityManager> {
	private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<>();

	@Inject
	EntityManagerFactory _factory;

	@Override
	public EntityManager get() {
		EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
		if (entityManager == null) {
			entityManager = _factory.createEntityManager();
			ENTITY_MANAGER_CACHE.set(entityManager);
		}
		return entityManager;
	}
}
