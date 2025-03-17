FROM openjdk:21

WORKDIR /service
COPY target/*.jar service.jar
EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "/service/service.jar"]