public class IrrigationSystem implements ResourceOptimization{
    @Override
    public void optimizeWaterUsage(double moistureLevel, String weatherCondition) {
        System.out.println("Optimizing water usage for irrigation system...");
    }

    @Override
    public void optimizeEnergyUsage(String weatherCondition) {
        System.out.println("Optimizing energy usage for irrigation system...");
    }
}
