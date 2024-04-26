public class Cow extends Livestock{
    public Cow(String name, String healthStatus, String dietRequirements) {
        super(name, healthStatus, dietRequirements);
        // Other cow-specific initialization here
    }

    @Override
    public void produce() {
        System.out.println("Producing milk...");
    }

    public class Chicken extends Livestock {
        public Chicken (String name, String healthStatus, String dietRequirements) {
            super(name, healthStatus, dietRequirements);
            // Other chicken-specific initialization here
        }

        @Override
        public void produce() {
            System.out.println("Chicken lays eggs.");
        }
    }
}
