FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY pom.xml .
COPY src ./src
CMD ["java", "-jar", "target/large-cities-1.0.1-SNAPSHOT.jar"]
