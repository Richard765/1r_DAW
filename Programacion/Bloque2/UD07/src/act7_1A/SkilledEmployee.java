package ACT7_1C;

import java.util.ArrayList;

class SkilledEmployee extends Employee {
    private ArrayList<String> skillList;

    public SkilledEmployee(String name, String jobTitle, String level) {
        super(name,jobTitle, level);
        this.skillList = new ArrayList<>();
    }
        
    public ArrayList getSkills() {
        return this.skillList;
    }
    
    public boolean addSkill(String s) {  // setSkill()
        if (this.skillList.contains(s))
            return false;
        else {
            this.skillList.add(s);
            return true;
        }
    }
    
    public boolean removeSkill(String s) {  
        return this.skillList.remove(s);
    }
    
    @Override
    public String toString() {
        String text = "Manager {" + super.toString() + ", Skill List=";
        for (String s : this.skillList)
            text = text + "\n\t\t" + s;
        return text + "}";
    }
    
}