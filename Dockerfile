FROM python
WORKDIR /
COPY . /
ENTRYPOINT ["python3", "src/main.py"]