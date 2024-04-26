import javax.swing.*;

public abstract class Crop {
    private String name;
    private String growthStage;
    private String nutrientRequirements;
    private String susceptibilityToDiseases;
    private String waterRequirements;
    private String lightExposure;


    public Crop(String name, String growthStage, String nutrientRequirements, String susceptibilityToDiseases, String waterRequirements, String lightExposure) {
        this.name = name;
        this.growthStage = growthStage;
        this.nutrientRequirements = nutrientRequirements;
        this.susceptibilityToDiseases = susceptibilityToDiseases;
        this.waterRequirements = waterRequirements;
        this.lightExposure = lightExposure;
    }

    public abstract void produce();


    // Getters and setters for all properties
    public String getName() { return name; }
    public String getGrowthStage() { return growthStage; }
    public String getNutrientRequirements() { return nutrientRequirements; }
    public String getSusceptibilityToDiseases() { return susceptibilityToDiseases; }
    public String getWaterRequirements() { return waterRequirements; }
    public String getLightExposure() { return lightExposure; }

    public void setNutrientRequirements(String nutrientRequirements) {
        this.nutrientRequirements = nutrientRequirements;
    }


    public void setSusceptibilityToDiseases(String susceptibilityToDiseases) {
        this.susceptibilityToDiseases = susceptibilityToDiseases;
    }

    public void displayDetails() {
        System.out.println(name + " - Growth Stage: " + growthStage + ", Nutrients: " + nutrientRequirements + ", Water: " + waterRequirements + ", Light: " + lightExposure + ", Disease Risk: " + susceptibilityToDiseases);
    }
}
