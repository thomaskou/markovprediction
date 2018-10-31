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

}
