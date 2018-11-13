							
Shopping Societies E-Commerce Platform

Introduction
This document includes all the instructions required for running this project. 
Also I have mentioned some of the assumptions which I made while developing APIs. 


Entity Relationship Diagram (ERD) of Application



 



Assumptions Related to Api Endpoints
 	 					
 1.Endpoint: GET /sales/current?country=SG

Assumption: Include the sale_id in the response

Reason:  Since the flash sale can be eligible for many countries , including sale_id when displaying flash sales will help to reduce the complexity of managing purchase API .
Otherwise we need to pass the “country” along with “user_id”	in /products/{id}/purchase								
2. Endpoint: POST /products/{id}/purchase 
Assumption: id = sales_id				
Reason: As mentioned above 

3.Company is also a user and its user_id is = 1


Application Development
Application has been developed using following components. 
Java 8 (version "1.8.0_162")
Spring Boot framework
Embedded web container 
MySQL as the database
Flyway as database migration tool
Maven build tool
Spring Data JPA for handling database functions
Junit and mockito for unit and integration testing
Enabled docker if you need to run it in containerized environment
Gatling for load testing
Swagger UI for viewing API endpoint details
Cobertura for code coverage
 
System Ports
By default system is running in following ports. Please change application and docker property files if there is any conflict with your environment 

Web App: 8888
MySQL: 3306


System Requirements 
Following libraries should be installed on your machine before running the application. 

Java 8+
Maven 
MySqL (mysql@5.7 or latest)
Docker (only if you if you need to run it in containerized environment)


Running the Application
Application can be run in different profiles such as test , dev,  prod and docker. By default it will be running in prod profile. Therefore you may need to change the application property files based on selected profile.


Running in prod profile

Step 1

Create a MySQL database with the name “ prd_shopping_societies” and grant all privileges for the app user.

Change the following properties in /src/main/resources/application-prod.properties accordingly. 

## Spring DATA SOURCE Configurations
spring.datasource.url = jdbc:mysql://localhost:3306/prd_shopping_societies?useSSL=false
spring.datasource.username = app_user
spring.datasource.password = test123

Step 2

In Linux/Mac/Windows terminal run the following commands. 
Alternatively you can run the project in any Java IDE.

Firstly, in the terminal , locate to the root folder of the application. Eg: shoppingsocieties

cd shoppingsocieties

mvn clean install

If you want to skip unit and integration testing
	mvn clean install -DskipTests

If the build process is successful then you would see “BUILD SUCCESS” message. After that run the following command to start the application. 
	
	java -jar ./target/shoppingsocieties-0.0.1-SNAPSHOT.jar

If the the application started without any exceptions you would be able to access it from 
	http://localhost:8888/shoppingsocieties


Running in dev or test profile

Firstly you need to change the profile as dev in /src/main/resources/application.properties

Eg: dev profile

# test,dev , prod, docker
spring.profiles.active=dev

Change the Spring DATA SOURCE  configurations in application-dev.properties

Then follow the same instructions mentioned in above Step 2 


Running in test profile

Firstly you need to change the profile as test in /src/main/resources/application.properties

Eg: dev profile

# test,dev , prod, docker
spring.profiles.active=test

Change the Spring DATA SOURCE  configurations in application-test.properties

Then follow the same instructions mentioned in above Step 2



Running in docker profile

Firstly you need to change the profile as docker in /src/main/resources/application.properties
Check the docker-compose and Docker files to avoid any port conflicts with your loca environment.
From the application’s root directory run the following commands.

mvn clean install -DskipTests

docker-compose up

If everything went successfully you would be able to access application from

http://localhost:8888/shoppingsocieties


Note: If you changed the application code or docker-compose.yml file you may need to rebuild.
 mvn clean install -DskipTests
 docker-compose rebuild
 docker-compose up



Testing the Application

Testing REST Endpoints Using Swagger UI

Swagger has been enabled for this application and the endpoints can be tested by using it.  All the endpoints can be viewed using following swagger-ui URL

http://localhost:8888/shoppingsocieties/swagger-ui.html#/ 


Alternatively you can select any other rest client for testing endpoints.




Running Unit and Integration Test

Unit and Integration test cases have been written using Junit and Mockito.
At the moment all the test cases are running together.

Firstly you need to change the profile as test in /src/main/resources/application.properties 

Since integration test has required a database , create a database and change the Spring DATA SOURCE  configurations in application-test.properties


In the terminal, go to the root folder of the application and run the following command.

mvn  clean test





Running Load Test

In order to run the load testing , I have created a separate Spring Boot application and integrated Gatling performance testing tool.

However time was not enough to implement real scenario based load test cases. Following are the instructions for running some basic test cases. 

Simulation of Current Flash Sales

Load test endpoint: http://localhost:8888/shoppingsocieties/sales/current?country=SG

Steps

Go to the load-testing spring boot application folder.
Make sure shoppingsocieties web application is running before executing commands.
From the root folder run the following commands in the terminal.

mvn clean install
mvn gatling:test

If everything went successfully you would see the following output. 
Also you can see the full report from target/gatling/currentflashsalestest*/index.html

 

















Sample outputs








Code Coverage

100% Unit test coverage has been given for all the Service, and Rest Controller classes.




	
			
		

