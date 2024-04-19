import java.util.Random;
import java.util.Scanner;

public class SmartIrrigationSystem {
    private Sensor moistureSensor;
    private Sensor weatherSensor;
    private IrrigationStrategy irrigationStrategy;
    private LivestockHealthMonitor livestockHealthMonitor;
    private LivestockProductionManager livestockProductionManager;
    private static final String[] FREQUENCY_OPTIONS = {"Twice a day", "Once a day", "Three times a day"};
    private static final int[] DURATION_OPTIONS = {15, 30, 10}; // Duration options in minutes
    private static final Random random = new Random();
    private String frequency;
    private int duration;

    public SmartIrrigationSystem(Sensor moistureSensor, Sensor weatherSensor, IrrigationStrategy irrigationStrategy, LivestockHealthMonitor livestockHealthMonitor, LivestockProductionManager livestockProductionManager) {
        this.moistureSensor = moistureSensor;
        this.weatherSensor = weatherSensor;
        this.irrigationStrategy = irrigationStrategy;
        this.livestockHealthMonitor = livestockHealthMonitor;
        this.livestockProductionManager = livestockProductionManager;
    }

    public void collectSensorDataAndIrrigate() {
        double moistureLevel = moistureSensor.readMoistureLevel();
        String weatherCondition = moistureSensor.readWeatherCondition();

        //Determine irrigation amount using the selected strategy
        double irrigationAmount = irrigationStrategy.determineIrrigationAmount(moistureLevel, weatherCondition);

        //print sensor data
        System.out.println("Moisture Level: " + moistureLevel);
        System.out.println("Weather Condition: " + weatherCondition);
        System.out.println("Irrigation Amount: " + irrigationAmount);

        //Invoke irrigation based on the determined amount
        if (irrigationAmount > 0) {
            irrigationStrategy.scheduleIrrigation();
        } else {
            System.out.println("No irrigation needed.");
        }
    }


    public void applyFertilizer() {
        System.out.println("Fertilizer applied.");
    }

    public boolean detectPestPresence() {
        //assume we randomly detect pests
        double probability = Math.random();
        return probability < 0.5; //assuming a 50% chance of detecting pests
    }

    public double measureNutrientLevel() {
        //generate random nutrient level between 0 and 100
        return Math.random() * 100;
    }

    private void viewSensorData() {
        double moistureLevel = moistureSensor.readMoistureLevel();
        String weatherCondition = weatherSensor.readWeatherCondition();
        System.out.println("Sensor Data:");
        System.out.println("Moisture Level: " + moistureLevel);
        System.out.println("Weather Condition: " + weatherCondition);
    }

    private String getRandomFrequency() {
        String[] frequencies = {"Once a day", "Twice a day", "Three times a day"};
        return frequencies[random.nextInt(frequencies.length)];
    }

    private int getRandomDuration() {
        int[] durations = {20, 15, 20};
        return durations[random.nextInt(durations.length)];
    }

    private void adjustIrrigationSettings() {
        frequency = getRandomFrequency();
        duration = getRandomDuration();
        System.out.println("Irrigation Scheduling Preferences Updated: - Frequency: " + frequency + " - Duration: " + duration + " minutes per session.");

    }

    private void adjustFertilizationSettings() {

        double moistureLevel = moistureSensor.readMoistureLevel();
        String weatherCondition = weatherSensor.readWeatherCondition();
        String formattedMoistureLevel = String.format("%.2f", moistureLevel);
        System.out.println("Sensor Readings: - Soil Moisture Level: " + formattedMoistureLevel + "% - Weather Condition: " + weatherCondition);

    }

    private void generateResourceUsageReport(String frequency, int duration) {
        int multiplier;
        switch (frequency) {
            case "Once a day":
                multiplier = 1;
                break;
            case "Twice a day":
                multiplier = 2;
                break;
            case "Three times a day":
                multiplier = 3;
                break;
            default:
                multiplier = 1; // Default to once a day if frequency is not recognized
                break;
        }
        double totalWaterUsagePerDay = duration * multiplier;

        // Print the resource usage report
        System.out.println("Resource Usage Report:");
        System.out.println("Water Usage: " + totalWaterUsagePerDay + " gallons per day");

    }

    private Livestock createRandomLivestock(String healthStatus, String dietRequirements) {
        String[] livestockOptions = {"Cow", "Chicken"};
        Random random1 = new Random();
        String randomType = livestockOptions[random1.nextInt(livestockOptions.length)];
        return switch (randomType) {
            case "Cow" -> new Cow(healthStatus, dietRequirements);
            case "Chicken" -> new Chicken(healthStatus, dietRequirements);
            default -> null;
        };
    }

    private void monitorLivestockHealth() {
        LivestockHealthMonitor monitor = new LivestockHealthMonitor("Healthy");
        Cow cow = new Cow("Healthy", "Balanced diet");
        monitor.monitorHealthStatus(cow);
    }

    private void viewCropInformation() {
        Tomatoes tomatoes = new Tomatoes("Growing", "High", "Diseases not detected");
        System.out.println("Crop Information:");
        System.out.println(tomatoes.getName() + " - " + tomatoes.getGrowthStage() + " - Nutrient is " + tomatoes.getNutrientRequirements() + " - " + tomatoes.getSusceptibilityToDiseases());
    }


    private boolean detectCropHealthIssue() {
        // Simulate detection of crop health issue
        // For demonstration, let's randomly simulate the detection
        double randomValue = Math.random();
        return randomValue < 0.2; // 20% chance of detecting a crop health issue
    }

    private boolean detectLivestockHealthIssue() {
        // Simulate detection of livestock health issue
        // For demonstration, let's randomly simulate the detection
        double randomValue = Math.random();
        return randomValue < 0.2; // 20% chance of detecting a livestock health issue
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("==== Smart Irrigation System Menu ====");
            System.out.println("1. View Sensor Data");
            System.out.println("2. Adjust Irrigation Settings");
            System.out.println("3. Initiate Sensor Readings");
            System.out.println("4. Resource Usage Report");
            System.out.println("5. Monitor Livestock Health");
            System.out.println("6. Manage Crops");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewSensorData();
                    break;
                case 2:
                    adjustIrrigationSettings();
                    break;
                case 3:
                    adjustFertilizationSettings();
                    break;
                case 4:
                    adjustIrrigationSettings();
                    generateResourceUsageReport(frequency, duration);
                    break;
                case 5:
                    monitorLivestockHealth();
                    break;
                case 6:
                    viewCropInformation();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using the Smart Irrigation System!");
    }

    public static void main(String[] args) {
        Sensor moistureSensor = new SoilMoistureSensor();
        Sensor weatherSensor = new WeatherSensor();

        IrrigationStrategy irrigationStrategy = new AdvancedIrrigationStrategy(moistureSensor, weatherSensor, 100.0, "Clay", "Hilly");

        //Create livestock health
        LivestockHealthMonitor livestockHealthMonitor = new LivestockHealthMonitor("Healthy");
        LivestockProductionManager livestockProductionManager = new LivestockProductionManager();

        //Create the smart farming system
        SmartIrrigationSystem irrigationSystem = new SmartIrrigationSystem(moistureSensor, weatherSensor, irrigationStrategy, livestockHealthMonitor, livestockProductionManager);

        //Start the menu
        irrigationSystem.startMenu();

        //Collect sensor data and irrigate
        irrigationSystem.collectSensorDataAndIrrigate();

        //generate resource usage report
        irrigationSystem.generateResourceUsageReport(irrigationSystem.getRandomFrequency(), irrigationSystem.getRandomDuration());
        irrigationSystem.applyFertilizer();

        //Detect pest presence and measure nutrient levels
        boolean pestDetected = irrigationSystem.detectPestPresence();
        double nutrientLevel = irrigationSystem.measureNutrientLevel();

        //print results
        System.out.println("Pest detected: " + pestDetected);
        System.out.println("Nutrient level in soil: " + nutrientLevel);
    }
}
