public class IrrigationDecisionMaker implements DecisionMaker{
    @Override
    public void makeIrrigationDecision(double moistureLevel, String weatherCondition) {
        if (moistureLevel < 30.0 && !weatherCondition.equals("Rainy")) {
            System.out.println("Irrigation is needed due to low moisture level and non-rainy weather.");
        } else {
            System.out.println("No irrigation needed at the moment.");
        }
    }

    @Override
    public void makeFertilizationDecision(String cropType) {
        //method stub
    }

    @Override
    public void makePestControlDecision(String cropType) {
        //method stub
    }
}
