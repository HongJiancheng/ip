package duke;

public class Parser {
    public void getCommand (String input,Storage store, Ui ui) throws DukeException{
        ui.printLine();
        String command, others;
        if(input.contains(" ")){
            command = input.split(" ",2)[0];
            others = input.split(" ",2)[1];
        }else{
            command = input;
            others = "";
        }
        switch (command) {
            case "bye":
                store.toExit();
                ui.byeToUser();
                break;
            case "list":
                ui.indentPrint("Here are the tasks in your list:");
                for(int i=0;i<store.getSize();i++){
                    ui.indentPrint((i+1)+". "+store.getTask(i).toString());
                }
                break;
            case "done":
                if(others.isEmpty()){
                    throw new DukeException("The index of a done command cannot be empty.");
                }
                int index = Integer.parseInt(others);
                store.setDoneAt(index-1);
                ui.indentPrint("Nice! I've marked this task as done: ");
                ui.indentPrint("  "+store.getTask(index-1).toString());
                break;
            case "todo":
                if(others.isEmpty()){
                    throw new DukeException("The description of a todo cannot be empty.");
                }
                store.addToDoToTemp(others);
                ui.indentPrint("Got it. I've added this task: ");
                ui.indentPrint("  "+store.getTask(store.getSize()-1).toString());
                ui.indentPrint( "Now you have "+store.getSize()+" tasks in the list.");
                break;
            case "deadline":
                if(others.isEmpty()){
                    throw new DukeException("The description of a deadline cannot be empty.");
                }
                store.addDeadlineToTemp(others);
                ui.indentPrint("Got it. I've added this task: ");
                ui.indentPrint("  "+store.getTask(store.getSize()-1).toString());
                ui.indentPrint( "Now you have "+store.getSize()+" tasks in the list.");
                break;
            case "event":
                if(others.isEmpty()){
                    throw new DukeException("The description of a event cannot be empty.");
                }
                store.addEventToTemp(others);
                ui.indentPrint("Got it. I've added this task: ");
                ui.indentPrint("  "+store.getTask(store.getSize()-1).toString());
                ui.indentPrint( "Now you have "+store.getSize()+" tasks in the list.");
                break;
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
}