public class LetValExp extends Expr {
	public final String name;
    public final Expr expression1;
	public final Expr expression2;
    public LetValExp(String name,Expr expr1, Expr expr2) {
	this.name = name;
	this.expression1 = expr1;
	this.expression2 = expr2;
    }
    public Value eval(Env e) throws EvalError {
    	Value value1 = expression1.eval(e);
    	e=e.addBinding(name, value1);
    	Value value2 = expression2.eval(e);
    	return value2;
    	    }
    public String toString() {
	return String.valueOf(name);
    }
}
