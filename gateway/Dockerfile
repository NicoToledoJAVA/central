FROM openjdk:18.0.2
ARG JAR_FILE=target/gateway-1.jar
COPY ${JAR_FILE} app_gateway.jar
EXPOSE 443
ENTRYPOINT ["java", "-jar", "app_gateway.jar"]