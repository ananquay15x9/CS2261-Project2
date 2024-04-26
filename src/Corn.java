public class Corn extends Crop{
    public Corn (String growthStage, String nutrientRequirements, String susceptibilityToDiseases, String waterRequirements, String lightExposure) {
        super("Corn", growthStage, nutrientRequirements, susceptibilityToDiseases, waterRequirements, lightExposure);
    }

    @Override
    public void produce() {
        System.out.println("Producing corn...");
    }

}

