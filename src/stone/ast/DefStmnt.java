package stone.ast;
import java.util.List;

import chap11.Symbols;
import chap6.Environment;
import chap7.Function;
public class DefStmnt extends ASTList {
    public DefStmnt(List<ASTree> c) {
        super(c);
    }
    public String name() {
        return ((ASTLeaf)child(0)).token.getText();
    }
    public ParameterList parameters() {
        return ((ParameterList)child(1));
    }
    public BlockStmnt body() {
        return (BlockStmnt)child(2);
    }
    public String toString() {
        return "(def" + name() + " " + parameters() + " " + body() + ")";
    }
    public Object eval(Environment env) {
        env.putNew(name(), new Function(parameters(), body(), env));
        return name();
    }
}
