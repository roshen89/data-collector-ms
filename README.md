# data-collector-ms
Data Collector

## Technical Stack
1. Java 8
2. Spring Boot 2.2.4
3. Maven
4. Apache Kafka


#### Description
* consume http requests with JSON in a body (In case of local run of application, **POST** request to http://localhost:8082/api/user/send)
> {
> "first_name": <text>,
> "last_name": <text>,
> "age": <number>
> }
* read calculation seed from application properties file
* send all information to the kafka




