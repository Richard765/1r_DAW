package act7_1C;

/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager("Barbara Johnson", "Manager", "1");
        TechnicalWriter tWriter = new TechnicalWriter("Bill Monroe", "Writer", "2");
        GraphicIllustrator gIllustrator = new GraphicIllustrator("Jane Smith", "Illustrator", "2");
        manager.addEmployee(tWriter);
        manager.addEmployee(gIllustrator);
        
        tWriter.addSkill("Skill1");
        tWriter.addSkill("Skill2");
        tWriter.addSkill("Skill2");
        
        gIllustrator.addSkill("Skill1");
        gIllustrator.addSkill("Skill2");
        
        System.out.println(manager.toString());

    }
    
}