package utilities;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String REGEX_FOR_COORDINATES = "[a-zA-Z]\\d+";

    public static int askUserForColonySize() {

        boolean invalidInput = true;
        int colonySize = 0;
        while (invalidInput) {
            System.out.println("Please select the colony size: ");
            colonySize = scanner.nextInt();
            if(isPatternMatch("^[0-9]{1}$|^[1][0-9]$|^[2][0]$",Integer.toString(colonySize))){
                invalidInput = false;
            }else{
                System.out.println("Wrong input please try again");
            }
        }
        return colonySize;
    }


    private static boolean isPatternMatch(String regEx, String answer) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(answer);
        return matcher.matches();
    }

}
