package demo.kafka.producer.model;

import lombok.Data;

@Data
public class MessageModel {

    public String topic;

    public String key;

    public String message;
}
