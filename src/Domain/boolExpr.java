package Domain;

import Exceptions.UnsupportedOperator;
import Exceptions.VarNotFound;
import com.company.Dictionary;

/**
 * Created by Melisa on 08/11/2015.
 */
public class boolExpr extends Expr  {
    Expr e1;
    Expr e2;
    String oper;

    /**
     * Constructor
     * @param ee1 - first expression
     * @param op - operator
     * @param ee2 - second expression
     */
    public boolExpr(Expr ee1, String op, Expr ee2) {
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
    public int eval(Dictionary tbl) throws VarNotFound {
        if ( oper.equals("<") ) {
            if (e1.eval(tbl) < e2.eval(tbl) ) {
                return 1;
            } else {
                return 0;
            }
        } else if ( oper.equals("<=")) {
            if ( e1.eval(tbl) <= e2.eval(tbl) ) {
                return 1;
            } else {
                return 0;
            }
        } else if ( oper.equals(">") ) {
            if ( e1.eval(tbl) > e2.eval(tbl) ) {
                return 1;
            } else {
                return 0;
            }
        } else if ( oper.equals(">=") ) {
            if ( e1.eval(tbl) >= e2.eval(tbl) ) {
                return 1;
            } else {
                return 0;
            }
        } else if ( oper.equals("!=") ) {
            if ( e1.eval(tbl) != e2.eval(tbl) ) {
                return 1;
            } else {
                return 0;
            }
        } else if (oper.equals("==")) {
            if (e1.eval(tbl) == e2.eval(tbl)) {
                return 1;
            } else {
                return 0;
            }
        }
           else{
                throw new UnsupportedOperator("Cant find the bool operator ");
            }
    };

    @Override
    public String toString() {
        return "( " + e1.toString() + oper + e2.toString() + " )";
    }
}
