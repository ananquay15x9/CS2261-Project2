import java.util.Timer;
import java.util.TimerTask;

public class AdvancedIrrigationStrategy extends IrrigationStrategy{

    private Sensor moistureSensor;
    private Sensor weatherSensor;
    private double cropWaterRequirement;
    private String soilType;
    private String topography;

    public AdvancedIrrigationStrategy(Sensor moistureSensor, Sensor weatherSensor, double cropWaterRequirement, String soilType, String topography) {
        this.moistureSensor = moistureSensor;
        this.weatherSensor = weatherSensor;
        this.cropWaterRequirement = cropWaterRequirement;
        this.soilType = soilType;
        this.topography = topography;
    }
    @Override
    public double determineIrrigationAmount(double moistureLevel, String weatherCondition) {
        double moistureThresholdLow = 20.0;
        double moistureThresholdMedium = 50.0;
        double irrigationAmount = 0.0; //Start irrigation

        if (weatherCondition.equals("Rainy")) {
            irrigationAmount = 0.0; //no need to irrigate
    } else {
            if (moistureLevel < moistureThresholdLow) {
                irrigationAmount = cropWaterRequirement * 0.7; //let's say 70% of crop water requirement
            } else if (moistureLevel < moistureThresholdMedium) {
                irrigationAmount = cropWaterRequirement * 0.3;
            } else {
                irrigationAmount = 0.0;
            }
        }
        return irrigationAmount;
}

    @Override
    public void scheduleIrrigation() {
        Timer timer = new Timer();
        long delay = 0;
        long period = 24 * 60 * 60 * 1000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                double moistureLevel = moistureSensor.readMoistureLevel();
                String weatherCondition = weatherSensor.readWeatherCondition();

                double irrigationAmount = determineIrrigationAmount(moistureLevel, weatherCondition);

                //Print some info
                System.out.println("Moisture Level: " + moistureLevel);
                System.out.println("Weather Condition: " + weatherCondition);
                System.out.println("Irrigation Amount: " + irrigationAmount);
            }
        }, delay, period);
    }

    public void adjustIrrigationSchedule() {
        scheduleIrrigation();
    }

    public void considerSoilTypeAndTopography() {
        if (soilType.equals("Sandy") && topography.equals("Flat")) {
            System.out.println("Adjusting irrigation strategy for sandy soil and flat topography.");
        } else if (soilType.equals("Clay") && topography.equals("Hilly")) {
            System.out.println("Adjusting irrigation strategy for clay soil and hilly topography.");
        } else {
            System.out.println("Applying default irrigation strategy.");
        }
    }
}
