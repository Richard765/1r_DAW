package ACT7_1C;

import java.util.ArrayList;

class TechnicalWriter extends SkilledEmployee {

    public TechnicalWriter(String name, String jobTitle, String level) {
        super(name, jobTitle, level);
    }

    @Override
    public String toString() {
        return "TechnicalWriter{" + super.toString() + "}";
    }
    
}