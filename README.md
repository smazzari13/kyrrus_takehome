# kyrrus_takehome

## To Run from command line without Docker
```
python3 src/main.py {FILE_PATH} {COLUMN_NAME}
```

## To run with Docker
```
docker build -t csv_parser .

docker run --name container csv_parser {FILE_PATH} {COLUMN_NAME}
```

Keep in mind, for the Docker container to use your test file you must have it in this directory when you build the image.

Additionally, this will not work if values have commas in them with a full sentence (ie. the motto is "Well, this is a really long motto").
