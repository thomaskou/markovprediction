public class Main {

    public static void main(String[] args) {
        Input in = new Input("test_ones.txt");
        Analysis a = new Analysis("test_ones.txt");
        in.analysis(a);
        //a.printOutput();
        a.saveOutput();
        Output o = new Output("test_ones.txt", a);
        //o.write_test();
        o.write_fixed(200);
    }

}