# spring-boot-calculator api-application
Iteriam Calculator Test Application

# Port where the microservice publish the API Methods
Microservice Port: 8081

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
mvn clean install

mvn spring-boot:run

# Run Test
mvn test


