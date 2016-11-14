A Spring Boot POC of HNI. See https://github.com/hungernotimpossible/hni for the original version.

#Getting the application running.
The application has been packaged as a standalone java executable. You can either run it as a java application from your IDE (main class HniAdminApplication) or via the
command prompt by executing the maven command mvn spring-boot:run

By default the application launches an embedded H2 database. Upon startup the liquibase scripts located at resources/db/changelog are executed.

Goto to [http://localhost:8080/h2-console](http://localhost:8080/h2-console) to browse the DB. The JDBC URL for the database is jdbc:h2:mem:testdb

Goto to [http://localhost:8080](http://localhost:8080) to view the end points that are available.

The application uses OAuth2 and JWT for Authentication and Authorization. 
To get an access token perform a post to[http://localhost:8080/oauth/token?grant_type=password&username=superuser@hni.com&password=password]http://localhost:8080/oauth/token?grant_type=password&username=superuser@hni.com&password=password1

When accessing the protected resources pass in the Authorization header with Bearer <access_token>. Example
 
GET /users HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0NzkxOTU5ODMsInVzZXJfbmFtZSI6InN1cGVydXNlckBobmkuY29tIiwiYXV0aG9yaXRpZXMiOlsiVVNFUiJdLCJqdGkiOiJhYTQ4NGE1OC0wZTI0LTQ3NDktOGQ0Yi04NzVhNmUwMThiMDAiLCJjbGllbnRfaWQiOiJ0cnVzdGVkLWFwcCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.vSuzgpQolGhNSOaXo8gqc_AA57rrGMmxEzAwtLFpTH8 

