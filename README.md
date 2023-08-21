# kyrrus_takehome

## Python

### To Run from command line without Docker
```
python3 src/main.py {FILE_PATH} {COLUMN_NAME}
```

### To run with Docker

Make Sure the Dockerfile contains:

```
FROM python
WORKDIR /
COPY . /
ENTRYPOINT ["python3", "src/main.py"]
```
```
docker build -t csv_parser .

docker run --name container csv_parser {FILE_PATH} {COLUMN_NAME}
```

Keep in mind, for the Docker container to use your test file you must have it in this directory when you build the image.

Additionally, this will not work if values have commas in them with a full sentence (ie. the motto is "Well, this is a really long motto").

## Java

### To Run from command line without Docker
```
javac --release 17 src/Parser.java

java Parser {FILE_PATH} {COLUMN_NAME}
```

### To run with Docker (WIP)

Make sure the Dockerfile contains:
```
FROM alpine:latest
WORKDIR /
COPY . /
RUN apk --update add openjdk17-jre

COPY target/gs-maven-0.1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
```
mvn package

docker image build -t docker-java-jar:latest .

docker run docker-java-jar:latest
```