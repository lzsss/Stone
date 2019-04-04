package chap8;
import java.lang.reflect.Method;
import stone.StoneException;
import stone.ast.ASTree;

public class NativeFunction {
    protected Method method;
    protected String name;
    protected int numParams;
    public NativeFunction(String n, Method m) {
        name = n;
        method = m;
        numParams = m.getParameterTypes().length;
    }
    @Override
    public String toString() {
        return "<native:" + hashCode() + ">";
    }
    public int numOfParameters() {
        return numParams;
    }

    /**
     * Run the java method. If static method, object = null.
     * @param args Object
     * @param tree Parameters
     * @return
     */
    public Object invoke(Object[] args, ASTree tree) {
        try {
            return method.invoke(null, args);
        } catch (Exception e) {
            throw new StoneException("bad native function call: " + name, tree);
        }
    }
}
