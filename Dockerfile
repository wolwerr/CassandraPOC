# Use a different version of the Maven image to build the application
FROM maven:3.9.9-amazoncorretto-17 AS build

# Define the working directory inside the container
WORKDIR /app

# Copy the Maven configuration files and source code to the working directory
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use the OpenJDK 17 image to run the application
FROM openjdk:17-jdk-slim

# Define the working directory inside the container
WORKDIR /app

# Copy the generated JAR file to the working directory
COPY --from=build /app/target/*.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]