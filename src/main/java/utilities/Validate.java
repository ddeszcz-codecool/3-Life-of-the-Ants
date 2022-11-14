package utilities;

import java.util.regex.Pattern;

public class Validate {



    public static boolean patternCheck(String Regex, String checkedString){
        Pattern name = Pattern.compile(Regex);
        return name.matcher(checkedString).matches();
    }

    public static boolean colonySize (String Regex, String checkedString){
        return patternCheck(Regex, checkedString);
    }


}
