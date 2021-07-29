package de.grabmair.guice.jpa.repository;

import javax.persistence.EntityManager;

import com.google.inject.Inject;

public abstract class AbstractRepository<T> {
	@Inject
	protected EntityManager _em;

	public T save(T entity) {
		_em.getTransaction().begin();
		_em.persist(entity);
		_em.getTransaction().commit();
		return entity;
	}
}
