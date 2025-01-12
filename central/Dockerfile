FROM openjdk:18.0.2
ARG JAR_FILE=target/central-1.jar
COPY ${JAR_FILE} app_central.jar
EXPOSE 8180
ENTRYPOINT ["java", "-jar", "app_central.jar"]


