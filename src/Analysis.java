import java.util.*;
import java.io.*;

class Element {

    private String word;
    private int freq;

    public Element(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    public String getWord() {
        return word;
    }

    public int getFreq() {
        return freq;
    }

    public void increment() {
        freq++;
    }

}

class Frequencies {

    private Element word;
    private List<Element> list = new ArrayList<>();

    public Frequencies(String element) {
        word = new Element(element, 1);
    }

    public Frequencies(String line, boolean isLine) {
        String[] arr = line.split(" ");
        word = new Element(arr[0], Integer.valueOf(arr[1]));
        for (int k = 3; k < arr.length; k++) {
            addElement(arr[k], Integer.valueOf(arr[k+1]));
        }
    }

    public String getWord() {
        return word.getWord();
    }

    public boolean hasElement(String word) {
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getWord().equals(word)) return true;
        }
        return false;
    }

    public void addElement(String word) {
        list.add(new Element(word, 1));
    }

    public void addElement(String word, int freq) {
        list.add(new Element(word, freq));
    }

    public void incrementElement(String word) {
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getWord().equals(word)) {
                list.get(k).increment();
                break;
            }
        }
    }

    public String toString() {
        String s = word.getWord() + " " + word.getFreq() + " : ";
        for (int k = 0; k < list.size(); k++) {
            s += list.get(k).getWord() + " " + list.get(k).getFreq() + " ";
        }
        return s;
    }

}

public class Analysis {

    private Scanner in;
    private FileWriter out;
    private List<String> head = new ArrayList<>();
    private List<Frequencies> body = new ArrayList<>();

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
                body.add(new Frequencies(in.next(), true));
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
    }

}
