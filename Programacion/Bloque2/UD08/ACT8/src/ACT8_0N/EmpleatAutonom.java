package ACT8_0N;

/** Subclasse d'empleat: Treballa per hores
 *
 * @author winadmin
 */
class EmpleatAutonom extends Empleat {
    private int horesTreballades;

    // Constructor
    public EmpleatAutonom(String nom, String llinatge1, double souPerHores, int horesTreballades) {
        super(nom, llinatge1, souPerHores);
        this.horesTreballades = horesTreballades;
    }

    public int getHoresTreballades() {
        return horesTreballades;
    }
    
    @Override
    public double calculaSalari() {
        // El salari per a empleats autònoms depen de les hores traballades
        return super.getSouBase() * this.getHoresTreballades();
    }
}

