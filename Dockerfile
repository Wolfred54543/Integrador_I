# Usa una imagen base de OpenJDK 17
FROM openjdk:17-slim

# Crea un volumen temporal
VOLUME /tmp

# Copia tu archivo JAR al contenedor
COPY target/integrador-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar tu aplicación
# Usa una imagen base de OpenJDK 17
FROM openjdk:17-slim

# Crea un volumen temporal
VOLUME /tmp

# Copia tu archivo JAR al contenedor
COPY target/integrador-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Establece variables de entorno para la conexión a la base de datos
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://dpg-d18v7gjuibrs73blei70-a.oregon-postgres.render.com:5432/db_fap_aw3k
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=CtJ6Id51uWAmQ5gg84hLQ4rxg3Lng3LW

# Comando para ejecutar tu aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-jar", "/app.jar"]
