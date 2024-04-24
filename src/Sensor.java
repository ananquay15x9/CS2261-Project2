public interface Sensor {
    default double readMoistureLevel() {
        return -1;
    }
    default String readWeatherCondition() {
        return "Unknown";
    }
}
