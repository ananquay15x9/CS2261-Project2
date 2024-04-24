public class FarmDecisionMaker implements DecisionMaker{
    @Override
    public void makeIrrigationDecision(double moistureLevel, String weatherCondition) {
        System.out.println("Making irrigation decision based on moisture level and weather condition....");
    }

    @Override
    public void makeFertilizationDecision(String cropType) {
        System.out.println("Making fertilization decision for crop : " + cropType);
    }

    @Override
    public void makePestControlDecision(String cropType) {
        System.out.println("Making pest control decision for crop: " + cropType);
    }
}
