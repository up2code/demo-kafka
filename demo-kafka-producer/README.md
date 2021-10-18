# demo-kafka-producer

For demonstrate how to publish messages to Kafka with Kafka template

## Getting Started

- Required Kafka instance running

Start application by run command
```
$ mvn spring-boot:run
```

Default port is 8080

## APIs

### [POST] /publish

For test publish message with specified topic and key (optional).

Endpoint: `/publish`

Method: `POST`

Body structure:
```
{
    "topic": "string",
    "key": "string",
    "message": "string"
}
```

- topic: A destination topic name
- key (Optional): You can guarantee destination partition by specified key. Same key will publish into same partition. 
- message: A string value

Example
```
$ curl --location --request POST 'http://localhost:8080/publish' \
--header 'Content-Type: application/json' \
--data-raw '{
    "topic": "test-topic",
    "key": "ABC",
    "message": "Test message ABC 003"
}'
```

### [POST] /publish/random

If you want to test by publish multiple messages. This API can specified how many messages that you want to publish. 

Endpoint: `/publish/random`

Method: `POST`

Body structure:
```
{
    "topic": "string",
    "total": 20
}
```

- topic: A destination topic name
- total: A total number of messages that you want to send

Example
```
$ curl --location --request POST 'http://localhost:8080/publish/random' \
--header 'Content-Type: application/json' \
--data-raw '{
    "topic": "test-topic",
    "total": 20
}'
```