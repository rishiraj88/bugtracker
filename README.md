# bugtracker
A simple bug tracker to show the capabilities of:
- Java
- Spring Boot
- Docker
- Database engine (Data store)

## Features
- Create a new bug
- List a bug by code (business-derived identifier)
- List all bugs
- Delete a bug by code
- Delete all bugs

## Enviroment
-----------
Eclipse JEE 2022 / STS / VS Code or another modern IDE for Java Spring Boot projects
JAVA SE 17
JUnit 5.8.2
Spring 5.3.23
Spring 2.7.4

## Running the Project Artifacts
The bug tracker is a well runnable and testable Java implementation along with the instructions required for a reviewer.

### Projects and Components
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

### Contact Points
For any queries, feel free to utilise the contact points at:
https://rrshops.netlify.app/
