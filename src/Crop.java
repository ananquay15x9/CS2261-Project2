import javax.swing.*;

public abstract class Crop {
    private String name;
    private String growthStage;
    private String nutrientRequirements;
    private String susceptibilityToDiseases;


    public Crop(String name, String growthStage, String nutrientRequirements, String susceptibilityToDiseases)  {
        this.name = name;
        this.growthStage = growthStage;
        this.nutrientRequirements = nutrientRequirements;
        this.susceptibilityToDiseases = susceptibilityToDiseases;
    }

    public abstract void produce();


    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(String growthStage) {
        this.growthStage = growthStage;
    }

    public String getNutrientRequirements() {
        return nutrientRequirements;
    }

    public void setNutrientRequirements(String nutrientRequirements) {
        this.nutrientRequirements = nutrientRequirements;
    }

    public String getSusceptibilityToDiseases() {
        return susceptibilityToDiseases;
    }

    public void setSusceptibilityToDiseases(String susceptibilityToDiseases) {
        this.susceptibilityToDiseases = susceptibilityToDiseases;
    }
}
