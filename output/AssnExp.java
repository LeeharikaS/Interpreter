public class AssnExp extends Expr {
    public final String final_value;
	public final Expr expression;
    public AssnExp(String _value, Expr expr) {
	final_value = _value;
	expression = expr;
    }
    public Value eval(Env e) throws EvalError {
    	Value value1 = e.lookup(final_value);
    	Value value = expression.eval(e);
    	if(value instanceof IntVal)
    	{
    		if(value1 instanceof IntVal)
    		{
    			e.updateBinding(final_value, value);
    			return value;
    		}
    		else
    		{
    			throw new EvalError("Type mismatch");
    		}
    	}
    	else if(value instanceof BoolVal)
    	{
    		if(value1 instanceof BoolVal)
    		{
    			e.updateBinding(final_value, value);
    			return value;
    		}
    		else
    		{
    			throw new EvalError("Type mismatch");
    		}
    	}
    	else if (value instanceof FunVal)
    	{
    		if(value1 instanceof FunVal)
    		{
    			e.updateBinding(final_value, value);
    			return value;
    		}
    		else
    		{
    			throw new EvalError("Type mismatch");
    		}
    	}
    	else throw new EvalError("Not a valid type");
    	
    }
    public String toString() {
	return String.valueOf(final_value);
    }
}