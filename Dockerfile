#Deriving the latest base image
FROM python:latest

ARG filepath=csvs/test.csv
ARG header=City

ENV HEADER=$header

COPY src/main.py ./
COPY ${filepath} /tmp/test.csv

CMD ["sh", "-c", "python3 ./main.py /tmp/test.csv $HEADER"]