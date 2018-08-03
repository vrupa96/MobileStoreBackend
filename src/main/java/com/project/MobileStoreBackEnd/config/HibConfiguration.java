package com.project.MobileStoreBackEnd.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.MobileStoreBackEnd.dao.CartItemDAO;
import com.project.MobileStoreBackEnd.dao.CategoryDAO;
import com.project.MobileStoreBackEnd.dao.OrderDetailsDAO;
import com.project.MobileStoreBackEnd.dao.ProductDAO;
import com.project.MobileStoreBackEnd.dao.SupplierDAO;
import com.project.MobileStoreBackEnd.dao.UserDAO;
import com.project.MobileStoreBackEnd.daoImpl.CartItemDAOimpl;
import com.project.MobileStoreBackEnd.daoImpl.CategoryDAOimpl;
import com.project.MobileStoreBackEnd.daoImpl.OrderDetailsDAOimpl;
import com.project.MobileStoreBackEnd.daoImpl.ProductDAOimpl;
import com.project.MobileStoreBackEnd.daoImpl.SupplierDAOimpl;
import com.project.MobileStoreBackEnd.daoImpl.UserDAOimpl;
import com.project.MobileStoreBackEnd.model.CartItem;
import com.project.MobileStoreBackEnd.model.Category;
import com.project.MobileStoreBackEnd.model.OrderDetails;
import com.project.MobileStoreBackEnd.model.Product;
import com.project.MobileStoreBackEnd.model.Supplier;
import com.project.MobileStoreBackEnd.model.User;

@Configuration
@ComponentScan("com.project")
@EnableTransactionManagement
public class HibConfiguration {
	
	@Autowired
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/s190039");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        return dataSource;
    }
	 
	@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder  = new LocalSessionFactoryBuilder(dataSource);
        //sessionBuilder.setProperty("hibernate.show_sql", "true");
        System.out.println("Adding hibernate properties to the sessionBuilder object");
        sessionBuilder.addProperties(getHibernateProperties());
        System.out.println("Adding User class");
        sessionBuilder.addAnnotatedClass(User.class);
        System.out.println("Adding Category class");
        sessionBuilder.addAnnotatedClass(Category.class);
        System.out.println("Adding Product class");
        sessionBuilder.addAnnotatedClass(Product.class);
        System.out.println("Adding Supplier class");
        sessionBuilder.addAnnotatedClass(Supplier.class);
        System.out.println("Adding CartItem class");
        sessionBuilder.addAnnotatedClass(CartItem.class);
        System.out.println("Adding OrderDetails class");
        sessionBuilder.addAnnotatedClass(OrderDetails.class);
        System.out.println("Creating Session factory bean");
        return sessionBuilder.buildSessionFactory();
    }
    

		private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.connection.autocommit", true);
        return properties;
    }
		@Bean(name = "userDAO")
		public UserDAO getUserRegDAO() {
			System.out.println("----UserDAO implementation---");
			return new UserDAOimpl();
		}
		
		@Bean(name = "categoryDAO")
		public CategoryDAO getCategoryDAO() {
			System.out.println("---CategoryDAO implementation---");
			return new CategoryDAOimpl();
		}
		
		@Bean(name = "productDAO")
		public ProductDAO getproductDAO() {
			System.out.println("---ProductDAO implementation---");
			return new ProductDAOimpl();
		}
		
		@Bean(name = "supplierDAO")
		public   SupplierDAO getsupplierDAO() {
			System.out.println("---SupplierDAO implementation---");
			return new SupplierDAOimpl();
		}
		
		@Bean(name = "cartItemDAO")
		public CartItemDAO getcartItemDAO() {
			System.out.println("---CartItemDAO implementation---");
			return new CartItemDAOimpl();
		}
		
		@Bean(name = "orderDetailsDAO")
		public OrderDetailsDAO getorderDetailsDAO() {
			System.out.println("---OrderDetailsDAO implementation---");
			return new OrderDetailsDAOimpl();
		}
		
    @Bean(name = "Txmanager")
	@Autowired
        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
    	System.out.println("Transaction manager");
                return new HibernateTransactionManager(sessionFactory);
        }
    
} 
