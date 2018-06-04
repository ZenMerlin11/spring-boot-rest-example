# Example RESTful Web Service Using Spring Boot, JPA, and H2
---
This project was created to experiment with examples of RESTful web services using Spring Boot. The goal was to develop an online data store and api for an example front-end project ([CoffeeRun](https://github.com/ZenMerlin11/coffeerun), [Front-End Development, The Big Nerd Ranch Guide](https://www.bignerdranch.com/books/front-end-web-development/)) without modifying any existing front-end code (with the exception of the remote data store URL). The static html/js front-end was included and served with this project for convenience. It was assumed the front-end and back-end will be served from a common origin, and so CORS support was not implemented. The in-memory database H2 was chosen as the data store for simplicity of implementation.

## Dependencies
1. [Maven](https://maven.apache.org/) to build and run the project. 
2. [Git](https://git-scm.com/downloads) to clone the repository.

## Installation

Once you have Maven and Git installed, create or navigate to the directory where you want the repository to be cloned and run from your preferred terminal:

    git clone https://github.com/ZenMerlin11/spring-boot-rest-example.git

Then if desired you can import the project into your preferred IDE ([IntelliJ], [NetBeans], [Eclipse]). To build and run the project, navigate to the project root in the terminal and run:

    mvn spring-boot:run

If you do not want to install Maven, you can also run `mvnw spring-boot:run` instead to run the Maven Wrapper. Either of these will build the project, and start a Tomcat server on your localhost at port 8080. The CoffeeRun front-end is served at [http://localhost:8080](http://localhost:8080). The REST endpoints used by the application can be accessed directly from [http://localhost:8080/coffeeorders](http://localhost:8080/coffeeorders).

## Usage

![UI Screenshot](ui-screenshot.png)

Enter a coffee order description, customer email address, size, flavor, and caffeine dosage level. Click `Submit` to add the order to the database and update pending orders. Click the checkbox or row of any of the pending orders to deliver the orders and delete from the database. Click `Reset` to clear the form.