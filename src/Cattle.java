public class Cattle extends Livestock{
    private double milkYield;
    public Cattle (String healthStatus, String dietRequirements, double milkYield) {
        super("Cattle", healthStatus, dietRequirements);
        this.milkYield = milkYield;
    }

    @Override
    public void produce() {
        System.out.println("Cattle produced " + milkYield + " litters of milk.");
    }
}
