package demo.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class DemoKafkaConsumerApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoKafkaConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoKafkaConsumerApplication.class, args);
    }

    @KafkaListener(topics = "${kafka.topics}")
    public void consume(ConsumerRecord<String, String> record) {
        logger.info("$$$$ => Consumed message {}", record);
    }
}
