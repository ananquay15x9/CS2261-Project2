public class PestControlDecisionMaker implements DecisionMaker{
    @Override
    public void makeIrrigationDecision(double moistureLevel, String weatherCondition) {
        //method stub
    }

    @Override
    public void makeFertilizationDecision(String cropType) {
        //method stub
    }

    @Override
    public void makePestControlDecision(String cropType) {
        if (cropType.equals("Corn")) {
            System.out.println("Pest control needed for corn.");
        } else {
            System.out.println("No pest control needed for the specified crop type.");
        }
    }
}
