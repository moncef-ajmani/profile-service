FROM openjdk:19
EXPOSE 8081
ADD target/profile-service.jar profile-service.jar
ENTRYPOINT ["java","-jar","/profile-service.jar"]