import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Math.max;

public class Main {

    public static void main(String[] args) {
        System.out.println(textModifier());
    }

    public static String textModifier() {
        Scanner in = new Scanner(System.in);

        String baseString = in.nextLine();
        String transformedString = "";
        for (char currentChar:(baseString.toCharArray())) {
            if (currentChar == ' ')
                if (transformedString.endsWith(" "))
                    continue;
            transformedString = transformedString.concat(String.valueOf(currentChar));
        }

        baseString = transformedString;
        transformedString = "";
        for (int stringPointer = 0; stringPointer < baseString.length(); stringPointer++) {
            if (baseString.charAt(stringPointer) != '-')
                transformedString = transformedString.concat(String.valueOf(baseString.charAt(stringPointer)));
            else {
                transformedString = transformedString.substring(0, transformedString.length() - 1).concat(
                        String.valueOf(baseString.charAt(stringPointer + 1))
                ).concat(
                        String.valueOf(transformedString.charAt(transformedString.length() - 1))
                );
                stringPointer++;
            }
        }

        baseString = transformedString;
        transformedString = "";
        for (char currentChar:(baseString.toCharArray())) {
            if (currentChar == '+')
                transformedString = transformedString.concat("!");
            else
                transformedString = transformedString.concat(String.valueOf(currentChar));
        }

        int sum = -1;
        baseString = transformedString;
        transformedString = "";
        for (char currentChar:(baseString.toCharArray())) {
            if (isDigit(currentChar))
                sum = max(sum, 0) + (currentChar - '0');
            else
                transformedString = transformedString.concat(String.valueOf(currentChar));
        }
        if (sum != -1)
            transformedString = transformedString + " " + sum;

        return transformedString;
    }

}