# Use an official OpenJDK runtime as a parent image
# no need for external tomcat server as used embedded one , refer pom.xml
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file to the container
COPY target/spring-ems.war /app/app.war

# Expose the port that the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.war"]
