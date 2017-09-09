
// EMPLOYEE table creates automatically when run the com.test.jpa.CreateEmployee.java


CREATE TABLE `products` (                                
            `id` int(11) NOT NULL AUTO_INCREMENT,                  
            `product_name` varchar(250) DEFAULT NULL,              
            `product_description` varchar(400) DEFAULT NULL,       
            `stock_qty` double(10,2) DEFAULT NULL,                 
            `price` double(10,2) DEFAULT NULL,                     
            PRIMARY KEY (`id`)                                     
   ) ENGINE=InnoDB;
  

CREATE TABLE `ADDRESS` (                                
            `id` int(11) NOT NULL AUTO_INCREMENT,                  
            `CITY` varchar(50) DEFAULT NULL,              
            `COUNTRY` varchar(50) DEFAULT NULL,       
			`POSTCODE` varchar(6) DEFAULT NULL,
            `PROVINCE` varchar(50) DEFAULT NULL,
            `STREET` varchar(200) DEFAULT NULL,
            PRIMARY KEY (`id`)                                     
   ) ENGINE=InnoDB;