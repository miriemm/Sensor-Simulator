package assignment2.kafka;

import java.time.LocalDateTime;

public class CustomMessage {

   private LocalDateTime timestamp;
   private Integer sensor_id;
   private Double measurement_value;

    public CustomMessage(LocalDateTime timestamp, Integer sensor_id, Double measurement_value) {
        this.timestamp = timestamp;
        this.sensor_id = sensor_id;
        this.measurement_value = measurement_value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }

    public Double getMeasurement_value() {
        return measurement_value;
    }

    public void setMeasurement_value(Double measurement_value) {
        this.measurement_value = measurement_value;
    }

    @Override
    public String toString() {
        return timestamp + ", " + sensor_id + ", " + measurement_value + "!";
    }
}