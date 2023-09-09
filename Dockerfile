# Utiliza una imagen base de OpenJDK 17
FROM adoptopenjdk/openjdk17:alpine

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/large-cities-0.0.1-SNAPSHOT.jar /app/large-cities-0.0.1-SNAPSHOT.jar

# Establece el directorio de trabajo en la raíz de la aplicación
WORKDIR /app

# Expone el puerto en el que tu aplicación Spring Boot escucha (por ejemplo, el puerto 8080)
EXPOSE 8080

# Comando de inicio de la aplicación Spring Boot
CMD ["java", "-jar", "large-cities-0.0.1-SNAPSHOT.jar"]
