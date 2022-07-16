# multi-module-springboot
Project consists of 3 componens:
- FamilyApp - listening on port: 3030
- FamilyMemberApp - listening on port: 10101
- MySql Database - listening on port: 3306

Used docker compose to definie multi-container application.
To run the project use: 
- mvn clean package
- then to build up all containers - docker-compose up

Used spring data jdbc to communicate with database and flyway (https://flywaydb.org/) to create schemas.

Link to the postman collection with example of use:
https://www.getpostman.com/collections/78c18802019446c54bdb
