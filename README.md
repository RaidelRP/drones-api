# Drones REST API

This project develops a service via REST API that allows clients to communicate with drones that load medications 

## Table of Contents
1. [General description](#general-description)
2. [Technologies](#technologies)
3. [Implementation]()
4. [Running the project](#running-the-project)
5. [Testing APIs](#testing-apis)
6. [Viewing the running application](#viewing-the-running-application)
7. [References](#references)

## General Description
***
A **drone** is capable of carrying devices, other than cameras, and capable of
delivering small loads. For our use case the load is **medications**.

A **Drone** has:
* serial number (100 characters max);
* model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
* weight limit (500gr max);
* battery capacity (percentage);
* state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

Each **Medication** has:
* name (allowed only letters, numbers, ‘-‘, ‘_’);
* weight;
* code (allowed only upper case letters, underscore and numbers);
* image (picture of the medication case).

### The service should allow:
* registering a drone;
* loading a drone with medication items;
* checking loaded medication items for a given drone;
* checking available drones for loading;
* check drone battery level for a given drone

### Functional requirements
* Prevent the drone from being loaded with more weight that it can carry;
* Prevent the drone from being in LOADING state if the battery level is below 25%;

## Technologies
***
The project has been developed using:
* _Java_ as programming language
* _Spring boot_ to create the structure of the project
* _Spring JPA_ for managing relational data
* _SQLite_ as database
* _Postman_ for testing the APIs 

## Implementation
***
### Classes
The situation has been modeled by creating a class that represent a Drone and another for the Medication. These two are entities to persist into the database

The class `Drone` has the attributes `serialNumber`, `model`, `weightLimit`, `battery` and `state`.

The class `Medication` has the attributes `name`, `code`, `weight` and `imagePath`.

Both have their own `id`, that is generated to identify the object in the database.

In order to complement the extra information from a drone, there are also two enumerations for the attributes model and state.

The enum `Model` has the values that a drone's model can have. In the enum `State` there are the specific states of a drone

### Relations
One medication can be carried by some drones, and a same drone can load several medications. However, the relationship carried between them has been established as one drone can load only one medication at once.

In order to achieve that assumption, the entity `Drone` has the extra field `medication` with a reference to the corresponding object. In the other side, the entity `Medication` has a set of `drones` representing all the vehicles that can transport it.

### Database
The database system to use is SQLite because it can be included as a file in the project.

The name of the database is set in the `application.properties` file, in which is also included configuration parameters just as user, password and others.

In the `pom.xml` file we need to add the `sqlite-jdbc` dependency and the SQLite dialect, because Spring Boot doesn't provide configuration support for SQLite database out of the box. For that reason a datasource is included as the class `DbConfig`

### Repositories
For each entity that would be saved in the database is created a repository that provides the tools that can handle the information of the tables; so we have the interfaces `DroneRepository` and `MedicationRepository`  

### Controllers
Classes that use the repositories to  interpret user input and transform it into a model that is represented to the user by the view. According to the main entities and repositories, there are `DroneController` and `MedicationController`

The basic operations in each controller are create a new object, read the information of one object, show the attributes of all of them, update the  data and delete one element from its id.

In order to create a new drone or medication, the HTTP method _post_ is used, so the URL for this purpose is set according to this method. 

When creating a medication or drone by this way, the object is defined as a parameter; it is verified if it has an id because a new object shouldn't have an id; if it has, a **Bad Request** response is sent. If everything is OK, it is redirected to a page with the info of the just-created object in format JSON

The `findAll` method is defined as a request related to the HTTP method _get_. In this case, a response is sent with all the objects from a type. If there isn't any object, it will return an empty list, and it doesn't produce any error.

The `findById` method uses the HTTP method _get_. It searches if the given id exists in the database, giving then all the information of the object if it has succeeded, or a **Bad Request** in other case.

For editing an object, it is needed the HTTP method _put_. It searches the given id, and it updates the information of the object if the id is right.

Removal makes similar actions to the previous actions. In this case, using the HTTP method _delete_, it is possible to remove an object from the database with its id.

The basic operations are the basis for the extra [actions](#the-service-should-allow-) that are included in `DroneController`. The [requirements](#functional-requirements) are checked in the `create` and `update` methods from `DroneController` and in other actions that required them

## Testing APIs
***
The resulting APIs are tested with Postman. In order to test them in another environment, it has been included the file `Drones.postman_collection.json` with the collection of APIs that were implemented and tested.

## Running the project
***
The application uses [Spring Boot](http://projects.spring.io/spring-boot/), so it is easy to run. You can start it any of a few ways:
* Run the `main` method from `DronesApplication`
* Use the Maven Spring Boot plugin: `mvn spring-boot:run`

## Viewing the running application
***
To view the running application, visit [http://localhost:8080](http://localhost:8080) in your browser

## References
* Spring documentation - [https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/](https://docs.spring.io/spring-framework/docs/3.0.0.M4/reference/html/)
* Spring Boot With SQLite - [https://www.baeldung.com/spring-boot-sqlite](https://www.baeldung.com/spring-boot-sqlite)
* [https://github.com/eugenp/tutorials/tree/master/persistence-modules/spring-data-rest](https://github.com/eugenp/tutorials/tree/master/persistence-modules/spring-data-rest)