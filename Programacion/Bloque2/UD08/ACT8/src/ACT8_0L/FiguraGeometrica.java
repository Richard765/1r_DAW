package ACT8_0L;

/**
 *
 * @author winadmin
 */
// Classe Abstracta 
abstract class FiguraGeometrica {
    String color;  // Totes les figures tenen un color
    
    abstract double calculaArea();  // declarar, no implementar
    abstract double calculaPerimetre(); 
    abstract int calculaNCostats();
    
    // Constructor
    public FiguraGeometrica(String color) {
        this.color = color;
    }

    public void hasColor(String color) {
        this.color = color;
    }
    
    
    @Override
    public String toString() {
        String text="La figura és un ";
        if (this instanceof Cercle)
            text += "CERCLE"; 
        else if (this instanceof Quadrat)
            text += "QUADRAT"; 
        
        return text + ", color: " + color;
    }

    @Override
    public boolean equals(Object o) {
        FiguraGeometrica f = (FiguraGeometrica) o;
        
        return (f.color.equals(this.color));
    }
    
    

}

