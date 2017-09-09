package com.test.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.test.jpa.entity.Address;

// https://sayemdb.wordpress.com/2014/08/15/jpa-tutorial-setting-up-jpa-in-a-java-se-environment/

/*

<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
  version="2.1">
 
  <persistence-unit name="jpa-example" transaction-type="RESOURCE_LOCAL">
   <class>com.test.jpa.entity.Address</class>
 
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

public class CreateAddress {
	

  public static void main(String[] args) {
   
	 // createAddress();
	  
	  selectAllAddress();
  }
  
  private static void selectAllAddress() {
	  
	  EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "jpa-example" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
    //Scalar function
      Query query = entitymanager.
      createQuery("Select UPPER(e.country) from Address e");
      List<String> list = query.getResultList();

      for(String e:list) {
         System.out.println("Country NAME :"+e);
      }
      
      //Aggregate function
     // Query query1 = entitymanager.createQuery("Select MAX(e.salary) from Employee e");
      //Double result = (Double) query1.getSingleResult();
      //System.out.println("Max Employee Salary :" + result);
  }

  private static void createAddress() {
	
	 Address address = new Address();
	    address.setCity("Dhaka")
	        .setCountry("Bangladesh")
	        .setPostcode("1000")
	        .setStreet("Poribagh");
	 
	    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
	    em.getTransaction()
	        .begin();
	    em.persist(address);
	    em.getTransaction()
	        .commit();
	 
	    em.close();
	    PersistenceManager.INSTANCE.close();

	}
}
enum PersistenceManager {
	  INSTANCE;
	 
	  private EntityManagerFactory emFactory;
	 
	  private PersistenceManager() {
	    // "jpa-example" was the value of the name attribute of the
	    // persistence-unit element.
	    emFactory = Persistence.createEntityManagerFactory("jpa-example");
	  }
	 
	  public EntityManager getEntityManager() {
	    return emFactory.createEntityManager();
	  }
	 
	  public void close() {
	    emFactory.close();
	  }
}