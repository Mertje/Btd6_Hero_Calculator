FROM eclipse-temurin:21-jdk-alpine
MAINTAINER Mert
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]