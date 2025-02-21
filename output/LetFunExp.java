public class LetFunExp extends Expr {
	public final String name1;
	public final String name2;
    public final Expr expression1;
	public final Expr expression2;
    public LetFunExp(String name1,String name2,Expr expr1, Expr expr2) {
	this.name1 = name1;
	this.name2 = name2;
	this.expression1 = expr1;
	this.expression2 = expr2;
    }
    public Value eval(Env e) throws EvalError {
    	Env new_env = e.addBinding(name1, new IntVal(0));
    	FunVal val = new FunVal(name2,expression1,new_env);
    	Env new_env2 = new_env.updateBinding(name1, val);
    	Value value = expression2.eval(new_env2);
	return value;
    }
    public String toString() {
	return null;
    }
}
