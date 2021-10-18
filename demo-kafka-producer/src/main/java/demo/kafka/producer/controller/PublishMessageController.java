package demo.kafka.producer.controller;

import demo.kafka.producer.model.BulkMessageModel;
import demo.kafka.producer.model.MessageModel;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishMessageController {

    private final static Logger logger = LoggerFactory.getLogger(PublishMessageController.class.getName());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/publish")
    public String publish(@RequestBody MessageModel message) {

        logger.info("$$$$ => Topic: {} | Message {}", message.getTopic(), message.getMessage());

        if(Strings.isEmpty(message.getKey())) {
            kafkaTemplate.send(message.getTopic(), message.getMessage());
        } else {
            kafkaTemplate.send(message.getTopic(), message.getKey(), message.getMessage());
        }

        return "Published";
    }

    @PostMapping("/publish/bulk")
    public String publishBulk(@RequestBody BulkMessageModel bulk) {

        for(int i=0; i<bulk.getTotal();i++) {
            String message = "Generated Message : " + System.currentTimeMillis() + "_" + i;
            logger.info("$$$$ => Topic: {} | Message {}", bulk.getTopic(), message);
            kafkaTemplate.send(bulk.getTopic(), message);
        }
        return "Published total : " + bulk.getTotal();
    }
}
