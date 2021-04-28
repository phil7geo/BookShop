# BookShop

This is a Java Web Application project(Netbeans) i developed to pass an lab-exam for my education industry(University of West Attica). 
I implemented this services using Java Servlets and runned this project with Glassfish Server (using XAMPP Control Panel).

First i have created a MYSQL database at PHPMYADMIN named: 'bookstore.sql' and then the table 'book' with all necessary objects.

Structure: 

1.one  first HTML page(with some CSS)--> index.html 
2.Java Classes --> Book.java , BookDao.java
3.Java Servlets ( SaveBookServlet.java, ViewBookServlet.java, ViewAvailableBookServlet.java, ViewInfoBookServlet.java, DeleteBookServlet.java, 
                   UpdateBookServlet.java, UpdateBookServlet2.java, OrderBookServlet.java, OrderBookServlet2.java)

!--with the implement of every Java Servlet, one web.xml file is automatically created.

I have also added one Database Connector(mariadb-java-client-2.6.2.jar) into libraries.

The Java Web Applications use web.xml (development description file) to determine how URLs are assigned to Servlets, 
which URLs requires authentication, and other information about Servlets.


