public class SeqExp extends Expr {
    public final Expr expression1;
	public final Expr expression2;
    public SeqExp(Expr expr1, Expr expr2) {
	expression1 = expr1;
	expression2 = expr2;
    }
    public Value eval(Env e) throws EvalError {
	Value value1 = expression1.eval(e);
	return expression2.eval(e);
	
    }
    public String toString() {
	return null;
    }
}
