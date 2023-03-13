package ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * A Class to handle user related interactions. e.g.printMessage,printBanner,getUserInput
 */
public class TextUi {
    public final Scanner in;
    private final PrintStream out;

    //@@damithc darrenangwx-reused
    //Source: https://github.com/nus-cs2113-AY2223S2/personbook/blob/main/src/main/java/seedu/personbook/ui/TextUi.java
    //Reused TextUi, shouldIgnoreEmpty, getUserInput methods with minor modifications.
    /**
     * Constructor to call the other constructor.
     */
    public TextUi() {
        this(System.in, System.out);
    }

    /**
     * Set the scanner and printstream of TextUi
     *
     * @param in  the Scanner of TextUi.
     * @param out the PrintStream of TextUi.
     */
    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * Checks what the user typed and ignore user inputs if they are empty, only spaces, or only line breaks.
     *
     * @param fullUserInput What the user typed in as inputs.
     * @return true if inputs are empty, only spaces, or only line breaks.
     */
    private boolean shouldIgnoreEmpty(String fullUserInput) {
        return fullUserInput.trim().isEmpty();
    }

    /**
     * Ask the user for an input.
     * It ignores whitespaces and line breaks.
     *
     * @return the command with the input the user typed.
     */
    public String getUserInput() {
        String fullUserInput = "";
        while (shouldIgnoreEmpty(fullUserInput)) {
            System.out.print(">");
            fullUserInput = in.nextLine();
        }

        return fullUserInput;
    }
    //@@damithc

    /**
     * Print the specified message to the user.
     *
     * @param message The specified message to be shown to the user.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    public static void printBanner() {
        String logo = "<insert logo here>";
        System.out.println("Hello from\n" + logo);
        System.out.println("Welcome to DinerDirector");
        System.out.println("What can I do for you?");
    }
}
