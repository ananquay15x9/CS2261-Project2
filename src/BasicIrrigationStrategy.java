import java.util.Timer;
import java.util.TimerTask;

public class BasicIrrigationStrategy extends IrrigationStrategy{

    @Override
    public double determineIrrigationAmount(double moistureLevel, String weatherCondition, double cropWaterRequirement) {
        double moistureThreshold = 30.0; //can be adjusted

        if (moistureLevel < moistureThreshold && !weatherCondition.equals("Rainy")) {
            return cropWaterRequirement; //can be adjusted.
        } else {
            //If moisture level is above threshold, no irrigation needed.
            return 0.0;
        }
    }

    @Override
    public void scheduleIrrigation() {
        Timer timer = new Timer();
        long delay = 0;
        long period =  24 * 60 * 60 * 1000; //Repeat every 24 hours

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Basic Irrigation scheduled.");
            }
        }, delay, period);
    }
}