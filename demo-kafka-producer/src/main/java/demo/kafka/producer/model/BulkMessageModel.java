package demo.kafka.producer.model;

import lombok.Data;

@Data
public class BulkMessageModel {

    public String topic;

    public int total;
}
