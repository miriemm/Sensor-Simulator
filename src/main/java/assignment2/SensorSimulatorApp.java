package assignment2;

import java.time.LocalDateTime;
import java.util.List;

import assignment2.csv.MonitoredData;
import assignment2.kafka.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SensorSimulatorApp {

    static int sensorLineIndex = 0;

    static List<List<String>> sensorListValues;

    public static void main(String[] args) throws Exception {

        sensorListValues = MonitoredData.readData();

        ConfigurableApplicationContext context = SpringApplication.run(SensorSimulatorApp.class, args);
        //messageProducer = context.getBean(MessageProducer.class);

        //context.close();
    }

    @Bean
    public MessageProducer messageProducer() {
        return new MessageProducer();
    }

    public static class MessageProducer {


        @Autowired
        private KafkaTemplate<String, CustomMessage> kafkaTemplate;

        @Value(value = "${sensor.sensor_id}")
        private Integer sensorId;

        private String topicName = "jz9u69h5-default";


        // Sensor simulation for sensor with id 7
        public void sendSensorValue() {

            if (sensorLineIndex < sensorListValues.size()) {
                String sensorValue = sensorListValues.get(sensorLineIndex).get(0);
                CustomMessage sensorValueMessage = new CustomMessage(LocalDateTime.now(), sensorId, Double.parseDouble(sensorValue));
                kafkaTemplate.send(topicName, sensorValueMessage);
                sensorLineIndex++;
            }
        }

    }

}