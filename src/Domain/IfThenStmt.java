package Domain;

/**
 * Created by Melisa on 09/11/2015.
 */
public class IfThenStmt implements IStmt {
    private Expr exp;
    private IStmt thenStmt;

    /**
     * Constructor
     * @param expression - expression to be evaluated
     * @param thenS - else statement
     */
    public IfThenStmt(Expr expression,  IStmt thenS) {
        exp = expression;
        thenStmt = thenS;
    }

    public IStmt getThenStmt() {

        return thenStmt;
    }

    public Expr getExpr() {

        return exp;
    }

    @Override
    public String toString() {
        return "if ( " + exp.toString() + " ) then ( " + thenStmt.toString() + ")";
    }

}
