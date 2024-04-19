public class Corn extends Crop{
    public Corn (String growthStage, String nutrientRequirements, String susceptibilityToDiseases) {
        super("Corn", growthStage, nutrientRequirements, susceptibilityToDiseases);
    }

    @Override
    public void produce() {
        System.out.println("Producing corn...");
    }
}
