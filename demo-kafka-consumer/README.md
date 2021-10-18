# demo-kafka-consumer

For demonstrate how to consume messages from Kafka

## Getting Started

- Required Kafka instance running

### Start by Single Instance

Start application by run command
```
$ mvn spring-boot:run
```

Default port is 8080

### Start by Multiple Instances

You can build into jar file first
```
$ mvn clean package
```

Execute jar file
```
$ java -jar ./target/consumer-0.0.1-SNAPSHOT.jar
```

Execute with new port and topic
```
$ java -jar -Dserver.port=28080 -Dkafka.topics=some-topic ./target/consumer-0.0.1-SNAPSHOT.jar 
```

You can run jar file in multiple terminals to simulate multiple consumers
