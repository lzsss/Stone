package stone.ast;
import chap6.Environment;

import java.util.List;

public class BlockStmnt extends ASTList {
    public BlockStmnt(List<ASTree> c) {
        super(c);
    }
    public Object eval(Environment env) {
        Object result = 0;
        for (ASTree t: this) {
            if (!(t instanceof NullStmnt))
                result = ((ASTree)t).eval(env);
        }
        return result;
    }
}
