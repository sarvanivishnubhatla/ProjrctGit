package com.mavenprj.cosmeticbackend.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mavenprj.cosmeticbackend.model.Brand;
import com.mavenprj.cosmeticbackend.model.Cart;
import com.mavenprj.cosmeticbackend.model.Category;
import com.mavenprj.cosmeticbackend.model.OrderDetails;
import com.mavenprj.cosmeticbackend.model.Product;
import com.mavenprj.cosmeticbackend.model.User;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DbConfig {
	@Bean (name="dataSource")
	public DataSource getDatasource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/cosmetic");
		ds.setUsername("sa");
		ds.setPassword("");
		System.out.println("Data Source");
		return ds;
	}
	private Properties getHybernateProperties() 
	{
		Properties prop=new Properties();
		prop.put("hibernate.show_sql","true");
		prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto","update");
		System.out.println("hibernate Properties");
		return prop;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource ds)
	{
		LocalSessionFactoryBuilder sessionbuilder=new LocalSessionFactoryBuilder(ds);
		sessionbuilder.addProperties(getHybernateProperties());
		sessionbuilder.addAnnotatedClass(User.class);
		sessionbuilder.addAnnotatedClass(Category.class);
		sessionbuilder.addAnnotatedClass(Product.class);
		sessionbuilder.addAnnotatedClass(Brand.class);
		sessionbuilder.addAnnotatedClass(Cart.class);
		sessionbuilder.addAnnotatedClass(OrderDetails.class);
		System.out.println("session factory");
		return sessionbuilder.buildSessionFactory();
	}
	@Bean(name="txtManager")
	public HibernateTransactionManager getHibernateTansactionmanager(SessionFactory sessionFactory)
	{
		System.out.println("****** HibernateTransactionManager Object Created *************");
		return new HibernateTransactionManager(sessionFactory);
	}
}

