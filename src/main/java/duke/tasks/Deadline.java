package duke.tasks;

public class Deadline extends Todo {
    protected String by;
    public Deadline(String description, String by){
        super(description);
        this.by=by;
    }
    public String toString(){
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}