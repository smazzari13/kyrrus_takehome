FROM alpine:latest
ADD src/Parser.class Parser.class
ADD src/Row.class Row.class
RUN apk --update add openjdk17-jre
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "Parser"]