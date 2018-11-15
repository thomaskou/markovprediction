public class Main {

    public static void main(String[] args) {
        Input in = new Input("ok_computer.txt");
        Analysis a = new Analysis("ok_computer.txt");
        in.analysis(a);
        a.saveOutput();
        Output o = new Output("ok_computer.txt", a);
        o.write_strings_fixed(200);
        //o.write_digits_fixed(200);
    }

}