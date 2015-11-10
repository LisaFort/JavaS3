package Domain;

import Exceptions.UnsupportedOperator;
import Exceptions.VarNotFound;
import com.company.Dictionary;

/**
 * Created by Melisa on 09/11/2015.
 */
public class logicExpr extends Expr {
        Expr e1;
        Expr e2;
        String oper;

        /**
         * Constructor
         *
         * @param ee1 - first expression
         * @param op  - operator
         * @param ee2 - second expression
         */
        public logicExpr(Expr ee1, String op, Expr ee2) {
            e1 = new Expr();
            e1 = ee1;
            e2 = new Expr();
            e2 = ee2;
            oper = op;
        }

        /**
         * Evaluates the arithmetic expression and returns the int value
         *
         * @param tbl
         * @return
         * @throws VarNotFound
         */
        @Override
        public int eval(Dictionary tbl) throws VarNotFound {
            if (oper.equals("||")) {
                int ev1 = e1.eval(tbl);
                int ev2 = e2.eval(tbl);
                boolean b1, b2;
                if (ev1 == 0) {
                    b1 = false;
                } else b1 = true;
                if (ev2 == 0) {
                    b2 = false;
                } else b2 = true;
                boolean b3 = b1 || b2;
                if (b3 == false) {
                    return 0;
                } else return 1;
            }
            if (oper.equals("&&")) {
                int ev1 = e1.eval(tbl);
                int ev2 = e2.eval(tbl);
                boolean b1, b2;
                if (ev1 == 0) {
                    b1 = false;
                } else b1 = true;
                if (ev2 == 0) {
                    b2 = false;
                } else b2 = true;
                boolean b3 = b1 && b2;
                if (b3 == false) {
                    return 0;
                } else return 1;
            }
            if (oper.equals("!")) {
                int ev1 = e1.eval(tbl);
                boolean b1;
                if (ev1 == 0) {
                    b1 = false;
                } else b1 = true;
                if (b1 == false) {
                    return 1;
                } else return 0;
            }
            else {
                throw new UnsupportedOperator("Wrong operator ");
            }
        }

        @Override
        public String toString() {
            if (oper == "!") {
                return "!(" + e1.toString() + ")";
            } else {
                return "( " + e1.toString() + oper + e2.toString() + " )";
            }
        }

    }
