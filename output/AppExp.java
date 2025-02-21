public class AppExp extends Expr {
	public final String name;
	public final Expr expression;
    public AppExp(String name,Expr expression) {
	this.name = name;
	this.expression = expression;
    }
    public Value eval(Env e) throws EvalError {
    	Value v = expression.eval(e);
    	Value value = e.lookup(name);
    	if(value instanceof FunVal)
    	{
    		Env denv = ((FunVal)value).environment.addBinding(((FunVal)value).value, v);
    		return ((FunVal)value).expression.eval(denv);
    	
    	}
    	else
    	{
    		throw new EvalError("Unbound environment error");
    	}
    }
    public String toString() {
	return null;
    }
}