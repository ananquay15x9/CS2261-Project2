public class Wheat extends Crop{
    public Wheat(String growthStage, String nutrientRequirements, String susceptibilityToDiseases) {
        super("Wheat", growthStage, nutrientRequirements, susceptibilityToDiseases);
    }

    @Override
    public void produce() {
        System.out.println("Producing wheat...");
    }
}
