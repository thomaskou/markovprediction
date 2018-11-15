import java.util.*;
import java.io.*;

public class Output {

    private String filename;
    private Analysis a;
    private FileWriter out;

    public Output() {
        a = new Analysis("default.txt");
        init("default.txt");
    }

    public Output(String data_path) {
        a = new Analysis(data_path);
        init("default.txt");
    }

    public Output(String output_path, String data_path) {
        a = new Analysis(data_path);
        init(output_path);
    }

    public Output(Analysis a) {
        this.a = a;
        init("default.txt");
    }

    public Output(String output_path, Analysis a) {
        this.a = a;
        init(output_path);
    }

    private void init(String output_path) {
        filename = "output/" + output_path;
    }

    //////////////////////////////////////////////////

    public void write_test() {
        try {
            out = new FileWriter(filename);
            out.write("Hello world!");
            out.close();
            System.out.println("Hello world!");
        } catch (Exception e) {
            System.out.println("Lol your test failed.");
        }
    }

    public void write_strings_fixed(int length) {
        List<String> words = new ArrayList<>();
        String current = a.getNext("lb");
        words.add(current);
        for (int k = 1; k < length; k++) {
            current = a.getNext(current);
            words.add(current);
        }
        try {
            out = new FileWriter(filename);
            for (int k = 0; k < words.size(); k++) {
                if (words.get(k).equals("lb")) { out.write(System.getProperty("line.separator")); }
                else { out.write(words.get(k) + " "); }
            }
            out.write(System.getProperty("line.separator"));
            out.close();
        } catch (Exception e) {
            System.out.println("Exception when writing output line.");
        }
    }

    public void write_digits_fixed(int length) {
        List<String> chars = new ArrayList<>();
        String current = a.getNext("lb");
        chars.add(current);
        for (int k = 1; k < length; k++) {
            current = a.getNext(current);
            chars.add(current);
        }
        try {
            out = new FileWriter(filename);
            for (int k = 0; k < chars.size(); k++) {
                if (chars.get(k).equals("lb")) { out.write(System.getProperty("line.separator")); }
                else { out.write(chars.get(k)); }
            }
            out.write(System.getProperty("line.separator"));
            out.close();
        } catch (Exception e) {
            System.out.println("Exception when writing output line.");
        }
    }

}
