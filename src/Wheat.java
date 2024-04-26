public class Wheat extends Crop{
    public Wheat(String growthStage, String nutrientRequirements, String susceptibilityToDiseases, String waterRequirements, String lightExposure) {
        super("Wheat", growthStage, nutrientRequirements, susceptibilityToDiseases, waterRequirements, lightExposure);
    }

    @Override
    public void produce() {
        System.out.println("Producing wheat grains...");
    }
}
