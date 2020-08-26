package Tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void setDone(){
        this.isDone = true;
    }

    public void setNotDone(){
        this.isDone = false;
    }

    public String getDescription(){
        return this.description;
    }
    public String toString(){
        return "["+getStatusIcon()+"]"+" "+getDescription();
    }
}