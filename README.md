# spring-boot-calculator api-application
Iteriam Calculator Test Application

# Port where the microservice publish the API Methods
Microservice Port: 
	8081: Active profile = dev
	8082: Active profile = default profile

# Registrstion of in maven local repository of tracer-1.0.0.jar
mvn install:install-file -Dfile=tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=io.corp.calculator -Dversion=<version> 1.0.0 -Dpackaging=jar

# Adding the dependency to pom.xml file

		<!--Spring dependencies -->
		<dependency>
  			<groupId>io.corp.calculator</groupId>
  			<artifactId>tracer</artifactId>
  			<version>1.0.0</version>
  		</dependency>
   
# Compile and run the microservice
mvn -Dmaven.compiler.fork=true clean install -U spring-boot:run -Dmaven.test.skip=true -f pom.xml

# Run Test
mvn test

# Swagger URL
http://localhost:<server.port>/swagger-ui/index.html

# EndPoints
	http://localhost:8081/api/calculator/addWithParams?firstValue=1&secondValue=5
	http://localhost:8081/api/calculator/add?firstValue=1&secondValue=1	
	http://localhost:8081/api/calculator/multiply?firstValue=1&secondValue=1
	http://localhost:8081/api/calculator/subtract?firstValue=1&secondValue=1
	
	

# Technologies
Java 8
Swagger
Spring Boot
Spring AOP
Lombok
Junit
Mockito
rest-assured
Eclipse
Maven
