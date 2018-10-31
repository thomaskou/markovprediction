package testing;

import java.io.*;

public class GenerateDigits {

    private FileWriter out;

    public GenerateDigits() {
        try {
            out = new FileWriter("input/input.txt");
        } catch (Exception e) {
            System.out.println("Exception when creating input.txt with FileWriter.");
        }
    }

}
