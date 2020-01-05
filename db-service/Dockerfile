FROM openjdk:8
EXPOSE 8080
ADD target/db-service-0.0.1-SNAPSHOT.jar db-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/db-service-0.0.1-SNAPSHOT.jar"]