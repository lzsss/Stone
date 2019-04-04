package stone.ast;
import java.util.List;
import chap6.Environment;

public abstract class Postfix extends ASTList {
    public Postfix(List<ASTree> c) {
        super(c);
    }
    public abstract Object eval(Environment env, Object value);
}