public abstract class IrrigationStrategy {

    public abstract double determineIrrigationAmount(double moistureLevel, String weatherCondition, double cropWaterRequirement);

    public abstract void scheduleIrrigation();
}