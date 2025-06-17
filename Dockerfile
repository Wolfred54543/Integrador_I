<<<<<<< HEAD
# Usa una imagen base de OpenJDK 17
FROM openjdk:17-slim

# Crea un volumen temporal
VOLUME /tmp

# Copia tu archivo JAR al contenedor
COPY target/integrador-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar tu aplicación
=======
# Usa una imagen base de OpenJDK 17
FROM openjdk:17-slim

# Crea un volumen temporal
VOLUME /tmp

# Copia tu archivo JAR al contenedor
COPY target/integrador-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar tu aplicación
>>>>>>> 93bdcb7c0cf9ba42e4126ba0888525ef4b9c177d
ENTRYPOINT ["java", "-jar", "/app.jar"]