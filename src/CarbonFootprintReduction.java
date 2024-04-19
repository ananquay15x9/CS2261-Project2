public class CarbonFootprintReduction extends CarbonFootprint{
    @Override
    public void trackEmissions() {
        System.out.println("Tracking emissions from farm activities...");
    }

    @Override
    public void reduceEmissions() {
        System.out.println("Implementing measures to reduce emissions...");
    }
}
