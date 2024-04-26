import java.util.Random;

public class CarbonFootPrintManager implements CarbonFootprint{
    double upperBound = 16.0;
    Random rand = new Random();
    double carbonWeight = rand.nextDouble(upperBound);

    @Override
    public void reduceEmissions() {
        double carbonEmission = trackEmissions();

        if (carbonEmission >=13) {
            System.out.println("Carbon Emissions level almost reaches 15.0, WAY TOO HIGH. Increasing covering over crops IMMEDIATELY");
            carbonEmission /= 2;
        } else if (carbonEmission <= 5.0) {
            System.out.println("PERFECT! Carbon Emission is at a PERFECT level");
        } else  {
            System.out.println("Carbon Emission needs to be lower. Asking someone to cover the crops");
        }
    }

    @Override
    public double trackEmissions() {
        double carbon = carbonWeight * 0.87;

        System.out.println("Carbon emissions from farm activities is " + String.format("%.2f", carbon));

        return carbon;
    }
}
