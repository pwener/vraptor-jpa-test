package br.com.caelum.vraptor.components;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import br.com.caelum.vraptor.jpa.JPAGeneratorOfProperties;

@ApplicationScoped
public class PropertiesGenerator implements JPAGeneratorOfProperties{
	
	@Produces
	public Properties getPropertiesOfJPAConnection() {
		Properties properties = new Properties();

		String username = "root";
		String password = "root";
		String dbURL = "jdbc:mysql://localhost:3306/vraptor_test";

		properties.put("javax.persistence.jdbc.url", dbURL);
		properties.put("hibernate.default_schema", "vraptor_test");
		properties.put("javax.persistence.jdbc.user", username);
		properties.put("javax.persistence.jdbc.password", password);
		properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
}
