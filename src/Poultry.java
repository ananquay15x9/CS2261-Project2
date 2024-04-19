public class Poultry extends Livestock{
    private int eggProduction;

    public Poultry(String healthStatus, String dietRequirements, int eggProduction) {
        super("Poultry", healthStatus, dietRequirements);
        this.eggProduction = eggProduction;
    }

    @Override
    public void produce() {
        System.out.println("Poultry produced " + eggProduction + " eggs.");
    }
}
