FROM maven:3.8.3-openjdk-17 AS builder
ENV SPRING_CLOUD_CONFIG_URI http://192.168.1.103:8888

WORKDIR /app

# Copy the Maven project file(s) to the container
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline -B

# Copy the source code to the container
COPY src ./src

# Build the application
RUN mvn install

FROM openjdk:19

WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/profile-service.jar profile-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/profile-service.jar"]
