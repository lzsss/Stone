package stone.ast;
import java.util.List;
import chap6.Environment;
import stone.*;
import chap7.Function;
import chap8.NativeFunction;

public class Arguments extends Postfix {
    public Arguments(List<ASTree> c) {
        super(c);
    }
    public int size() {
        return numChildren();
    }
    public Object eval(Environment callerEnv, Object value) {
        if (!(value instanceof NativeFunction))
            return eval1(callerEnv, value);

        NativeFunction func = (NativeFunction)value;
        int nparams = func.numOfParameters();
        if (size() != nparams)
            throw new StoneException("bad number of arguments", this);
        Object[] args = new Object[nparams];
        int num = 0;
        for (ASTree a: this) {
            ASTree ae = (ASTree)a;
            args[num++] = ae.eval(callerEnv);
        }
        return func.invoke(args, this);
    }
    public Object eval1(Environment callerEnv, Object value) {
        if (!(value instanceof Function))
            throw new StoneException("bad function", this);
        Function func = (Function)value;
        ParameterList params = func.parameters();
        if (size() != params.size())
            throw new StoneException("bad number of arguments", this);
        Environment newEnv = func.makeEnv();
        int num = 0;
        for (ASTree a: this)
            ((ParameterList)params).eval(newEnv, num++, ((ASTree)a).eval(callerEnv));
        return ((BlockStmnt)func.body()).eval(newEnv);
    }
}
