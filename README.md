# bugtracker
A simple bug tracker to showcase the prominent capabilities of:
- Java
- Spring MVC
- Docker
- MongoDB: Database engine (Data store)

## Functionalities
- Create a new bug
- List a bug by code (business-derived identifier)
- List all bugs
- Delete a bug, selected by code
- Delete all bugs

## Enviroment
- Eclipse JEE 2022 / STS / VS Code or another modern IDE for Java Spring Boot projects
- JAVA SE 17
- JUnit 5.8.2
- Spring Framework 5.3.23
- Spring Boot 2.7.4

## Note about Major Overhaul and Bug Fixes
Few major programming errors have been located in the code. Those are planned to fix this weekend.

## Running the Project Artifacts
The bug tracker is a well runnable and testable Java implementation along with the instructions required for a reviewer.

### Component Services
- bug-tracker: to manage bugs for a department or a firm
- mongo: Mongo DB to store data while the bug-tracker project is running. The data can be made persistent with container volumes.
- mongo-express: Web UI for Mongo DB.

## Instructions for a Reviewer to Execute the Services

### Compile and Install Projects
- Inside bug-tracker project directory: Run `mvn install`.

### Start Services
The services should be started in the following order to ensure smooth functioning:
- Follow the two shell commands to start mongodb and mongo-express, as listed in start.sh script file.
- Run the bug-tracker manually with IDE or with command line (with `java` command with suitable options).

### Access the Services
Hit the following URLs with a web browser or a REST client:

GET
http://localhost:9002/bugs/list

GET
http://localhost:9002/bugs

POST
http://localhost:9002/bugs/create

GET
http://localhost:9002/bugs/list/INVOICEPAY-001

DELETE
http://localhost:9002/bugs/delete/INVOICEPAY-001

DELETE
http://localhost:9002/bugs/deleteall

PUT
http://localhost:9002/bugs/updatedesc/INVOICEPAY-001

### Contact Points
For any queries, feel free to utilise the contact points at:
https://bio.link/rishiraj49de

### Status and Growth Progress
Initially developed in Sep-2022. Started to be upgraded and enhanced in Mar-2023.
