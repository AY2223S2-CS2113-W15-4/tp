package utils;


import commands.staff.AddStaffCommand;
import commands.staff.ViewStaffCommand;
import commands.staff.DeleteStaffCommand;
import commands.HelpCommand;
import commands.ExitCommand;
import commands.deadline.AddDeadlineCommand;
import commands.deadline.ViewDeadlineCommand;
import commands.deadline.DeleteDeadlineCommand;
import commands.menu.AddDishCommand;
import commands.menu.DeleteDishCommand;
import commands.menu.ViewDishCommand;
import commands.IncorrectCommand;
import commands.meeting.AddMeetingCommand;
import commands.meeting.DeleteMeetingCommand;
import commands.meeting.ViewMeetingCommand;
import commands.Command;

import common.Messages;
import exceptions.DinerDirectorException;
import entity.Deadline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static manager.DishManager.getDishesSize;

/**
 * Parser to tokenize the input
 */
public class Parser {


    public Command parseCommand(String userInput) {
        assert userInput != null : "userInput should not be null";
        String[] userInputSplit = userInput.split(" ");
        String commandWord = userInputSplit[0];
        String userInputNoCommand = userInput.replace(userInputSplit[0], "");
        //@@damithc darrenangwx-reused
        //Source:
        //https://github.com/nus-cs2113-AY2223S2/personbook/blob/main/src/main/java/seedu/personbook/parser/Parser.java
        //Reused the switch skeleton
        switch (commandWord) {
        case HelpCommand.COMMAND_WORD:
            return prepareHelpCommand();
        case ExitCommand.COMMAND_WORD:
            return prepareExitCommand();
        case AddMeetingCommand.COMMAND_WORD:
            return prepareAddMeetingCommand(userInputNoCommand);
        case DeleteMeetingCommand.COMMAND_WORD:
            return prepareDeleteMeetingCommand(userInputNoCommand);
        case ViewMeetingCommand.COMMAND_WORD:
            return prepareViewMeetingCommand(commandWord);
        case AddStaffCommand.COMMAND_WORD:
            return prepareAddStaffCommand(userInputNoCommand);
        case DeleteStaffCommand.COMMAND_WORD:
            return prepareDeleteStaffCommand(userInputNoCommand);
        case ViewStaffCommand.COMMAND_WORD:
            return prepareViewStaffCommand();
        case AddDeadlineCommand.COMMAND_WORD:
            return prepareAddDeadlineCommand(userInputNoCommand);
        case DeleteDeadlineCommand.COMMAND_WORD:
            return prepareDeleteDeadlineCommand(userInputNoCommand);
        case ViewDeadlineCommand.COMMAND_WORD:
            return prepareViewDeadlineCommand(userInputNoCommand);
        case AddDishCommand.COMMAND_WORD:
            return prepareAddDishCommand(userInputNoCommand);
        case DeleteDishCommand.COMMAND_WORD:
            return prepareDeleteDishCommand(userInputNoCommand);
        case ViewDishCommand.COMMAND_WORD:
            return prepareViewDishCommand(userInputNoCommand);
        default:
            return new IncorrectCommand();
        }
        //@@damithc
    }

    //Solution below adapted from https://github.com/Stella1585/ip/blob/master/src/main/java/duke/Parser.java
    private Command prepareAddMeetingCommand(String description) {
        String[] words = (description.trim()).split("t/");
        String[] testName = (description.trim()).split("n/");
        try {
            if (((description.trim()).isEmpty()) || (!description.contains("n/")) || (words.length < 2)) {
                throw new DinerDirectorException(Messages.ERROR_MEETING_MISSING_PARAM);
            } else if ((testName.length > 2) || (words.length > 2)) {
                throw new DinerDirectorException(Messages.ERROR_MEETING_EXCESS_ADD_PARAM);
            }
        } catch (DinerDirectorException e) {
            System.out.println(e);
            return new IncorrectCommand();
        }
        String issue = (words[0].substring(2)).trim();
        String time = words[1].trim();
        return new AddMeetingCommand(time, issue);
    }

    private Command prepareViewMeetingCommand(String userInput) {
        try {
            if (!userInput.trim().equals("view_meetings")) {
                throw new DinerDirectorException(Messages.ERROR_MEETING_EXCESS_VIEW_PARAM);
            }
        } catch (DinerDirectorException e) {
            System.out.println(e);
            return new IncorrectCommand();
        }
        return new ViewMeetingCommand();
    }

    private Command prepareDeleteMeetingCommand(String description) {
        int index;
        try {
            index = Integer.parseInt((description.trim())) - 1;
            if ((description.trim()).isEmpty()) {
                throw new DinerDirectorException(Messages.ERROR_MEETING_MISSING_INDEX);
            }
        } catch (DinerDirectorException e) {
            System.out.println(e);
            return new IncorrectCommand();
        }catch (NumberFormatException e) {
            System.out.println(Messages.ERROR_MEETING_MISSING_INDEX);
            return new IncorrectCommand();
        }
        assert index >= 0 : "Index of meeting should be 0 or greater.";
        return new DeleteMeetingCommand(index);
    }

    private Command prepareAddStaffCommand(String userInputNoCommand) {
        String[] userInputNoCommandSplitBySlash = userInputNoCommand.trim().split("/");
        try {
            if (userInputNoCommandSplitBySlash.length < 5 || userInputNoCommand.trim().isEmpty()
                    || !userInputNoCommand.contains("n/") || !userInputNoCommand.contains("w/")
                    || !userInputNoCommand.contains("d/") || !userInputNoCommand.contains("p/")) {
                throw new DinerDirectorException(Messages.ERROR_STAFF_ADD_MISSING_PARAM);
            } else if (userInputNoCommandSplitBySlash.length > 5) {
                throw new DinerDirectorException(Messages.ERROR_STAFF_ADD_EXCESS_PARAM);
            }
            String pattern = "n/(?<name>[\\w\\s]+)\\sw/(?<workingDay>[\\w\\s]+)" +
                    "\\sd/(?<dateOfBirth>[\\w\\s\\-]+)\\sp/(?<phoneNumber>[\\w\\s]+)";

            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(userInputNoCommand);
            String staffName = "";
            String staffWorkingDay = "";
            String staffPhoneNumber = "";
            String staffDateOfBirth = "";
            if (matcher.find()) {
                staffName = matcher.group("name");
                staffWorkingDay = matcher.group("workingDay");
                staffPhoneNumber = matcher.group("phoneNumber");
                staffDateOfBirth = matcher.group("dateOfBirth");
            }

            return new AddStaffCommand(staffName, staffWorkingDay, staffDateOfBirth, staffPhoneNumber);
        } catch (DinerDirectorException e) {
            System.out.println(e.getMessage());
            return new IncorrectCommand();
        }
    }

    private Command prepareViewStaffCommand() {
        return new ViewStaffCommand();
    }

    private Command prepareDeleteStaffCommand(String userInputNoCommand) {
        String[] userInputNoCommandSplitBySlash = userInputNoCommand.split("/");
        try {
            if (userInputNoCommandSplitBySlash.length < 2 || !userInputNoCommand.contains("n/")) {
                throw new DinerDirectorException(Messages.ERROR_STAFF_DELETE_MISSING_PARAM);
            } else if (userInputNoCommandSplitBySlash.length > 2) {
                throw new DinerDirectorException(Messages.ERROR_STAFF_DELETE_EXCESS_PARAM);
            }
            String staffName = userInputNoCommandSplitBySlash[1];
            return new DeleteStaffCommand(staffName);
        } catch (DinerDirectorException e) {
            System.out.println(e.getMessage());
            return new IncorrectCommand();
        }
    }

    private Command prepareHelpCommand() {
        return new HelpCommand();
    }

    private Command prepareExitCommand() {
        return new ExitCommand();
    }

    //Solution below adapted from https://github.com/Stella1585/ip/blob/master/src/main/java/duke/Parser.java

    /**
     * Creates a deadline item based on descriptions given by the user, then returns
     * an add deadline command.
     *
     * @param description contains the deadline description and due date.
     * @return the add deadline command.
     */
    private Command prepareAddDeadlineCommand(String description) { //  n/ t/
        String[] words = (description.trim()).split("t/"); // n/
        try {
            String[] testName = (words[0].trim()).split("n/");  // n/
            if (((description.trim()).isEmpty()) || (!description.contains("n/"))
                    || (words.length < 2) || (testName.length < 1)) {
                throw new DinerDirectorException(Messages.ERROR_DEADLINE_MISSING_PARAM);
            } else if ((testName.length > 2) || (words.length > 2)) {
                throw new DinerDirectorException(Messages.ERROR_DEADLINE_EXCESS_PARAM);
            }
        } catch (DinerDirectorException e) {
            System.out.println(e);
            return new IncorrectCommand();
        }
        String name = (words[0].substring(2)).trim();
        String dueDate = words[1].trim();
        assert !name.isEmpty() : "name should be present";
        assert !dueDate.isEmpty() : "dueDate should be present";
        Deadline deadline = new Deadline(name, dueDate);
        return new AddDeadlineCommand(deadline);
    }

    /**
     * Checks for error in the view deadline command, then returns a view deadline command.
     *
     * @param userInput view deadline command
     * @return the view deadline command.
     */
    private Command prepareViewDeadlineCommand(String userInput) {
        try {
            if (!(userInput.trim()).isEmpty()) {
                throw new DinerDirectorException(Messages.ERROR_DEADLINE_EXCESS_LIST_PARAM);
            }
        } catch (DinerDirectorException e) {
            System.out.println(e);
            return new IncorrectCommand();
        }
        assert (userInput.trim()).isEmpty() : Messages.ERROR_DEADLINE_EXCESS_LIST_PARAM;
        return new ViewDeadlineCommand();
    }


    /**
     * Checks for error in the delete deadline command, then returns
     * a delete deadline command.
     *
     * @param description contains the index number.
     * @return the delete deadline command.
     */
    private Command prepareDeleteDeadlineCommand(String description) {
        int index;
        try {
            index = Integer.parseInt((description.trim())) - 1;
            if (description.isEmpty()) {
                throw new DinerDirectorException(Messages.ERROR_DEADLINE_MISSING_INDEX);
            }
        } catch (NumberFormatException e) {
            System.out.println(Messages.ERROR_DEADLINE_MISSING_INDEX);
            return new IncorrectCommand();
        } catch (DinerDirectorException e) {
            System.out.println(e);
            return new IncorrectCommand();
        }
        assert index >= 0 : "indexToRemove should be 0 or greater.";
        return new DeleteDeadlineCommand(index);
    }

    private Command prepareDeleteDishCommand(String userInputNoCommand) {
        int indexToRemove = 0;

        try {
            indexToRemove = Integer.parseInt(userInputNoCommand.trim()) - 1;
            if (indexToRemove < 0 || indexToRemove >= getDishesSize()) {
                throw new DinerDirectorException(Messages.ERROR_DISH_INVALID_INDEX);
            }
            assert indexToRemove >= 0 : "indexToRemove should be 0 or greater";
        } catch (NumberFormatException e) {
            System.out.println(Messages.ERROR_DISH_NOT_A_VALID_INTEGER);
            return new IncorrectCommand();
        } catch (DinerDirectorException e) {
            System.out.println(e.getMessage());
            return new IncorrectCommand();
        }
        return new DeleteDishCommand(indexToRemove);
    }

    private Command prepareViewDishCommand(String userInputNoCommand) {
        try {
            if (!userInputNoCommand.isBlank()) {
                throw new DinerDirectorException(Messages.ERROR_COMMAND_INVALID);
            }
        } catch (DinerDirectorException e) {
            return new IncorrectCommand();
        }
        return new ViewDishCommand();
    }

    private Command prepareAddDishCommand(String userInputNoCommand) {
        //MENU COMMANDS: add_dish n/<name>
        //                      pc/<price in cents>
        //                      [<ingredient 1>;<ingredients 2>;<ingredient 3>; ... ]

        String name = "";
        int price = 0;
        ArrayList<String> ingredients = new ArrayList<>();

        String regex = " n/(?=\\S)(.*?) pc/(\\d+) \\[(.*?)\\]";

        Pattern dishPattern = Pattern.compile(regex);
        Matcher parsedDishInput = dishPattern.matcher(userInputNoCommand);

        try {
            if (parsedDishInput.matches()) {
                name = parsedDishInput.group(1);
                price = Integer.parseInt(parsedDishInput.group(2));
                String[] ingredientList = parsedDishInput.group(3).split(";");
                Collections.addAll(ingredients, ingredientList);
            } else {
                throw new DinerDirectorException(Messages.ERROR_COMMAND_INVALID);
            }
        } catch (DinerDirectorException e) {
            return new IncorrectCommand();
        }
        return new AddDishCommand(name, price, ingredients);
    }
}
