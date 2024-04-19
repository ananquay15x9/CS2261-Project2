public abstract class Livestock {
    private String type;
    private String healthStatus;
    private String dietRequirements;

    public Livestock (String type, String healthStatus, String dietRequirements) {
        this.type = type;
        this.healthStatus = healthStatus;
        this.dietRequirements = dietRequirements;
    }

    public abstract void produce();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getDietRequirements() {
        return dietRequirements;
    }

    public void setDietRequirements(String dietRequirements) {
        this.dietRequirements = dietRequirements;
    }
}
