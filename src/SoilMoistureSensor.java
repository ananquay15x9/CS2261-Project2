public class SoilMoistureSensor implements Sensor {
    @java.lang.Override
    public double readMoistureLevel() {
        return Math.random() * 100;
    }
}
