public class CompostingUnit extends WasteManagement{
    @Override
    public void manageWaste(String wasteType) {
        System.out.println("Waste management for " + wasteType + " in composting unit...");
    }
}
