package ua.nure.antoniuk.Practice6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Util{
    public static String getInput(String fileName, String charset) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(new File(fileName), charset);
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
