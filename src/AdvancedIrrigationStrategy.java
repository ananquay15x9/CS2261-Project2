import java.util.Timer;
import java.util.TimerTask;

public class AdvancedIrrigationStrategy extends IrrigationStrategy{

    private Sensor moistureSensor;
    private Sensor weatherSensor;
    private double cropWaterRequirement;
    private String soilType;
    private String topography;
    private int duration;
    private int frequency;

    public AdvancedIrrigationStrategy(Sensor moistureSensor, Sensor weatherSensor, double cropWaterRequirement, String soilType, String topography, int duration, int frequency) {
        this.moistureSensor = moistureSensor;
        this.weatherSensor = weatherSensor;
        this.cropWaterRequirement = cropWaterRequirement;
        this.soilType = soilType;
        this.topography = topography;
        this.duration = duration;
        this.frequency = frequency;
    }


    @Override
    public double determineIrrigationAmount(double moistureLevel, String weatherCondition, double cropWaterRequirement) {
        double irrigationRate = 1.0; //Gallons per minutes
        double moistureThresholdLow = 20.0;
        double moistureThresholdMedium = 50.0;
        double irrigationAmount = 0.0; //Start irrigation

        if (weatherCondition.equals("Rainy")) {
            if (moistureLevel < moistureThresholdLow) {
                irrigationAmount = cropWaterRequirement * 0.7;
            } else if (moistureLevel < moistureThresholdMedium) {
                irrigationAmount = cropWaterRequirement * 0.3;
            }
        }

        double totalWaterUsage = irrigationRate * duration * frequency;
        return Math.min(irrigationAmount, totalWaterUsage);
    }

    @Override
    public void scheduleIrrigation() {
        Timer timer = new Timer();
        long period = 86400000; //24 hours in milliseconds

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                double moistureLevel = moistureSensor.readMoistureLevel();
                String weatherCondition = weatherSensor.readWeatherCondition();

                double irrigationAmount = determineIrrigationAmount(moistureLevel, weatherCondition, cropWaterRequirement);

                //Print some info
                if (irrigationAmount > 0) {
                    System.out.println("Irrigation scheduled. Amount: " + irrigationAmount + " gallons.");
                } else {
                    System.out.println("No irrigation needed at this time.");
                }
            }
        }, 0, period);
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