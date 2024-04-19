public class Cow extends Livestock{
    public Cow(String healthStatus, String dietRequirements) {
        super("Cow", healthStatus, dietRequirements);
    }

    @Override
    public void produce() {
        System.out.println("Producing milk...");
    }
}
