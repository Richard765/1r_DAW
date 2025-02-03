package ACT7_1C;

class Editor extends SkilledEmployee {
    boolean prefersPaperEditing;

    public Editor(String name, String jobTitle, String level, boolean prefersPaperEditing) {
        super(name, jobTitle, level);
        this.prefersPaperEditing = prefersPaperEditing;
    }

    @Override
    public String toString() {
        return "Editor{" + super.toString() + "Prefer Paper Editing=" + this.prefersPaperEditing + "}";
    }
    
}