public class IrrigationSystem implements ResourceOptimization{
    @Override
    public void optimizeWaterUsage(double moistureLevel, String weatherCondition) {
        if (moistureLevel < 50) {
            System.out.println("Moisture level is low. Increasing irrigation frequency.");
        } else if (moistureLevel > 90) {
            System.out.println("Moisture level is high. Decreasing irrigation frequency.");
        } else {
            System.out.println("Moisture level is optimal. No changes needed in irrigation.");
        }
    }

    @Override
    public void optimizeEnergyUsage(String weatherCondition) {
        if (weatherCondition.equals("Sunny")) {
            System.out.println("Sunny weather detected. Optimizing energy usage for solar panel.");
        } else {
            System.out.println("Non-sunny weather detected. Optimizing energy usage for efficient power consumption.");
        }
    }
}
