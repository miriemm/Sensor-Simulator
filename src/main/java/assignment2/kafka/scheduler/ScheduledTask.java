package assignment2.kafka.scheduler;

import assignment2.SensorSimulatorApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    @Autowired
    SensorSimulatorApp.MessageProducer messageProducer;

    @Scheduled(fixedRate = 5000)
    public void method() {
        messageProducer.sendSensorValue();
    }
}
