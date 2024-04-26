public class SoilMoistureSensor implements Sensor {
    @java.lang.Override
    public double readMoistureLevel() {
        return 10 + Math.random() * 90;

        //adjust moisture level based on weather condition
    }

    public double readMoistureLevel(String weatherCondition) {
        switch (weatherCondition) {
            case "Stormy":
                return 90 + Math.random() * 10;
            case "Rainy":
                return 65 + Math.random() * 35;
            case "Sunny":
                return Math.random() * 60;
            case "Cloudy":
                return 50 + Math.random() * 10;
            case "Windy":
                return 30 + Math.random() * 10;
            default:
                return readMoistureLevel();
        }
    }
}
