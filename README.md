# Demo Basic Apache Kafka with Spring Boot

## demo-kafka-producer

Provide simple APIs for demonstrate how spring boot produce messages to Kafka

```
[POST] /publish
[POST] /publish/random
```

See also in `demo-kafka-producer`

## demo-kafka-consumer

For demonstrate how app consume message from Kafka in Spring boot.

Simply start with mvn command or build as jar and run as multiple consumers.

See also in `demo-kafka-consumer`

## Startup Kafka in Local

```
$ docker-compose up -d zookeeper broker
```

#### Create a topic
```
$ docker exec broker \
kafka-topics --bootstrap-server broker:9092 \
             --create \
             --partitions 3 \
             --topic test-topic
```

#### List topics
```
$ docker exec broker kafka-topics --list --zookeeper zookeeper:2181
```

#### Write messages to the topic
```
$ docker exec --interactive --tty broker \
kafka-console-producer --bootstrap-server broker:9092 \
                       --topic test-topic
```

#### Read messages from the topic
```
$ docker exec --interactive --tty broker \
kafka-console-consumer --bootstrap-server broker:9092 \
                       --topic test-topic \
                       --from-beginning
```

#### Kafka with UI

Check [OffsetExplorer](https://www.kafkatool.com/download.html)
