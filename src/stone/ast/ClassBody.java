package stone.ast;
import java.util.List;
import chap6.Environment;

public class ClassBody extends ASTList {
    public ClassBody(List<ASTree> c) {
        super(c);
    }
    public Object eval(Environment env) {
        for (ASTree t: this)
            (t).eval(env);
        return null;
    }
}
