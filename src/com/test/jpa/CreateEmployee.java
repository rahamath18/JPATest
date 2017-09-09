package com.test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.jpa.entity.Employee;

// https://www.tutorialspoint.com/jpa/jpa_entity_managers.htm

//<?xml version="1.0" encoding="UTF-8"?>
//
//<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence"
//   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
//   xsi:schemaLocation="http://java.sun.com/xml/ns/persistence 
//    http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"> 
//   
//   <persistence-unit name="Eclipselink_JPA" transaction-type="RESOURCE_LOCAL">
//   
//      <class>com.test.jpa.entity.Employee</class>
//
//      <properties>
//         <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/jpadb"/>
//         <property name="javax.persistence.jdbc.user" value="root"/>
//         <property name="javax.persistence.jdbc.password" value="password"/>
//         <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
//         <property name="eclipselink.logging.level" value="FINE"/>
//         <property name="eclipselink.ddl-generation" value="create-tables"/>
//      </properties>
//      
//   </persistence-unit>
//</persistence>

public class CreateEmployee {

   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );

      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );

      Employee employee = new Employee( ); 
      employee.setEid( 1201 );
      employee.setEname( "Gopal" );
      employee.setSalary( 40000 );
      employee.setDeg( "Technical Manager" );
      
      entitymanager.persist( employee );
      entitymanager.getTransaction( ).commit( );

      entitymanager.close( );
      emfactory.close( );
   }
}