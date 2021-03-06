package stone.ast;
import chap11.Symbols;
import chap6.Environment;
import stone.StoneException;
import java.util.List;
import java.util.Iterator;

/**
 * The nodes contain child.
 */
public class ASTList extends ASTree{
    protected List<ASTree> children;
    public ASTList(List<ASTree> list) {
        children = list;
    }
    public ASTree child(int i) {
        return children.get(i);
    }
    public int numChildren(){
        return children.size();
    }
    public Iterator<ASTree> children() {
        return children.iterator();
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        String seq = "";
        for (ASTree t: children){
            builder.append(seq);
            seq = " ";
            builder.append(t.toString());
        }
        return builder.append(')').toString();
    }
    public String location() {
        for (ASTree t: children){
            String s = t.location();
            if (s != null){
                return s;
            }
        }
        return null;
    }
    public Object eval(Environment env) {
        throw new StoneException("cannot eval: " + toString(), this);
    }
    public void lookup(Symbols syms) {
        for (ASTree t: this)
            ((ASTree)t).lookup(syms);
    }
}
