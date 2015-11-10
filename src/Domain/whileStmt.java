package Domain;

/**
 * Created by Melisa on 09/11/2015.
 */
public class whileStmt implements IStmt {
        private Expr exp;
        private IStmt statement;

        public whileStmt(Expr exp, IStmt thenStatement) {
            this.exp = exp;
            this.statement = thenStatement;
        }

        public Expr getExpr() {
            return exp;
        }

        public IStmt getStmt() {
            return statement;
        }

        @Override
        public String toString() {
            return "WHILE " + exp.toString() + " THEN(" + statement.toString() + ") ";
        }

    }
