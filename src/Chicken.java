public class Chicken extends Livestock{
    public Chicken (String healthStatus, String dietRequirements) {
        super("Chicken", healthStatus, dietRequirements);
    }

    @Override
    public void produce() {
        System.out.println("Producing eggs...");
    }
}
