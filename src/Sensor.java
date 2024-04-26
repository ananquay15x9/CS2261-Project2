public interface Sensor {
    default double readMoistureLevel() {
        return -1;
    }

    double readMoistureLevel(String weatherCondition);
    default String readWeatherCondition() {
        return "Unknown";
    }
}
