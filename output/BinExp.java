public class BinExp extends Expr {
    public final BinOp operator;
	public final Expr expression1;
	public final Expr expression2;
    public BinExp(BinOp _opr, Expr expr1, Expr expr2) {
	operator = _opr;
	expression1 = expr1;
	expression2 = expr2;
    }
    public Value eval(Env e) throws EvalError {
    	if(operator == BinOp.AND)
    	{
    		if((expression1.eval(e) instanceof BoolVal ))
        	{
				if(((BoolVal)expression1.eval(e)).value == false){
					return new BoolVal(((BoolVal)expression1.eval(e)).value);
				}
				else if(expression2.eval(e) instanceof BoolVal){
					return new BoolVal(((BoolVal)expression2.eval(e)).value);
				}
                else throw new EvalError("Second value is an Integer");
           	}
    		else throw new EvalError("First value is an Integer");
    		
    	}
    	else if(operator == BinOp.OR)
    	{
    		if((expression1.eval(e) instanceof BoolVal ))
        	{
				if(((BoolVal)expression1.eval(e)).value == true){
					return new BoolVal(((BoolVal)expression1.eval(e)).value);
				}
				else if(expression2.eval(e) instanceof BoolVal){
					return new BoolVal(((BoolVal)expression2.eval(e)).value);
				}
                else throw new EvalError("Second value is an Integer");
           	}
    		else throw new EvalError("First value is an Integer");

       	}
    	else
    	{
    		Value value1 = expression1.eval(e);
        	Value value2 = expression2.eval(e);
        	
        	  switch(operator)
        	{
    	    	case PLUS:
    	    	{
    	    		if(value1 instanceof IntVal)
    	    		{
						if(value2 instanceof IntVal){
    	    			return new IntVal(((IntVal)value1).value + ((IntVal)value2).value);
						}
						else throw new EvalError("Value2 must be integer in PLUS");
    	    		}
    	    		else
    	    		{
    	    			throw new EvalError("Value1 must be integer in PLUS");
    	    		}
    	    	}
    	    	case MINUS:
    	    	{
    	    		if(value1 instanceof IntVal)
    	    		{
						if(value2 instanceof IntVal){
    	    			return new IntVal(((IntVal)value1).value - ((IntVal)value2).value);
						}
						else throw new EvalError("Value2 must be integer in MINUS");
    	    		}
    	    		else
    	    		{
    	    			throw new EvalError("Value1 must be integer in MINUS");
    	    		}
    	    	}
    	    	case TIMES:
    	    	{
    	    		if(value1 instanceof IntVal)
    	    		{
						if(value2 instanceof IntVal){
    	    			return new IntVal(((IntVal)value1).value * ((IntVal)value2).value);
						}
						else throw new EvalError("Value2 must be integer in TIMES");
    	    		}
    	    		else
    	    		{
    	    			throw new EvalError("Value1 must be integer in TIMES");
    	    		}
    	    	}
    	    	case DIV:
    	    	{
    	    		if(value1 instanceof IntVal)
    	    		{	if(value2 instanceof IntVal){
    	    			if(((IntVal)value2).value==0)
    	    			{
    	    				throw new EvalError("Division by 0 is not permitted");
    	    			}
    	    			else return new IntVal(((IntVal)value1).value / ((IntVal)value2).value);
						}
						else throw new EvalError("Value2 must be integer in DIV");
    	    			}
    	    		else
    	    		{
    	    			throw new EvalError("Value1 must be integer in DIV");
    	    		}
    	    	}
    	    	case EQ:
    	    	{
    	    		if(value1 instanceof IntVal)
    	    		{
						if(value2 instanceof IntVal){
    	    			return new BoolVal(((IntVal)value1).value == ((IntVal)value2).value); 
						}
						else throw new EvalError("Value2 must be integer in EQ");
    	    		}
    	    		else if(value1 instanceof BoolVal)
    	    		{ 		if(value2 instanceof BoolVal){
    	    			return new BoolVal(((BoolVal)value1).value == ((BoolVal)value2).value);
						}
						else throw new EvalError("Value2 must be Bool in EQ");
    	    		}
    	    		else
    	    		{
    	    			throw new EvalError("Value1 must be valid type in EQ");
    	    		}
    	    	}
    	    	case LT:
    	    	{
    	    		if(value1 instanceof IntVal)
    	    		{
						if(value2 instanceof IntVal){
    	    			return new BoolVal(((IntVal)value1).value < ((IntVal)value2).value);
						}
						else throw new EvalError("Value2 must be integer in LT");
    	    		}
    	    		else
    	    		{
    	    			throw new EvalError("Value1 must be integer in LT");
    	    		}
    	    	}
    	    	default:
    	    		throw new EvalError("Operator is not valid in BinExp");
        	}
        }

    	}
    	    public String toString() {
	return null;
    }
}
