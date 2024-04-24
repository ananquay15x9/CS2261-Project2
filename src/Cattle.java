public class Cattle extends Livestock{
    private double milkYield;
    public Cattle (String name, String healthStatus, String dietRequirements, double milkYield) {
        super(name, healthStatus, dietRequirements);
        this.milkYield = milkYield;

        setWeight(700.0); //Example weight for cattle
        setTemperature(38.5); //Typical body temperature for cattle
        setHeartRate(65); //Typical heart rate for cattle
        setRespiratoryRate(30); //Typical respiratory rate for cattle
    }


    @Override
    public void produce() {
        System.out.println("Cattle produced " + milkYield + " litters of milk.");
    }
}
