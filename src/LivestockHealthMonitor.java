public class LivestockHealthMonitor {
    private String healthIndicator;
    private String dietRequirement;
    public LivestockHealthMonitor(String healthIndicator) {
        this.healthIndicator = healthIndicator;
    }

    public void monitorHealthStatus(Livestock livestock) {
        System.out.println("Type: " + livestock.getType() + " - " + "Health indicator: " + healthIndicator);
    }

    public void administerMedication(Livestock livestock, String medication) {
        System.out.println("Administering medication to " + livestock.getType() + ": " + medication);
    }
}
