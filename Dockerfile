FROM adoptopenjdk:17-jdk-hotspot-bionic
WORKDIR /app
COPY pom.xml .
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/large-cities-1.0.1-SNAPSHOT.jar"]
