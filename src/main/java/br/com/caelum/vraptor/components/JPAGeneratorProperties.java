package br.com.caelum.vraptor.components;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class JPAGeneratorProperties{
	
	@ApplicationScoped
	@Produces
	public Map<String, String> getPropertiesOfJPAConnection() throws Exception {
		System.out.println("Está entrando aqui!");
		try {
			String username = "root";
		    String password = "root";
		    String dbUrl = "jdbc:mysql://localhost:3306/vraptorjpatest";
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("javax.persistence.jdbc.url", dbUrl );
			properties.put("javax.persistence.jdbc.user", username );
			properties.put("javax.persistence.jdbc.password", password );
			properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
			properties.put("hibernate.show_sql", "true");
			// Creates the factory
			return properties;
		}catch(Exception e){
			throw new Exception("ERROR while get configurations. see: ", e);
		}
	}
}
