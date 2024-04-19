public class CarbonFootprintTracker extends CarbonFootprint { //change from implements to extend
    @Override
    public void reduceEmissions() {
        System.out.println("Tracking emissions from farm activities...");
    }

    @Override
    public void trackEmissions() {
        System.out.println("Implementing measures to reduce emissions...");
    }
}
