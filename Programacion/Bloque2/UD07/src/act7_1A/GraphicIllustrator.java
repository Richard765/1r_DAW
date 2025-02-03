package ACT7_1C;

class GraphicIllustrator extends SkilledEmployee {

    public GraphicIllustrator(String name, String jobTitle, String level) {
        super(name, jobTitle, level);
    }

    @Override
    public String toString() {
        return "GraphicIllustrator{" + super.toString() + "}";
    }

}