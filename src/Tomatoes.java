public class Tomatoes extends Crop{
    public Tomatoes(String growthStage, String nutrientRequirements, String susceptibilityToDiseases, String waterRequirements, String lightExposure) {
        super("Tomatoes", growthStage, nutrientRequirements, susceptibilityToDiseases, waterRequirements, lightExposure);
    }

    @Override
    public void produce() {
        System.out.println("Producing tomatoes...");
    }
}
