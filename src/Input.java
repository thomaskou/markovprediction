import java.util.*;
import java.io.*;

public class Input {

    private Scanner in;
    private String type;

    List<Integer> ints = new ArrayList<>();

    public Input(String filename) {
        try {
            in = new Scanner(new File("input/" + filename));
        } catch (Exception e) {
            System.out.println("File not found.");
        }
        type = in.next();
        //System.out.println(type);
    }



    public String getType() {
        return type;
    }

}
