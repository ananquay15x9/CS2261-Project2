public class SoilMoistureSensor implements Sensor{
    @java.lang.Override
    public double readMoistureLevel() {
        return Math.random() * 100;
    }

    @Override
    public String readWeatherCondition() {
        String[] weatherConditions = {"Sunny", "Rainy", "Cloudy", "Windy"};
        int randomIndex = (int) (Math.random() * weatherConditions.length);
        return weatherConditions[randomIndex];
    }
}
