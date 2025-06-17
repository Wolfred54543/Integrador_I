# Usa una imagen base de OpenJDK
FROM openjdk:17-jre-slim

# Crea un volumen temporal
VOLUME /tmp

# Copia tu archivo JAR al contenedor
COPY target/integrador-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]