public class Sheep extends Livestock{
    private int woolProduction;

    public Sheep(String healthStatus, String dietRequirements, int woolProduction) {
        super("Sheep", healthStatus, dietRequirements);
        this.woolProduction = woolProduction;
    }

    @Override
    public void produce()
    {
        System.out.println("Sheep produced " + woolProduction + " kg of wool.");
    }
}
