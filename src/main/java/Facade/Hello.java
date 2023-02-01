package Facade;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Hello {

    public String sayHello(Object name) {
        if (name instanceof String[]) {
            String returnString = "Hello, ";
            String[] names = (String[]) name;
            returnString += names[0];
            for (int i = 1; i < names.length; i++) {
                if (names.length > 2) {
                    returnString += ",";
                }
                if (i == names.length - 1) {
                    returnString += " and " + names[i];
                } else {
                    returnString += " " + names[i];
                }
            }
            return returnString + ".";

        }
        if (name instanceof String) {
            String myString = (String) name;
            String allcaps = myString.toUpperCase();
            if (myString == null) return "Hello, my friend.";

            if (name.equals(allcaps)) return "HELLO, " + myString + "!";
            return "Hello, " + myString + ".";

        }
        return null;
    }
}
