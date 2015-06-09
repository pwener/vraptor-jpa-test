package br.com.caelum.vraptor.components;

import java.util.Properties;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.jpa.JPAGeneratorOfProperties;

@ApplicationScoped
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class GeneratorOfJPAProperties implements JPAGeneratorOfProperties{

	@Produces
	@Override
	public Properties getPropertiesOfJPAConnection() {
		Properties propertiesOfJPAConnection = new Properties();
		propertiesOfJPAConnection.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		propertiesOfJPAConnection.put("hibernate.connection.username","root");  
		propertiesOfJPAConnection.put("hibernate.connection.password","root");
		propertiesOfJPAConnection.put( "hibernate.connection.url","jdbc:mysql://localhost:3306/vraptor_test");  
		propertiesOfJPAConnection.put("hibernate.default_schema","vraptor_test");  
		return propertiesOfJPAConnection;
	}
}
