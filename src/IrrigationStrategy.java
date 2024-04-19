public abstract class IrrigationStrategy {
    public abstract double determineIrrigationAmount(double moistureLevel, String weatherCondition);
    public abstract void scheduleIrrigation();
}
