public class FunVal extends Value {
    public final String value;
	public final Expr expression;
	public final Env environment;
    public FunVal(String _value, Expr expr, Env env) {
	value = _value;
	expression = expr;
	environment = env;
    }
    public String toString() {
	return String.valueOf(value);
    }
}
