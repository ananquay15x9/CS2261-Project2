public class LivestockHealthMonitor {
    public void viewHealthIndicators(Livestock livestock) {
        System.out.println("Livestock Health Indicators for " + livestock.getName() + ": " +
                "- Weight: " + livestock.getWeight() + " kg " +
                "- Temperature: " + livestock.getTemperature() + "°C " +
                "- Heart Rate: " + livestock.getHeartRate() + " bpm " +
                "- Respiratory Rate: " + livestock.getRespiratoryRate() + " bpm " +
                "Activity Level: " + livestock.getHealthStatus());
    }

    public void trackHealthTrends(Livestock livestock) {
        System.out.println("Livestock Health Trends: - Weight Trend: Stable - Temperature Trend: Increasing - Heart Rate Trend: Normal - Respiratory Rate Trend: Decreasing");
    }
}
