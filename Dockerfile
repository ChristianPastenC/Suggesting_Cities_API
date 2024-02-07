FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar large-cities-1.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/large-cities-1.0.1-SNAPSHOT.jar"]
