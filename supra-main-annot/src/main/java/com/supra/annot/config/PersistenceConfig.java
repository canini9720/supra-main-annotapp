package com.supra.annot.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.supra.annot.repository")
@PropertySource("classpath:db.properties")
public class PersistenceConfig {
	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.supra.annot.model";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_ENVERS_PREFIX = "org.hibernate.envers.audit_table_prefix";
	private static final String PROPERTY_NAME_HIBERNATE_ENVERS_SUFFIX = "org.hibernate.envers.audit_table_suffix";
	
	@Autowired private Environment environment;
	
	@Bean
	public DataSource dataSource() throws IllegalStateException, PropertyVetoException {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(environment.getProperty("db.driver"));
	      dataSource.setUrl(environment.getProperty("db.url"));
	      dataSource.setUsername(environment.getProperty("db.user"));
	      dataSource.setPassword(environment.getProperty("db.password"));
	      return dataSource;
	}
	
	/*@Bean(name = "dataSource", destroyMethod = "")
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
	    JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
	    String jndiName = "java:comp/env/" + environment.getProperty("db.jndi");// for tomcat
	    //String jndiName = environment.getProperty("db.jndi");					  // for weblogic
	    bean.setJndiName(jndiName);
	    bean.setProxyInterface(DataSource.class);
	    bean.setLookupOnStartup(false);
	    bean.afterPropertiesSet();
	    return (DataSource)bean.getObject();
	}*/
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setJpaDialect(hibernateJpaDialect());
		
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		
		Properties jpaProterties = new Properties();
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		jpaProterties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL));
		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}
	
	@Bean
	public HibernateJpaDialect hibernateJpaDialect(){
		return new HibernateJpaDialect();
	}
	
	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
}