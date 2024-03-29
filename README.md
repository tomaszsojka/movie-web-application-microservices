# movie-web-application-microservices
Movie management application. The application provides functionalities for viewing and managing information about movies. The application is divided into microservices that follow certain principles, that is, they use separate resources, deal with separate tasks and so on.


<!-- INFO -->
## 1. Info

Project prepared during the exhange in the University of Alcala. In the /doc folder there are two documents with a description of the project. How it was created, what it consists of and how to run it.

The application uses 5 separate spring boot projects. The usersReviews and filmsActors projects are separate microservices that handle backend operations on separate databases. The eurekaServer project is to provide registration and location of the microservices of the application. The gateway project is using Spring Cloud Gateway to consume both backend microservices APIs and join them under one port. The clientFinal project is used to display the application in the browser.

In addition, the db folder contains the files that were used to create both databases.

<!-- SCEENSHOTS -->
## 2. Key functionalities

| ![2 separate databases](https://github.com/tomaszsojka/movie-web-application-microservices/blob/main/doc/screenshots/filmsActorsModel.png?raw=true) ![spring Eureka](https://github.com/tomaszsojka/movie-web-application-microservices/blob/main/doc/screenshots/usersReviewsModel.png?raw=true)|
|:--:|
|  |
| *Two separate databases that are used by different microservices (in compliance to principle of decentralization)* |


| ![API routing](https://github.com/tomaszsojka/movie-web-application-microservices/blob/main/doc/screenshots/routingAPI.png?raw=true) |
|:--:|
| *API routing* |
| ![spring Eureka](https://github.com/tomaszsojka/movie-web-application-microservices/blob/main/doc/screenshots/springEureka.png?raw=true) |
| *All 3 services tracked by spring Eureka Discovery Client* |


| ![admin page](https://github.com/tomaszsojka/movie-web-application-microservices/blob/main/doc/screenshots/adminPage.png?raw=true) |
|:--:|
| *Admin page (example view from the client service)* |

<!-- FRAMEWORKS -->
## 3. Frameworks

The application's data is stored in SQL databases, created using MySQLWorkbench software.

All the projects that make up the application were created using Springi Initializer. Depending on the project, the following dependencies were used:

- Spring Boot DevTools,
- Spring Web,
- Thymeleaf,
- Spring Data JPA,
- Spring Security,
- Spring Boot DevTools,
- MySQL Driver,
- Eureka Discovery Client,
- Eureka Server,
- Gateway.

The database was linked to the project in the IntelliJ Idea development environment, and then using JPA Buddy plugin entities from the database were created.




