import java.util.*;
import java.io.*;

public class Analysis {

    private FileWriter out;

    public Analysis() {
        try {
            out = new FileWriter("data/default.txt");
        } catch (Exception e) {
            System.out.println("Exception when creating input.txt with FileWriter.");
        }
    }

    public Analysis(String filename) {
        try {
            out = new FileWriter("data/" + filename);
        } catch (Exception e) {
            System.out.println("Exception when creating input.txt with FileWriter.");
        }
    }

    public void add(String current, String next) {

    }

    public void add(int current, int next) {

    }

}
