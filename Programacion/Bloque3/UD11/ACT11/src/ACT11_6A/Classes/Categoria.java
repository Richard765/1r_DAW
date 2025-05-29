package ACT11_6A.Classes;

public enum Categoria {
    ALIMENTACIO, 
    ELECTRONICA, 
    ROBA;
    
    @Override
    public String toString() {
        return name();
    }
}
