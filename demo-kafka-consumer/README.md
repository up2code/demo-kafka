# demo-kafka-consumer

For demonstrate how to consume messages from Kafka

## Getting Started

- Required Kafka instance running

### Start by Single Instance

Start application by run command
```
$ mvn spring-boot:run
```

### Start by Multiple Instances

You can build into jar file first
```
$ mvn clean package
```

Execute jar file
```
$ java -jar ./target/consumer-0.0.1-SNAPSHOT.jar
```

Execute with new topic
```
$ java -jar ./target/consumer-0.0.1-SNAPSHOT.jar --kafka.topics=some-topic
```

Execute with new group id
```
$ java -jar ./target/consumer-0.0.1-SNAPSHOT.jar --spring.kafka.consumer.group-id=group-2
```

You can run jar file in multiple terminals to simulate multiple consumers
