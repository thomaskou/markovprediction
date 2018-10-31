import java.util.*;
import java.io.*;

class Element {

    public String element;
    public int freq;

    public Element(String element, int freq) {
        this.element = element;
        this.freq = freq;
    }

}

public class Analysis {

    private Scanner in;
    private FileWriter out;
    private List<String> head = new ArrayList<>();
    private List<String> body = new ArrayList<>();

    public Analysis() {
        init("default.txt");
    }

    public Analysis(String filename) {
        init(filename);
    }

    private void init(String filename) {
        try {
            in = new Scanner(new File("data/" + filename));
            head = Arrays.asList(in.next().split(" "));
            in.next();
            while (in.hasNext()) {
                body.add(in.next());
            }
        } catch (Exception e) {
            try {
                out = new FileWriter("data/" + filename);
                in = new Scanner(new File("data/" + filename));
            } catch (Exception x) {}
        }
    }

    public void add(String current, String next) {

    }

    public void add(int current, int next) {
        int index;
        if (head.contains(String.valueOf(current))) {
            index = head.indexOf(String.valueOf(current));
        } else {
            head.add(Integer.toString(current));
            index = head.size() - 1;
        }

    }

}
