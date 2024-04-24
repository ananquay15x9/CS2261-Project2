public class Chicken extends Livestock{

    public Chicken(String name, String healthStatus, String dietRequirements) {
        super(name, healthStatus, dietRequirements);

        // Set defaults or specific values for Chicken
        setWeight(1.5); // Average weight for a chicken in kg
        setTemperature(41.0); // Typical body temperature for chickens
        setHeartRate(280); // Typical heart rate for chickens
        setRespiratoryRate(20); // Typical respiratory rate for chickens
    }

    @Override
    public void produce() {
        System.out.println("Producing eggs...");
    }
}
