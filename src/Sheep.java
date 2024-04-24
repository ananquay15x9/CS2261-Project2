public class Sheep extends Livestock{
    private int woolProduction;

    public Sheep(String name, String healthStatus, String dietRequirements, int woolProduction) {
        super(name, healthStatus, dietRequirements);
        this.woolProduction = woolProduction;

        setWeight(50.0);
        setTemperature(39.0);
        setHeartRate(70);
        setRespiratoryRate(20);
    }

    @Override
    public void produce()
    {
        System.out.println("Sheep produced " + woolProduction + " kg of wool.");
    }

    //Sheep sheep = new Sheep("Dolly", "Healthy", "Grass diet", 5);
}
