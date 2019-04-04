package stone.ast;
import chap11.Symbols;
import chap6.Environment;

import java.util.Iterator;

/**
 * ASTree is an abstract class which could not be instantiated.
 * The implement of abstract methods are overridden in subclasses.
 *
 * So why not interface? When using interface & when using abstract class?
 * Answer:
 * Abstract class is an abstract of class;
 * Interface is an abstract of method.
 * Example: Animal -> Birds Animal is an abstract class of bird.
 *          Fly -> Birds Fly is an interface of bird, means bird could fly.
 * Abstract class indicates "is-a", interface indicates "like-a".
 * Here, it is better to use interface to describe ASTree.
 */
public abstract class ASTree implements Iterable<ASTree> {
    /**
     * return the ith child node.
     * @param i
     * @return
     */
    public abstract ASTree child(int i);

    /**
     * return the amounts of children, if null return 0.
     * @return
     */
    public abstract int numChildren();
    public abstract Iterator<ASTree> children();
    public abstract String location();
    // Adapter to return iterator<ASTree>. PS: Java is so cool.
    public Iterator<ASTree> iterator() {
        return children();
    }
    public abstract Object eval(Environment env);
    public void lookup(Symbols syms) {}
}
