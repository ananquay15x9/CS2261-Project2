public class WeatherSensor implements Sensor{
    @Override
    public String readWeatherCondition() {
        String[] conditions = {"Sunny", "Cloudy", "Rainy", "Windy", "Stormy"};
        int index = (int) (Math.random() * conditions.length);
        return conditions[index];
    }

    @Override
    public double readMoistureLevel() {
        return Math.random() * 100;
    }
}
