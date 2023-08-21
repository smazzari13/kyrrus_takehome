FROM alpine:latest
WORKDIR /
COPY . /
RUN apk --update add openjdk17-jre

COPY target/gs-maven-0.1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]