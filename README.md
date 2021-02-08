# User Feedback

User Feedback is a Java Spring Boot with Hibernate project that will capture user feedback using a REST endpoint. The REST resource will take in parameters using HTTP POST. The feedback data will be then added to a database table.

## Installation

Use [docker](https://docs.docker.com/get-docker/) for database.

```bash
docker-compose --file docker/compose.yaml up --build -d
```
Run in IDE by importing /feedback 
or by using Maven
```bash
cd /feedback
mvn spring-boot:run
```

## Usage

Use [http://localhost:8081/feedback/all](http://localhost:8081/feedback/all) to get all feedbacks.
Use http://localhost:8081/feedback/{id} to get feedback with id.
Post to http://localhost:8081/feedback/submit to add feedback to database.

## Stopping

```bash
docker-compose --file docker/compose.yaml down
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
