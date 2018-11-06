import java.util.*;
import java.io.*;

public class Input {

    private Scanner in;
    private String filename;
    private String type;

    public Input(String filename) {
        try {
            in = new Scanner(new File("input/" + filename));
        } catch (Exception e) {
            System.out.println("Input file not found.");
        }
        this.filename = filename;
        type = in.next();
    }

    public String getType() {
        return type;
    }

    public void analysis(Analysis a) {
        if (type.equals("num")) { analysis_num(a); }
        else if (type.equals("strings")) { analysis_strings(a); }
    }

    private void analysis_strings(Analysis a) {

    }

    private void analysis_num(Analysis a) {
        while (in.hasNextLine()) {
            String s = in.nextLine();
            for (int k = 0; k < s.length(); k++) {
                String current = s.substring(k, k+1);
                String next;
                if (k == s.length() - 1) { next = "lb"; }
                else { next = s.substring(k+1, k+2); }
                a.add(current, next);
            }
        }
        in.close();
    }

}
