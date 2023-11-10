FROM openjdk:17
ARG JAR_FILE=target/eureka-sv-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_eureka-sv.jar
ENTRYPOINT ["java", "-jar", "app_eureka-sv.jar"]