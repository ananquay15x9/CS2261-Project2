public class FertilizationDecisionMaker implements DecisionMaker{
    @Override
    public void makeIrrigationDecision(double moistureLevel, String weatherCondition) {
        //method stub
    }

    @Override
    public void makeFertilizationDecision(String cropType) {
        if (cropType.equals("Wheat")) {
            System.out.println("Fertilization needed for wheat.");
        } else {
            System.out.println("No fertilization needed for the specified crop type.");
        }
    }

    @Override
    public void makePestControlDecision(String cropType) {
        //method stub
    }
}
