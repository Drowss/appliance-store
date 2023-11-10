FROM openjdk:17
ARG JAR_FILE=target/api-gateway-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_api-gateway.jar
ENTRYPOINT ["java", "-jar", "app_api-gateway.jar"]