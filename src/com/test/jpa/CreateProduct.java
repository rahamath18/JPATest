package com.test.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.test.jpa.entity.Product;
	

// http://www.roseindia.net/hibernate/hibernate4.3/Hibernate-4.3-and-JPA-2.1-Example.shtml

/*
 
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
  version="2.1">
 
  <persistence-unit name="jpa-example" transaction-type="RESOURCE_LOCAL">
		<class>com.test.jpa.entity.Product</class>
 
  <properties>
    <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/jpadb" />
    <property name="javax.persistence.jdbc.user" value="root" />
    <property name="javax.persistence.jdbc.password" value="password" />
    <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
 
    <property name="hibernate.show_sql" value="true" />
    <property name="hibernate.format_sql" value="true" />
    <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5InnoDBDialect" />
    <property name="hibernate.hbm2ddl.auto" value="validate" />
 
    <property name="hibernate.c3p0.min_size" value="5" />
    <property name="hibernate.c3p0.max_size" value="20" />
    <property name="hibernate.c3p0.timeout" value="500" />
    <property name="hibernate.c3p0.max_statements" value="50" />
    <property name="hibernate.c3p0.idle_test_period" value="2000" />
    </properties>
  </persistence-unit>
</persistence> 
 
 */

public class CreateProduct {

	private static final String PERSISTENCE_UNIT_NAME = "jpa-example";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		
		createProduct();
		
		selectAllProduct();
		
		selectMAXPriceProduct();
		
		testJPQLBetweenAndLike();
	}

	public static void createProduct() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		Product product = new Product(0, "M-JPA 2.1 Book", "This is the latest book on JPA 2.1",
				new Double(100.00), new Double(10.99));
		em.persist(product);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public static void selectAllProduct() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jpa-example" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	    //Scalar function
	      Query query = entitymanager.createQuery("Select UPPER(e.productName) from Product e");
	      List<String> list = query.getResultList();

	      for(String e:list) {
	         System.out.println("Product NAME :"+e);
	      }
	}
	
	public static void selectMAXPriceProduct() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jpa-example" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	      //Aggregate function
	      Query query1 = entitymanager.createQuery("Select MAX(e.price) from Product e");
	      Double result = (Double) query1.getSingleResult();
	      System.out.println("Max Product Price :" + result);
		
	}
	
	public static void testJPQLBetweenAndLike( ) {
		   
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jpa-example" );
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	      //Between
	      Query query = entitymanager.createQuery( "Select e " + "from Product e " + "where e.price " + "Between 1 and 150" );
	      
	      List<Product> list=(List<Product>)query.getResultList( );

	      for( Product e:list ){
	         System.out.print("Employee ID :" + e.getId( ));
	         System.out.println("\t Employee salary :" + e.getPrice( ));
	      }

	      //Like
	      Query query1 = entitymanager.createQuery("Select e " + "from Product e " + "where e.productName LIKE 'M%'");
	      
	      List<Product> list1=(List<Product>)query1.getResultList( );
	      
	      for( Product e:list1 ) {
	         System.out.print("Employee ID :"+e.getId( ));
	         System.out.println("\t Employee name :"+e.getProductName( ));
	      }
	   }
}
