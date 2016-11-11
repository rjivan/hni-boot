A Spring Boot POC of HNI. See https://github.com/hungernotimpossible/hni for the original version.

#Getting the application running.
The application has been packaged as a standalone java executable. You can either run it as a java application from your IDE (main class HniAdminApplication) or via the
command prompt by executing the maven command mvn spring-boot:run

By default the application launches an embedded H2 database. Upon startup the liquibase scripts located at resources/db/changelog are executed.

Goto to [http://localhost:8080/h2-console](H2 Console) to browse the DB. The JDBC URL for the database is jdbc:h2:mem:testdb

Goto to http://localhost:8080 to view the end points that are available.
