# Guitar Inventory (Backend)
A RESTful API microservice for a theoretical guitar inventory system. 

### Technologies and Languages
- Java 
- Spring Boot
- SQL
- MySQL
- Docker

### How to Set Up
1. Ensure you have MySQL installed and running. Can be downloaded here: https://dev.mysql.com/downloads/mysql/
2. Run the guitar_inventory_init.sql file to create the database and tables.
3. Navigate to **guitarinventory/src/main/resources/application.properties** and set the url, username, and password if different.
4. At his point can run in IDE or continue to build Docker Image.
5. Run Maven Lifecycle clean, then install.
6. In terminal inside root directory of project, run `docker build -f Dockerfile -t guitar-inventory .` 
7. Use Docker Desktop app to run image or run `docker run --name guitar-inventory -p 8080:8080 guitar-inventory`

# API
Base URL : **/api/v1/**

**NOTE:** Still developing API. For now, simply returns arrays of strings. Will return JSON objects.

### GET
- **/guitars** : `["Les Paul", "Stratocaster" ... ]`
- **/manufacturers** : `["Gibson", "Fender" ... ]`
- **/all** : `["Gibson Les Paul", "Fender Stratocaster" ... ]`
