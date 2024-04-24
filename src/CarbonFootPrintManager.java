public class CarbonFootPrintManager implements CarbonFootprint{
    @Override
    public void trackEmissions() {
        System.out.println("Tracking emissions from farm activities...");
    }

    @Override
    public void reduceEmissions() {
        System.out.println("Identifying and implementing measures to reduce carbon emissions...");
    }
}
