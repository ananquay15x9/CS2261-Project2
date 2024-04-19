public class Tomatoes extends Crop{
    public Tomatoes(String growthStage, String nutrientRequirements, String susceptibilityToDiseases) {
        super("Tomatoes", growthStage, nutrientRequirements, susceptibilityToDiseases);
    }

    @Override
    public void produce() {
        System.out.println("Producing tomatoes...");
    }
}
