package Domain;

import Exceptions.DivByZero;
import Exceptions.UnsupportedOperator;
import Exceptions.VarNotFound;
import com.company.Dictionary;

/**
 * Created by Melisa on 11/10/2015.
 */
public class ArithExpr extends Expr {

    Expr e1;
    Expr e2;
    String oper;

    /**
     * Constructor
     * @param ee1 - first expression
     * @param op - operator
     * @param ee2 - second expression
     */
    public ArithExpr(Expr ee1, String op, Expr ee2) {
        e1 = new Expr();
        e1 = ee1;
        e2 = new Expr();
        e2 = ee2;
        oper = op;
    }

    /**
     * Evaluates the arithmetic expression and returns the int value
     * @param tbl
     * @return
     * @throws VarNotFound
     */
    @Override
    public int eval(Dictionary tbl) throws VarNotFound{
        if ( oper.equals("+") ) {
            return e1.eval(tbl) + e2.eval(tbl);
        } else if ( oper.equals("-")) {
            return e1.eval(tbl) - e2.eval(tbl);
        } else if ( oper.equals("*") ) {
            return e1.eval(tbl) * e2.eval(tbl);
        } else if ( oper.equals("/")){
            if ( e1.eval(tbl) == 0 || e2.eval(tbl) == 0) {
                throw new DivByZero("Exception divided by zero ");
            }
            return e1.eval(tbl) / e2.eval(tbl);
        } else throw new UnsupportedOperator("We cantfind the operator you have give ");
    };

    @Override
    public String toString() {
        return "( " + e1.toString() + oper + e2.toString() + " )";
    }
}
