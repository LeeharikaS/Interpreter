public class WhileExp extends Expr {
    public final Expr expression1;
	public final Expr expression2;
    public WhileExp(Expr expr1, Expr expr2) {
	expression1 = expr1;
	expression2 = expr2;
    }
    public Value eval(Env e) throws EvalError {
	Value value = expression1.eval(e);
	if(value instanceof BoolVal)
	{
		while(((BoolVal)expression1.eval(e)).value == true )
		{
			value = expression2.eval(e);
		}
		return value;
	}
	else
	{
		throw new EvalError("Given expression does not return a boolean value");
	}
    }
    public String toString() {
	return null;
    }
}
