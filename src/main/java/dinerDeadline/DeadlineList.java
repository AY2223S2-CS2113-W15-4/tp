package dinerDeadline;

import exceptions.DinerDirectorException;
import ui.TextUi;

import java.util.ArrayList;

import common.Messages;

public class DeadlineList {
    //Solution below adapted from https://github.com/Stella1585/ip/blob/master/src/main/java/duke/TaskList.java
    public static ArrayList<Deadline> deadlines = new ArrayList<>();

    /**
     * Creates DeadlineList with input list.
     * @param deadlines list of deadlines.
     */
    public DeadlineList(ArrayList<Deadline> deadlines) {
        DeadlineList.deadlines = deadlines;
    }

    /**
     * Adds a deadline item to the deadline list.
     * @param deadline the deadline item to be added.
     * @param ui manages user output.
     */
    public void addDeadline(Deadline deadline, TextUi ui) {
        deadlines.add(deadline);
        //Solution below adapted from https://github.com/darrenangwx/ip/blob/6d3f1bc5f1a281f9459a67650b043705d3096a8f/src/main/java/task/TaskParser.java
        ui.printMessage(Messages.MESSAGE_DEADLINE_ADDED +
                deadlines.get(deadlines.size()-1).toString() +
                        String.format(Messages.MESSAGE_NUMBER_OF_DEADLINES, deadlines.size()));
    }

    /**
     * Print the task list.
     * @param ui manages user output.
     */
    public void printDeadlines(TextUi ui) {
        try {
            if (deadlines.isEmpty()) {
                throw new DinerDirectorException(Messages.MESSAGE_EMPTY_LIST);
            }
            System.out.println(Messages.MESSAGE_VIEW_LIST);
            for (int i = 1; i <= deadlines.size(); i++) {
                ui.printMessage(i + ". " + deadlines.get(i - 1).toString());
            }
        } catch (DinerDirectorException e){
            System.out.println(e);
        }
    }

    /**
     * Deletes a task from the task list.
     * @param index index of deadline to be deleted.
     * @param ui manages user output.
     */
    public void deleteDeadline(int index, TextUi ui) {
        try {
            ui.printMessage(Messages.MESSAGE_DEADLINE_REMOVED + deadlines.get(index).toString());
            deadlines.remove(index);
            ui.printMessage(String.format(Messages.MESSAGE_NUMBER_OF_DEADLINES, deadlines.size()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(Messages.MESSAGE_INVALID_INDEX);
        }
    }
}
