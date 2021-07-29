package de.grabmair.guice.jpa.entitymanager;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.Environment;

import com.google.inject.Provider;

public class EntityManagerFactoryProvider implements Provider<EntityManagerFactory> {
	@Override
	public EntityManagerFactory get() {
		Map<String, String> properties = new HashMap<>();
		properties.put(Environment.DRIVER, "org.postgresql.Driver");
		properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/example");
		properties.put(Environment.USER, "postgres");
		properties.put(Environment.PASS, "postgres");
		properties.put(Environment.POOL_SIZE, "1");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		properties.put(Environment.HBM2DDL_AUTO, "create-drop");
		return Persistence.createEntityManagerFactory("db-manager", properties);
	}
}
