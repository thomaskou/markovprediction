import java.util.*;
import java.io.*;

class Element {

    private String word;
    private int freq;

    Element(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    String getWord() {
        return word;
    }

    int getFreq() {
        return freq;
    }

    void increment() {
        freq++;
    }

}

class Frequencies {

    private Element word;
    private List<Element> list = new ArrayList<>();

    Frequencies(String element) {
        word = new Element(element, 1);
    }

    Frequencies(String line, boolean isLine) {
        String[] arr = line.split(" ");
        word = new Element(arr[0], Integer.valueOf(arr[1]));
        for (int k = 3; k < arr.length; k++) {
            addElement(arr[k], Integer.valueOf(arr[k+1]));
        }
    }

    String getWord() {
        return word.getWord();
    }

    void incrementSelf() { word.increment(); }

    boolean hasElement(String word) {
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getWord().equals(word)) return true;
        }
        return false;
    }

    void addElement(String word) {
        list.add(new Element(word, 1));
    }

    void addElement(String word, int freq) {
        list.add(new Element(word, freq));
    }

    void incrementElement(String word) {
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getWord().equals(word)) {
                list.get(k).increment();
                break;
            }
        }
    }

    int sumFreq() {
        int sum = 0;
        for (int k = 0; k < list.size(); k++) {
            sum += list.get(k).getFreq();
        }
        return sum;
    }

    int ownFreq() {
        return word.getFreq();
    }

    String getElementWord(int freq) {
        for (int k = 0; k < list.size(); k++) {
            freq -= list.get(k).getFreq();
            if (freq <= 0) {
                return list.get(k).getWord();
            }
        }
        return "lb";
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
    private String filename;
    private List<String> head = new ArrayList<>();
    private List<Frequencies> body = new ArrayList<>();

    public Analysis() {
        init("default.txt");
    }

    public Analysis(String filename) {
        init(filename);
    }

    private void init(String filename) {
        this.filename = "data/" + filename;
        try {
            in = new Scanner(new File(this.filename));
            head = Arrays.asList(in.next().split(" "));
            in.next();
            while (in.hasNext()) {
                body.add(new Frequencies(in.next(), true));
            }
            in.close();
        } catch (Exception e) {
            try {
                out = new FileWriter(this.filename);
                out.close();
                //in = new Scanner(new File(this.filename));
            } catch (Exception x) {}
        }
    }

    //////////////////////////////////////////////////

    public void add(String current, String next) {
        for (int k = 0; k < head.size(); k++) {
            if (head.get(k).equals(current)) {
                for (int i = 0; i < body.size(); i++) {
                    Frequencies currentFreq = body.get(i);
                    currentFreq.incrementSelf();
                    if (currentFreq.getWord().equals(current)) {
                        if (currentFreq.hasElement(next)) { currentFreq.incrementElement(next); }
                        else { currentFreq.addElement(next); }
                        return;
                    }
                }
                break;
            }
        }
        //System.out.println("New Frequencies: " + current);
        head.add(current);
        Frequencies newFreq = new Frequencies(current);
        newFreq.addElement(next);
        body.add(newFreq);
    }

    public void add(int current, int next) {
        add(Integer.toString(current), Integer.toString(next));
    }

    //////////////////////////////////////////////////

    public String getAny() {
        int sum = 0;
        for (int k = 0; k < body.size(); k++) {
            sum += body.get(k).ownFreq();
        }
        int random = (int)(Math.random() * sum) + 1;
        for (int k = 0; k < body.size(); k++) {
            random -= body.get(k).ownFreq();
            if (random <= 0) return body.get(k).getWord();
        }
        return "lb";
    }

    public String getNext(String current) {
        for (int k = 0; k < body.size(); k++) {
            if (body.get(k).getWord().equals(current)) {
                int total = body.get(k).sumFreq();
                int random = (int)(Math.random() * total) + 1;
                return body.get(k).getElementWord(random);
            }
        }
        return getAny();
    }

    //////////////////////////////////////////////////

    public void saveOutput() {
        File f = new File(filename);
        if (f.exists()) { f.delete(); }
        try {
            out = new FileWriter(filename);
            String s = "";
            for (int k = 0; k < head.size(); k++) {
                s += head.get(k);
                if (k != head.size() - 1) { s += " "; }
            }
            out.write(s);
            out.write(System.getProperty("line.separator"));
            out.write(System.getProperty("line.separator"));
            for (int k = 0; k < body.size(); k++) {
                out.write(body.get(k).toString());
                if (k != body.size() - 1) { out.write(System.getProperty("line.separator")); }
            }
            out.close();
        } catch (Exception e) {
            System.out.println("Creation of FileWriter failed.");
        }
    }

    public void printOutput() {
        String s = "";
        for (int k = 0; k < head.size(); k++) {
            s += head.get(k);
            if (k != head.size() - 1) { s += " "; }
        }
        System.out.println(s);
        System.out.println();
        for (int k = 0; k < body.size(); k++) {
            System.out.println(body.get(k).toString());
        }
    }

}
