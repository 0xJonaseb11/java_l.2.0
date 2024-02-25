package mgt.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import mgt.models.Employee;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties settings = new Properties();
			//POSTGRESQL
			
			settings.put(Environment.DRIVER, "org.postgresql.Driver");
//			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		
			settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate");
			settings.put(Environment.USER, "postgres");
			settings.put(Environment.PASS, "1234@abCD");
			//PostgreSQL
			settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			settings.put(Environment.SHOW_SQL, true);
			settings.put(Environment.HBM2DDL_AUTO, "create-drop");
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Employee.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}

