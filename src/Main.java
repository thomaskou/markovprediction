public class Main {

    public static void main(String[] args) {
        Input in = new Input("numbers.txt");
        Analysis a = new Analysis();
        in.analysis(a);
        a.output();
    }

}