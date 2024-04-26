public interface DecisionMaker {
    void makeIrrigationDecision(double moistureLevel, String weatherCondition);
    void makeFertilizationDecision(String cropType);
    void makePestControlDecision(String cropType);


}
