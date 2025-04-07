package ACT10_0G;

public enum DiaSetmana {
    DILLUNS("DL","Laborable"), 
    DIMARTS("DM","Laborable"), 
    DIMECRES("DX","Meitat de setmana"),
    DIJOUS("DJ","Laborable"),
    DIVENDRES("DV","Laborable"), 
    DISSABTE("DS","Festiu"), 
    DIUMENGE("DG","Festiu");

    private final String abreviacio;
    private final String activitat;

    DiaSetmana(String abreviacio, String activitat) {
        this.abreviacio = abreviacio;
        this.activitat = activitat;
    }
    
    public String getAbreviacio() {
        return abreviacio;
    }

    public String getActivitat() {
        return activitat;
    }
}