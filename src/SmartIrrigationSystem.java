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
        double cropWaterRequirement = 100.0;
        //Determine irrigation amount using the selected strategy
        double irrigationAmount = irrigationStrategy.determineIrrigationAmount(moistureLevel, weatherCondition, cropWaterRequirement);

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


    private void applyFertilizer() {
        System.out.println("Fertilizer applied to the crops.");
    }

    private void optimizeResourceUsage() {
        System.out.println("Optimizing water and energy usage...");
        double moistureLevel = moistureSensor.readMoistureLevel();
        String weatherCondition = weatherSensor.readWeatherCondition();

        IrrigationSystem irrigationSystem = new IrrigationSystem();
        irrigationSystem.optimizeWaterUsage(moistureLevel, weatherCondition);
        irrigationSystem.optimizeEnergyUsage(weatherCondition);
        System.out.println("Water and energy usage optimized successfully.");
    }

    private void monitorCropHealth() {
        int numCropsAffected = getRandomNumber(0,3);
        if (numCropsAffected > 0) {
            System.out.println("Crop health issues detected. Taking necessary actions.");

            for (int i = 0; i < numCropsAffected; i++) {
                String crop = getRandomCrop(); //Randomly select a crop
                System.out.println("Action for " + crop + ": " + getActionForCrop(crop));
            }
        } else {
            System.out.println("Crop health is good. No issues detected.");
        }
    }

    private void manageWaste() {
        Scanner scanner = new Scanner(System.in);
        WasteManagement wasteManagement = new WasteManagement();

        System.out.println("==== Waste Management ====");
        System.out.println("1. Manage Waste");
        System.out.println("2. Recycle Materials");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the type of waste: ");
                scanner.nextLine(); // Consume the newline character
                String wasteType = scanner.nextLine();
                wasteManagement.manageWaste(wasteType);
                break;
            case 2:
                System.out.println("Enter the type of material to recycle: ");
                scanner.nextLine(); // Consume the newline character
                String materialType = scanner.nextLine();
                wasteManagement.recycleMaterials(materialType);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private int getRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private String getRandomCrop() {
        String[] crops = {"Corn", "Tomatoes", "Wheat"};
        return crops[getRandomNumber(0, 2)];
    }

    private String getActionForCrop(String crop) {
        String action = "";
        switch (crop) {
            case "Corn":
                action = "Apply targeted pesticide to address pests or diseases.";
                break;
            case "Tomatoes":
                action = "Increase watering frequency and apply balanced fertilizer.";
                break;
            case "Wheat":
                action = "Check for signs of fungal infection and apply appropriate fungicides. Adjust irrigation settings to ensure adequate moisture without waterlogging.";
                break;
        }
        return action;
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
        String formattedMoistureLevel = String.format("%.2f", moistureLevel);
        System.out.println("Sensor Data:");
        System.out.println("Moisture Level: " + formattedMoistureLevel + "%");
        System.out.println("Weather Condition: " + weatherCondition);
    }

    private String getRandomFrequency() {
        String[] frequencies = {"Once a day", "Twice a day", "Three times a day"};
        return frequencies[random.nextInt(frequencies.length)];
    }

    private int mapFrequencyToNumber(String frequency) {
        return switch (frequency) {
            case "Twice a day" -> 2;
            case "Three times a day" -> 3;
            default -> 1;  // "Once a day" or any unrecognized value
        };
    }

    private int getRandomDuration() {
        int[] durations = {20, 15, 30};
        return durations[random.nextInt(durations.length)];
    }

    private void adjustIrrigationSettings() {
        String frequencyString = getRandomFrequency(); //get frequency as a string
        this.frequency = frequencyString;
        int frequencyNumber = mapFrequencyToNumber(frequencyString);
        duration = getRandomDuration();

        //Determine irrigation amount based on current sensor readings and crop requirements
        double irrigationAmount = ((AdvancedIrrigationStrategy) irrigationStrategy).determineIrrigationAmount(moistureSensor.readMoistureLevel(), weatherSensor.readWeatherCondition(), 100.0);
        String formattedMoistureLevel = String.format("%.2f", moistureSensor.readMoistureLevel());
        System.out.println("Irrigation Scheduling Preferences Updated: ");
        System.out.println("Frequency: " + frequencyNumber);
        System.out.println("Duration: " + duration + " minutes per session.");
        System.out.println("Moisture Level: " + formattedMoistureLevel + "%");
        System.out.println("Irrigation Amount: " + duration * frequencyNumber + " gallons");

        //Based on the determined irrigation amount, update irrigation tasks
        if (irrigationAmount > 0) {
            System.out.println("Irrigation needed. Scheduling based on new settings...");
        } else {
            System.out.println("Soil moisture level is sufficient.");
        }

    }

    private void adjustFertilizationSettings() {

        double moistureLevel = moistureSensor.readMoistureLevel();
        String weatherCondition = weatherSensor.readWeatherCondition();
        String formattedMoistureLevel = String.format("%.2f", moistureLevel);
        System.out.println("Sensor Readings: - Soil Moisture Level: " + formattedMoistureLevel + "% - Weather Condition: " + weatherCondition);

    }

    private void generateResourceUsageReport(String frequency, int duration) {
        int multiplier = mapFrequencyToNumber(frequency);
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
        double totalHoursPerDay = (duration * multiplier) / 60.0; //convert duration from minutes to hours for energy calculation
        double powerConsumption = 1.0;  //kW
        double totalEnergyUsagePerDay = powerConsumption * totalHoursPerDay; //energy consumption
        String formattedTotalEnergyUsagePerDay = String.format("%.2f", totalEnergyUsagePerDay);

        // Print the resource usage report
        System.out.println("Resource Usage Report:");
        System.out.println("Water Usage: " + totalWaterUsagePerDay + " gallons per day");
        System.out.println("Energy Usage: " + formattedTotalEnergyUsagePerDay + " kWh per day");

    }

    private Livestock createRandomLivestock(String healthStatus, String dietRequirements) {
        String[] livestockOptions = {"Cow", "Chicken"};
        Random random1 = new Random();
        String randomType = livestockOptions[random1.nextInt(livestockOptions.length)];
        double weight = 100 + 400 * random1.nextDouble(); // Random weight between 100 and 500
        double temperature = 37 + 2 * random1.nextDouble(); // Random temperature between 37 and 39
        int heartRate = 60 + random1.nextInt(41); // Random heart rate between 60 and 100
        int respiratoryRate = 15 + random1.nextInt(11); // Random respiratory rate between 15 and 25

        Livestock livestock;
        switch (randomType) {
            case "Cow":
                livestock = new Cow("Random Cow", healthStatus, dietRequirements);
                break;
            case "Chicken":
                livestock = new Chicken("Random Chicken", healthStatus, dietRequirements);
                break;
            default:
                return null;
        }

        // Optionally set additional properties if needed
        livestock.setWeight(weight);
        livestock.setTemperature(temperature);
        livestock.setHeartRate(heartRate);
        livestock.setRespiratoryRate(respiratoryRate);

        return livestock;
    }

    private void monitorLivestockHealth() {
        Scanner scanner = new Scanner(System.in);
        Livestock livestock = null;
        System.out.println("Select the type of livestock:");
        System.out.println("1. Cow");
        System.out.println("2. Cattle");
        System.out.println("3. Poultry");
        System.out.println("4. Sheep");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                livestock = new Cow("Daisy", "Normal", "Balanced diet");
                livestock.setWeight(500); //Weight for cow
                livestock.setTemperature(38.5); //Body temperature for cow
                livestock.setHeartRate(80); //Set the heart rate
                livestock.setRespiratoryRate(20);
                break;
            case 2:
                livestock = new Cattle("Bessie", "Healthy", "Grass diet", 10.5);
                livestock.setWeight(700); //Example weight for cattle
                livestock.setTemperature(38.5); //Typical body temperature for cattle
                livestock.setHeartRate(65); //Typical heart rate for cattle
                livestock.setRespiratoryRate(30); //Typical respiratory rate for cattle
                break;
            case 3:
                livestock = new Poultry("Healthy", "Grains", 20);
                break;
            case 4:
                livestock = new Sheep("Dolly", "Healthy", "Grass diet", 5);
                livestock.setWeight(50); //Example weight for sheep
                livestock.setTemperature(39.0); //Typical body temperature for sheep
                livestock.setHeartRate(70); //Typical heart rate for sheep
                livestock.setRespiratoryRate(20); //Typical respiratory rate for sheep
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        LivestockHealthMonitor monitor = new LivestockHealthMonitor();
        System.out.println("1. View Health Indicators");
        System.out.println("2. Track Health Trends");
        System.out.println("3. Feed Livestock");
        System.out.println("4. Administer Medication");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                monitor.viewHealthIndicators(livestock);
                break;
            case 2:
                monitor.trackHealthTrends(livestock);
                break;
            case 3:
                livestock.feed(5, 2); // Sample feeding values
                break;
            case 4:
                livestock.administerMedication("Vaccination", 10, "Intramuscular");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void viewCropInformation() {
        Random random = new Random();
        // Define possible values for the attributes
        String[] growthStages = {"Seedling", "Flowering", "Fruiting", "Mature"};
        String[] nutrientRequirements = {"Low", "Moderate", "High"};
        String[] waterRequirements = {"Low", "Moderate", "High"};
        String[] lightExposures = {"Full Sun", "Partial Shade", "Shade"};

        Corn corn = new Corn(growthStages[random.nextInt(growthStages.length)],
                nutrientRequirements[random.nextInt(nutrientRequirements.length)],
                "Low",  // Assume susceptibility to diseases is static or has less variation
                waterRequirements[random.nextInt(waterRequirements.length)],
                lightExposures[random.nextInt(lightExposures.length)]);
        Tomatoes tomatoes = new Tomatoes(growthStages[random.nextInt(growthStages.length)],
                nutrientRequirements[random.nextInt(nutrientRequirements.length)],
                "Medium",  // Assuming medium susceptibility for tomatoes
                waterRequirements[random.nextInt(waterRequirements.length)],
                lightExposures[random.nextInt(lightExposures.length)]);
        Wheat wheat = new Wheat(growthStages[random.nextInt(growthStages.length)],
                nutrientRequirements[random.nextInt(nutrientRequirements.length)],
                "High",  // Assuming high susceptibility for wheat
                waterRequirements[random.nextInt(waterRequirements.length)],
                lightExposures[random.nextInt(lightExposures.length)]);
        System.out.println("Crop Information: ");
        corn.displayDetails();
        tomatoes.displayDetails();
        wheat.displayDetails();
    }


    private void manageCarbonFootprint() {
        Scanner scanner = new Scanner(System.in);
        CarbonFootPrintManager footPrintManager = new CarbonFootPrintManager();
        System.out.println("=== Carbon Footprint Reduction ===");
        System.out.println("1. Track Emissions");
        System.out.println("2. Reduce Emissions");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                footPrintManager.trackEmissions();
                break;
            case 2:
                footPrintManager.reduceEmissions();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void manageFarmDecisions() {
        Scanner scanner = new Scanner(System.in);
        FarmDecisionMaker decisionMaker = new FarmDecisionMaker();
        System.out.println("=== Farm Decision Making ===");
        System.out.println("1. Make Irrigation Decision");
        System.out.println("2. Make Fertilization Decision");
        System.out.println("3. Make Pest Control Decision");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                decisionMaker.makeIrrigationDecision(0.7, "Sunny");
                break;
            case 2:
                decisionMaker.makeFertilizationDecision("Tomatoes");
                break;
            case 3:
                decisionMaker.makePestControlDecision("Corn");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private String getRandomHealthStatus() {
        String[] healthStatuses = {"Good", "Fair", "Needs Maintenance"};
        return healthStatuses[random.nextInt(healthStatuses.length)];
    }

    private void displaySystemStatus(){
        String healthStatus = getRandomHealthStatus();
        String softwareVersion = "v1.2.0"; //Fixed software version, but can also be updated

        System.out.println("System Status: - Overall Health: " + healthStatus + " - Software Version: " + softwareVersion);
        if (healthStatus.equals("Needs Maintenance")) {
            System.out.println("Please check the system for possible issues.");
        }
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
            System.out.println("7. Monitor Crop Health");
            System.out.println("8. Apply Fertilizer");
            System.out.println("9. Water and Energy Usage Optimization");
            System.out.println("10. Waste Management");
            System.out.println("11. Carbon Footprint Reduction");
            System.out.println("12. Farm Decision Making");
            System.out.println("13. Exit");
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
                    monitorCropHealth();
                    break;
                case 8:
                    applyFertilizer();
                    break;
                case 9:
                    optimizeResourceUsage();
                    break;
                case 10:
                    manageWaste();
                    break;
                case 11:
                    manageCarbonFootprint();
                    break;
                case 12:
                    manageFarmDecisions();
                    break;
                case 13:
                    displaySystemStatus();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using the Smart Irrigation System!");
    }

    public static void main(String[] args) {
        Sensor moistureSensor = new SoilMoistureSensor();
        Sensor weatherSensor = new WeatherSensor();
        int defaultDuration = 30;
        int defaultFrequency = 1;

        IrrigationStrategy irrigationStrategy = new AdvancedIrrigationStrategy(
                moistureSensor, weatherSensor, 100.0, "Clay", "Hilly", defaultDuration, defaultFrequency);

        //Create livestock health
        LivestockHealthMonitor livestockHealthMonitor = new LivestockHealthMonitor();
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
