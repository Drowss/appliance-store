FROM openjdk:17
ARG JAR_FILE=target/carrito-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_carrito.jar
ENTRYPOINT ["java", "-jar", "app_carrito.jar"]