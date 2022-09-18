# FROM openjdk:17
FROM gcr.io/distroless/java17-debian11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]