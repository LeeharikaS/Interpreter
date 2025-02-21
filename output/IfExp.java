public class IfExp extends Expr {
    public final Expr expression1;
	public final Expr expression2;
	public final Expr expression3;
    public IfExp(Expr expr1, Expr expr2, Expr expr3) {
	expression1 = expr1;
	expression2 = expr2;
	expression3 = expr3;
    }
    public Value eval(Env e) throws EvalError {
	Value value = expression1.eval(e);
	if(value instanceof BoolVal)
	{
		if(((BoolVal)value).value == true)
			return expression2.eval(e);
		else
			return expression3.eval(e);
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
