FROM openjdk:18.0.2
ARG JAR_FILE=target/server-1.jar
COPY ${JAR_FILE} eureka_server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka_server.jar"]


