public abstract class Livestock {
    private String name;
    private double weight;
    private double temperature;
    private int heartRate;
    private int respiratoryRate;
    private String healthStatus;
    private String dietRequirements;

    public Livestock (String name, String healthStatus, String dietRequirements) {
        this.name = name;
        this.weight = 5.0;
        this.temperature = 40.0;
        this.heartRate = 120;
        this.respiratoryRate = 30;
        this.healthStatus = healthStatus;
        this.dietRequirements = dietRequirements;
    }

    public abstract void produce();

    // Getters and Setters for new fields


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public String getName() { return name; }
    public double getWeight() { return weight; }
    public double getTemperature() { return temperature; }
    public int getHeartRate() { return heartRate; }
    public int getRespiratoryRate() { return respiratoryRate; }
    public String getHealthStatus() { return healthStatus; }
    public String getDietRequirements() { return dietRequirements; }

    public void feed(double hay, double grains) {
        System.out.println("Feeding " + name + " with " + hay + " kg of hay and " + grains + " kg of grains.");
    }

    public void administerMedication(String medication, double dosage, String injectionSite) {
        System.out.println("Administering " + medication + " to " + name + ". Dosage: " + dosage + "ml, Injection Site: " + injectionSite);
    }
}
