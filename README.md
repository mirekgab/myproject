# MyProject

## About project

This project is an example of a rest api application. 
Some technical information about it:

- spring boot with H2 database
- enable H2-console at the endpoint /h2-console
- spring security (int developing time all endpoints are allowed)
- unit tests for the business logic
- integration tests  
- the application initialize a database using basic sql scripts [link](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto.data-initialization).  
 

The project is a simple example of a shop application, with the functionality of products, product categories, warehouses and a few others.

The application functionality:
- CRUD for products
- CRUD for categories
- CRUD for customer orders
- business logic for sales operation 

## How to run

## How to run tests

- clone the repository
```shell
git clone https://github.com/mirekgab/myproject.git
```
- go into the directory
```shell
cd myproject/
``` 
- run the test where the order is successful
```shell
./mvnw test -Dtest="OrderControllerIT#orderCompletedSuccessfully"
```
