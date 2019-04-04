package chap9;
import stone.ArrayParser;
import stone.ParseException;
import chap6.BasicInterpreter;
import chap7.NestedEnv;
import chap8.Natives;

public class ArrayInterpreter extends BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new ArrayParser(), new Natives().environment(new NestedEnv()));
    }
}